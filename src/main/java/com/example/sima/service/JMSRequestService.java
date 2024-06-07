package com.example.sima.service;

import com.example.sima.domain.JMSRequest;
import com.example.sima.exception.SimaBusinessException;

public interface JMSRequestService {

    JMSRequest persistJMSRequest(String messageContent, String sequenceCode, String messageId, String correlationId, String key) throws SimaBusinessException;

    JMSRequest persistJMSRequest(String messageContent, String sequenceCode, String messageId, String correlationId) throws SimaBusinessException;

    JMSRequest persistJMSRequest(String messageContent, String sequenceCode, String messageId) throws SimaBusinessException;
}
