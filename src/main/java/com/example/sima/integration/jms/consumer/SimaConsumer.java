package com.example.sima.integration.jms.consumer;

import com.example.sima.config.security.model.UserContext;
import com.example.sima.config.security.model.UserContextHolder;
import com.example.sima.service.SimaResponseProcessor;
import com.example.sima.utilities.SecurityUtility;
import com.example.sima.utilities.SimaUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class SimaConsumer {
    private static final Logger logger = LoggerFactory.getLogger(SimaConsumer.class);

    private final SimaResponseProcessor responseProcessor;

    public SimaConsumer(SimaResponseProcessor responseProcessor) {
        this.responseProcessor = responseProcessor;
    }

    //@JmsListener(destination = "test")
    public void receiveMessage(String message) {
        Thread.startVirtualThread(() -> {
            try {
                logger.info(message);
                responseProcessor.process(message);
            } catch (Exception e) {
                String correlationId = SimaUtility.extractCorrelationId(message);
                logger.error("cid: " + correlationId + " error", e);
            }
        });
    }
}
