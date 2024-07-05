package com.example.sima.service;

import com.example.sima.exception.SimaBusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class SimaJMSServiceImpl implements SimaJMSService {
    private static final Logger logger = LoggerFactory.getLogger(SimaJMSServiceImpl.class);

    @Value("${sima.jms.destination}")
    private String destination;

    private final JmsTemplate jmsTemplate;

    public SimaJMSServiceImpl(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @Override
    public void sendMessage(String messageBody) throws SimaBusinessException {
        try {
            jmsTemplate.convertAndSend(destination, messageBody , message -> {
                logger.info("message sent to destination: " + destination + ", messageId: " + message.getJMSMessageID() + ", messageCorrelationId: " + message.getJMSCorrelationID() + ", messageBody: " + messageBody);
                return message;
            });
        } catch (JmsException e) {
            logger.error("unable send message to destination: " + destination, e);
            throw new SimaBusinessException("خطا در ارسال اطلاعات به بانک مرکزی", e);
        }
    }
}
