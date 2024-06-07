package com.example.sima.service;

import com.example.sima.SimaCodes;
import com.example.sima.domain.ConstantCategoryElement;
import com.example.sima.domain.JMSRequest;
import com.example.sima.exception.SimaBusinessException;
import com.example.sima.repository.JMSRequestRepository;
import com.fanap.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class JMSRequestServiceImpl implements JMSRequestService{

    private static final Logger logger = LoggerFactory.getLogger(JMSRequestServiceImpl.class);

    private final CategoryService categoryService;

    private final JMSRequestRepository jmsRequestRepository;

    public JMSRequestServiceImpl(CategoryService categoryService, JMSRequestRepository jmsRequestRepository) {
        this.categoryService = categoryService;
        this.jmsRequestRepository = jmsRequestRepository;
    }

    @Override
    public JMSRequest persistJMSRequest(String messageContent, String sequenceCode, String messageId, String correlationId, String key) throws SimaBusinessException {
        JMSRequest jmsRequest = new JMSRequest();
        String dateTime = DateUtil.getCurrentDateTimeString();
        ConstantCategoryElement status = categoryService.getCategoryElement(SimaCodes.MQ_REQUEST_NOT_PROCEED);
        logger.info("correlationId  : " + correlationId);
        jmsRequest.setMessageId(messageId);
        jmsRequest.setCorrelationId(correlationId);
        jmsRequest.setSequenceCode(sequenceCode);
        jmsRequest.setDateTime(dateTime);
        jmsRequest.setKey(key);
        jmsRequest.setStatus(status);
        jmsRequest.setMessageBody(messageContent);
        jmsRequestRepository.save(jmsRequest);
        return jmsRequest;
    }



    @Override
    public JMSRequest persistJMSRequest(String messageContent, String sequenceCode, String messageId, String correlationId) throws SimaBusinessException {
        return persistJMSRequest(messageContent, sequenceCode, messageId, correlationId, null);
    }

    @Override
    public JMSRequest persistJMSRequest(String messageContent, String sequenceCode, String messageId) throws SimaBusinessException {
        return persistJMSRequest(messageContent, sequenceCode, messageId, null, null);
    }
}
