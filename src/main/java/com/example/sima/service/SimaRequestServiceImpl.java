package com.example.sima.service;

import com.example.sima.DTO.mq.AbstractRequestType;
import com.example.sima.DTO.mq.PrincipalType;
import com.example.sima.SimaCodes;
import com.example.sima.config.log.CorrelationIDHelper;
import com.example.sima.domain.ConstantCategoryElement;
import com.example.sima.domain.JMSRequest;
import com.example.sima.domain.SimaRequest;
import com.example.sima.exception.SimaBusinessException;
import com.example.sima.exception.SimaResponseCodes;
import com.example.sima.repository.SimaRequestRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.Objects;
import java.util.UUID;

@Service
public class SimaRequestServiceImpl implements SimaRequestService {
    private static final Logger logger = LoggerFactory.getLogger(SimaRequestServiceImpl.class);
    private final SimaRequestRepository simaRequestRepository;
    private final SimaFacade simaFacade;
    private final JMSRequestService jmsRequestService;

    private final CategoryService categoryService;

    private final CorrelationIDHelper correlationIDHelper;

    public SimaRequestServiceImpl(SimaRequestRepository simaRequestRepository, SimaFacade simaFacade, JMSRequestService jmsRequestService, CategoryService categoryService, CorrelationIDHelper correlationIDHelper) {
        this.simaRequestRepository = simaRequestRepository;
        this.simaFacade = simaFacade;
        this.jmsRequestService = jmsRequestService;
        this.categoryService = categoryService;
        this.correlationIDHelper = correlationIDHelper;
    }

    @Override
    public SimaRequest createSimaRequest(ConstantCategoryElement requestType) {
        SimaRequest simaRequest = new SimaRequest();
        if (Objects.nonNull(requestType)) {
            simaRequest.setServiceType(requestType);
        }
        return simaRequest;
    }

    @Override
    public void persistSimaRequest(SimaRequest simaRequest, AbstractRequestType abstractRequestType) throws SimaBusinessException {
        JMSRequest jmsRequest = createSimaJMSRequest(abstractRequestType);
        fillSimaRequestInfoForSending(simaRequest, jmsRequest);
        simaRequestRepository.save(simaRequest);
    }

    @Override
    public SimaRequest loadSimaRequestByMessageId(String correlationId) {
        return simaRequestRepository.findByMessageId(correlationId);
    }

    //  ============================================================================================================================================================================================
    //  UTILITIES
    //  ============================================================================================================================================================================================

    private JMSRequest createSimaJMSRequest(AbstractRequestType abstractRequestType) throws SimaBusinessException {
        String messageId = prepareMessageId();
        String requestMessage = getMessageBody(abstractRequestType, messageId);
        JMSRequest jmsRequest = persistJMSRequest(requestMessage, messageId);
        return jmsRequest;
    }

    private String prepareMessageId() {
        return correlationIDHelper.getCorrelationID();
    }

    public String getMessageBody(AbstractRequestType abstractRequestType, String messageId) throws SimaBusinessException {
        try {
            String version = simaFacade.getSimaVersion();
            abstractRequestType.setMessageId(messageId);
            abstractRequestType.setTest(false);
            abstractRequestType.setVersion(version);
            fillPrincipalType(abstractRequestType);
            JAXBContext jaxbContext = JAXBContext.newInstance(AbstractRequestType.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, "http://modernisc.com/api/csd file:/F/:/Project/CSD/MQ/ISC-SSvc-2.0.xsd");
            StringWriter stringWriter = new StringWriter();
            marshaller.marshal(abstractRequestType, stringWriter);
            return stringWriter.toString();
        } catch (JAXBException e) {
            throw new SimaBusinessException(SimaResponseCodes.ERROR_IN_CREATE_SIMA_REQUEST);
        }
    }

    private void fillPrincipalType(AbstractRequestType abstractRequestType) {
        PrincipalType principalType = preparePrincipalType();
        abstractRequestType.setPrincipal(principalType);
    }

    private PrincipalType preparePrincipalType() {
        PrincipalType principalType = new PrincipalType();
        String branchCode = simaFacade.getBranchCode();
        String userName = simaFacade.getUserName();
        String password = simaFacade.getPassword();
        principalType.setBranchCode(branchCode);
        principalType.setUsername(userName);
        principalType.setPassword(password);
        return principalType;
    }

    private JMSRequest persistJMSRequest(String requestMessage, String messageId) throws SimaBusinessException {
        String sequenceCode = SimaCodes.SIMA_SEQUENCE_CODE;
        JMSRequest jmsRequest = jmsRequestService.persistJMSRequest(requestMessage, sequenceCode, messageId);
        return jmsRequest;
    }

    private void fillSimaRequestInfoForSending(SimaRequest simaRequest, JMSRequest jmsRequest) throws SimaBusinessException {
        if (Objects.nonNull(simaRequest)) {
            ConstantCategoryElement registeredStatus = categoryService.getCategoryElement(SimaCodes.SIMA_REQUEST_REGISTERED_STATUS);
            simaRequest.setStatus(registeredStatus);
            if (Objects.nonNull(jmsRequest)) {
                simaRequest.setJmsRequest(jmsRequest);
            }
        }
    }
}
