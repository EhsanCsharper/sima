package com.example.sima.service;

import com.example.sima.DTO.mq.*;
import com.example.sima.DTO.request.SimaCustomerRequestDTO;
import com.example.sima.SimaCodes;
import com.example.sima.domain.ConstantCategoryElement;
import com.example.sima.domain.SimaCustomer;
import com.example.sima.domain.SimaRequest;
import com.example.sima.domain.SimaResponse;
import com.example.sima.domain.log.SimaCustomerLog;
import com.example.sima.exception.SimaBusinessException;
import com.example.sima.exception.SimaResponseCodes;
import com.example.sima.repository.SimaCustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class SimaCustomerServiceImpl implements SimaCustomerService{

    private final CategoryService categoryService;
    private final SimaRequestService simaRequestService;
    private final SimaCustomerRepository customerRepository;
    private final EntityGeneralLogService entityGeneralLogService;
    private final SimaJMSService simaJMSService;

    public SimaCustomerServiceImpl(CategoryService categoryService, SimaRequestService simaRequestService, SimaCustomerRepository simaCustomerRepository, EntityGeneralLogService entityGeneralLogService, SimaJMSService simaJMSService) {
        this.categoryService = categoryService;
        this.simaRequestService = simaRequestService;
        this.customerRepository = simaCustomerRepository;
        this.entityGeneralLogService = entityGeneralLogService;
        this.simaJMSService = simaJMSService;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public long sendIsPartyBlockedRequest(SimaCustomerRequestDTO requestDTO) throws SimaBusinessException {
        ConstantCategoryElement operation = categoryService.getCategoryElement(SimaCodes.SEND_SIMA_IS_PARTY_BLOCKED_REQUEST_OPERATION_TYPE);
        ConstantCategoryElement requestType = categoryService.getCategoryElement(SimaCodes.SIMA_IS_PARTY_BLOCKED_REQUEST_TYPE);
        SimaRequest simaRequest = simaRequestService.createSimaRequest(requestType);
        SimaCustomer simaCustomer = loadSimaCustomer(requestDTO);
        AbstractRequestType abstractRequestType = createSimaIsPartyBlockedRequestType(simaCustomer);
        persistSimaRequestAndLockAndUpdateCustomerLastRequest(simaCustomer, simaRequest, abstractRequestType, operation);
        return simaRequest.getId();
    }

    @Override
    public SimaCustomer loadSimaCustomer(SimaCustomerRequestDTO requestDTO) throws SimaBusinessException {
        Optional<SimaCustomer> simaCustomerOptional = customerRepository.findByIdentifierAndIdentifierType(requestDTO.getIdentifier(), requestDTO.getIdentifierTypeCode());
        if (simaCustomerOptional.isEmpty()) {
            throw new SimaBusinessException(SimaResponseCodes.INVALID_SIMA_CUSTOMER_IDENTIFIER);
        }
        return simaCustomerOptional.get();
    }

    @Override
    public IdentifierType getIdentifier(SimaCustomer simaCustomer) throws SimaBusinessException {
        ConstantCategoryElement realCustomer =  categoryService.getCategoryElement(SimaCodes.SIMA_CUSTOMER_IDENTIFIER_CODE_TYPE);
        ConstantCategoryElement realForeignCustomer = categoryService.getCategoryElement(SimaCodes.SIMA_FOREIGN_CUSTOMER_NATIONAL_CODE_TYPE);
        ConstantCategoryElement legalCustomer = categoryService.getCategoryElement(SimaCodes.SIMA_CUSTOMER_NATIONAL_CODE_TYPE);
        ConstantCategoryElement identifierType = simaCustomer.getIdentifierType();
        IdentifierType identifier = new IdentifierType();
        identifier.setValue(simaCustomer.getIdentifier());
        if (realCustomer.getId() == identifierType.getId()) {
            identifier.setType(IdentifierClassType.NATIONAL_CODE);
        } else if (realForeignCustomer.getId() == identifierType.getId()) {
            identifier.setType(IdentifierClassType.FIDA);
        } else if (legalCustomer.getId() == identifierType.getId()) {
            identifier.setType(IdentifierClassType.NATIONAL_ID);
        }
        return identifier;
    }

    @Override
    public SimaCustomer loadCustomerByRequestId(long requestId) {
        return customerRepository.findByRequestId(requestId);
    }

    //  ============================================================================================================================================================================================
    //  UTILITIES
    //  ============================================================================================================================================================================================

    private AbstractRequestType createSimaIsPartyBlockedRequestType(SimaCustomer simaCustomer) throws SimaBusinessException {
        IsPartyBlockedRequestType isPartyBlockedRequestType = new IsPartyBlockedRequestType();
        IdentifierType identifier = getIdentifier(simaCustomer);
        isPartyBlockedRequestType.setIdentifier(identifier);
        return isPartyBlockedRequestType;
    }

    protected void persistSimaRequestAndLockAndUpdateCustomerLastRequest(SimaCustomer simaCustomer, SimaRequest simaRequest, AbstractRequestType abstractRequestType, ConstantCategoryElement operation) throws SimaBusinessException {
        simaRequestService.persistSimaRequest(simaRequest, abstractRequestType);
        SimaCustomer loadedCustomer = customerRepository.findById(simaCustomer.getId()).get();
        persistSimaCustomerSendRequestLog(loadedCustomer, simaRequest, operation);
        loadedCustomer.setLastSimaRequest(simaRequest);
        customerRepository.save(loadedCustomer);
        simaJMSService.sendMessage(simaRequest.getJmsRequest().getMessageBody());
    }

    private void persistSimaCustomerSendRequestLog(SimaCustomer simaCustomer, SimaRequest simaRequest, ConstantCategoryElement operation) {
        SimaCustomerLog simaCustomerLog = new SimaCustomerLog();
        simaCustomerLog.setSimaCustomer(simaCustomer);
        simaCustomerLog.setSimaRequest(simaRequest);
        simaCustomerLog.setOperation(operation);
        entityGeneralLogService.save(simaCustomerLog);
    }
}
