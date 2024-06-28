package com.example.sima.service.handler.customer;

import com.example.sima.DTO.mq.AbstractResponseType;
import com.example.sima.DTO.mq.IsPartyBlockedResponseType;
import com.example.sima.SimaCodes;
import com.example.sima.domain.ConstantCategoryElement;
import com.example.sima.domain.SimaCustomer;
import com.example.sima.domain.SimaResponse;
import com.example.sima.exception.SimaBusinessException;
import com.example.sima.repository.SimaCustomerRepository;
import com.example.sima.service.CategoryService;
import com.example.sima.service.SimaCustomerService;
import com.example.sima.service.handler.SimaResponseHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("IsPartyBlocked")
public class IsPartyBlockedResponseHandler implements SimaResponseHandler {

    private static final Logger logger = LoggerFactory.getLogger(IsPartyBlockedResponseHandler.class);

    private final CategoryService categoryService;
    private final SimaCustomerRepository customerRepository;

    public IsPartyBlockedResponseHandler(CategoryService categoryService, SimaCustomerRepository customerRepository) {
        this.categoryService = categoryService;
        this.customerRepository = customerRepository;
    }

    @Override
    public void handelResponse(SimaResponse simaResponse, AbstractResponseType responseType) throws SimaBusinessException {
        IsPartyBlockedResponseType isPartyBlockedResponseType = (IsPartyBlockedResponseType) responseType;
        SimaCustomer simaCustomer = customerRepository.findByRequestId(simaResponse.getSimaRequest().getId());
        if (isResponseSuccess(responseType)) {
            ConstantCategoryElement currentStatus = getCurrentStatus(isPartyBlockedResponseType);
            simaCustomer.setStatus(currentStatus);
        }
        simaCustomer.setLastSimaResponse(simaResponse);
        customerRepository.save(simaCustomer);
        // send notification
        sendNotification(simaCustomer, simaResponse, responseType);

    }

    private void sendNotification(SimaCustomer simaCustomer, SimaResponse simaResponse, AbstractResponseType responseType) throws SimaBusinessException {
        // prepare notification message
        String notificationMessage = prepareNotificationMessage(simaCustomer, simaResponse, responseType);
        // send notification
        // todo: send notification

    }

    //  ============================================================================================================================================================================================
    //  UTILITIES
    //  ============================================================================================================================================================================================

    private ConstantCategoryElement getCurrentStatus(IsPartyBlockedResponseType isPartyBlockedResponseType) throws SimaBusinessException {
        ConstantCategoryElement status;
        if (isPartyBlockedResponseType.getBlocked()) {
            status = categoryService.getCategoryElement(SimaCodes.SIMA_CUSTOMER_BLOCK_STATUS);
        } else {
            status = categoryService.getCategoryElement(SimaCodes.SIMA_CUSTOMER_ACTIVE_STATUS);
        }
        return status;
    }

    public String prepareNotificationMessage(SimaCustomer simaCustomer, SimaResponse simaResponse, AbstractResponseType abstractResponseType) throws SimaBusinessException {
        String message = null;
        String requestTypeCode = simaResponse.getSimaRequest().getServiceType().getCode();
        if (requestTypeCode.equals(SimaCodes.SIMA_IS_PARTY_BLOCKED_REQUEST_TYPE)) {
            IsPartyBlockedResponseType isPartyBlockedResponseType = (IsPartyBlockedResponseType) abstractResponseType;
            if (isResponseSuccess(abstractResponseType)) {
                if (isPartyBlockedResponseType.getBlocked()) {
                    message = "وضعیت مشتری " + simaCustomer.getCustomer() + " با شناسه " + simaCustomer.getIdentifier() + " در سامانه سیما مسدود می باشد.";
                } else {
                    message = "وضعیت مشتری " + simaCustomer.getCustomer() + " با شناسه " + simaCustomer.getIdentifier() + " در سامانه سیما فعال می باشد.";
                }
            } else {
                message = "بررسی وضعیت مشتری " + simaCustomer.getCustomer() + " با شناسه " + simaCustomer.getIdentifier() + " در سامانه سیما با خطا مواجه شد.";
            }
        }
        return message;
    }
}
