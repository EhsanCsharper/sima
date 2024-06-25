package com.example.sima.service;

import com.example.sima.DTO.mq.AbstractResponseType;
import com.example.sima.domain.JMSRequest;
import com.example.sima.domain.SimaRequest;
import com.example.sima.domain.SimaResponse;
import com.example.sima.exception.SimaBusinessException;

public interface SimaResponseService {

    void persistSimaResponse(SimaResponse simaResponse, JMSRequest jmsRequest) throws SimaBusinessException;

    AbstractResponseType getSimaResponse(Long requestId) throws SimaBusinessException;

    SimaResponse getSimaResponseById(Long responseId);

    SimaResponse createAndPersistFakeReverseSimaResponse(SimaRequest simaRequest, boolean isSuccessful) throws SimaBusinessException;

    boolean isResponseAlreadyExist(String responseMessage);

    SimaResponse saveResponse(String responseMessage) throws SimaBusinessException;
}
