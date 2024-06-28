package com.example.sima.service;

import com.example.sima.DTO.mq.AbstractResponseType;
import com.example.sima.SimaCodes;
import com.example.sima.config.ApplicationContextProvider;
import com.example.sima.domain.SimaRequest;
import com.example.sima.domain.SimaResponse;
import com.example.sima.exception.SimaBusinessException;
import com.example.sima.exception.SimaResponseCodes;
import com.example.sima.service.handler.SimaResponseHandler;
import com.example.sima.service.handler.customer.IsPartyBlockedResponseHandler;
import com.example.sima.utilities.SecurityUtility;
import com.example.sima.utilities.SimaUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SimaResponseProcessorImpl implements SimaResponseProcessor {
    private static final Logger logger = LoggerFactory.getLogger(SimaRequestServiceImpl.class);

    private final SimaResponseService responseService;
    private final SimaRequestService requestService;

    public SimaResponseProcessorImpl(SimaResponseService responseService, SimaRequestService requestService) {
        this.responseService = responseService;
        this.requestService = requestService;
    }

    @Override
    public void process(String message) throws Exception {
        // todo: is already processed?
        validateDuplicateResponse(message);

        // correlationId = messageId chera ?
        String correlationId = SimaUtility.extractCorrelationId(message);

        // todo: fetch user and set UserContext
        initialUserContextByMessageId(correlationId);

        // todo: log message
        SimaResponse simaResponse = responseService.saveResponse(message);

        // todo: create AbstractResponseType DTO
        AbstractResponseType abstractResponseType = SimaUtility.parseResponseStream(message);

        // todo: handel message
        SimaResponseHandler simaResponseHandler = createResponseHandler(simaResponse.getSimaRequest());
        simaResponseHandler.handelResponse(simaResponse, abstractResponseType);

    }

    //  ============================================================================================================================================================================================
    //  UTILITIES
    //  ============================================================================================================================================================================================

    private void validateDuplicateResponse(String message) throws SimaBusinessException {
        if (responseService.isResponseAlreadyExist(message)) {
            throw new SimaBusinessException(SimaResponseCodes.MESSAGE_HAS_BEEN_PROCESSED);
        }
    }

    private void initialUserContextByMessageId(String correlationId) {
        SimaRequest simaRequest = requestService.loadSimaRequestByMessageId(correlationId);
        SecurityUtility.setUserContext(simaRequest.getUserCode(), simaRequest.getBranchCode());
    }

    private SimaResponseHandler createResponseHandler(SimaRequest simaRequest) {
        String entityClassName = getEntityClassName(simaRequest);
        return getEntity(entityClassName);
    }

    private SimaResponseHandler getEntity(String entityClassName) {
        return (SimaResponseHandler) ApplicationContextProvider.getApplicationContext().getBean(entityClassName);
    }

    private String getEntityClassName(SimaRequest simaRequest) {
        String typeCode = simaRequest.getServiceType().getCode();
        return switch (typeCode) {
            case SimaCodes.SIMA_IS_PARTY_BLOCKED_REQUEST_TYPE -> IsPartyBlockedResponseHandler.class.getName();
            default -> {
                logger.warn(SimaResponseCodes.INVALID_SIMA_REQUEST_TYPE.getMessage());
                yield null;
            }
        };
    }
}
