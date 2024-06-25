package com.example.sima.service;

import com.example.sima.DTO.mq.AbstractResponseType;
import com.example.sima.SimaCodes;
import com.example.sima.domain.JMSRequest;
import com.example.sima.domain.SimaRequest;
import com.example.sima.domain.SimaResponse;
import com.example.sima.exception.SimaBusinessException;
import com.example.sima.exception.SimaResponseCodes;
import com.example.sima.utilities.SecurityUtility;
import com.example.sima.utilities.SimaUtility;
import com.fanap.util.DateUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

@Service
public class SimaResponseProcessorImpl implements SimaResponseProcessor {
    private static final Logger logger = LoggerFactory.getLogger(SimaRequestServiceImpl.class);

    private final SimaResponseService responseService;
    private final SimaRequestService requestService;

    public SimaResponseProcessorImpl(JMSRequestService jmsRequestService, SimaResponseService responseService, SimaRequestService requestService) {
        this.responseService = responseService;
        this.requestService = requestService;
    }

    @Override
    public void process(String message) throws Exception {
        // todo: SimaResponse is already processed?
        validateDuplicateResponse(message);

        // correlationId = messageId chera ?
        String correlationId = SimaUtility.extractCorrelationId(message);

        // todo: fetch user and set UserContext
        initialUserContextByMessageId(correlationId);

        // todo: log message
        SimaResponse simaResponse = responseService.saveResponse(message);

        // todo: create AbstractResponseType DTO
        AbstractResponseType abstractResponseType = SimaUtility.parseResponseStream(message);

        // todo: process message

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
}
