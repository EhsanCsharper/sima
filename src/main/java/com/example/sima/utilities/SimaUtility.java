package com.example.sima.utilities;

import com.example.sima.DTO.mq.AbstractRequestType;
import com.example.sima.DTO.mq.AbstractResponseType;
import com.example.sima.exception.SimaBusinessException;
import com.example.sima.exception.SimaResponseCodes;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.StringReader;

@Service
public class SimaUtility {

    private static final Logger logger = LoggerFactory.getLogger(SimaUtility.class);

    public static AbstractResponseType parseResponseStream(String responseMessage) throws SimaBusinessException {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(AbstractResponseType.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            String xml = responseMessage;
            int index = xml.indexOf("<?xml");
            if (index > -1) {
                xml = xml.substring(index);
            }
            StringReader xmlReader = new StringReader(xml);
            AbstractResponseType abstractResponseType = ((JAXBElement<AbstractResponseType>) jaxbUnmarshaller.unmarshal(xmlReader)).getValue();
            return abstractResponseType;
        } catch (JAXBException e) {
            throw new SimaBusinessException(SimaResponseCodes.SIMA_UNKNOWN_ERROR, " " + e.getMessage());
        }
    }

    public static AbstractRequestType parseRequestStream(String requestMessage) throws SimaBusinessException {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(AbstractRequestType.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            String xml = requestMessage;
            int index = xml.indexOf("<?xml");
            if (index > -1) {
                xml = xml.substring(index);
            }
            StringReader xmlReader = new StringReader(xml);
            AbstractRequestType abstractRequestType = ((JAXBElement<AbstractRequestType>) jaxbUnmarshaller.unmarshal(xmlReader)).getValue();
            return abstractRequestType;
        } catch (JAXBException e) {
            throw new SimaBusinessException(SimaResponseCodes.SIMA_UNKNOWN_ERROR, " " + e.getMessage());
        }
    }

    public static String extractCorrelationId(String messageBody) {
        int firstIndex = messageBody.toLowerCase().indexOf("<correlationid>") + 15;
        int lastIndex = messageBody.toLowerCase().indexOf("</correlationid>");
        String correlationId = messageBody.substring(firstIndex, lastIndex);
        logger.info("<correlationid>  : " + correlationId);
        return correlationId;
    }
}
