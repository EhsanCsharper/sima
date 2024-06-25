package com.example.sima.service;

import com.example.sima.DTO.mq.AbstractResponseType;
import com.example.sima.DTO.mq.AckCodeType;
import com.example.sima.DTO.mq.ErrorType;
import com.example.sima.SimaCodes;
import com.example.sima.domain.*;
import com.example.sima.exception.SimaBusinessException;
import com.example.sima.exception.SimaResponseCodes;
import com.example.sima.repository.SimaResponseRepository;
import com.example.sima.utilities.SimaUtility;
import com.fanap.util.DateUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SimaResponseServiceImpl implements SimaResponseService {

    private static final Logger logger = LoggerFactory.getLogger(SimaResponseService.class);

    private final SimaResponseRepository responseRepository;

    private final JMSRequestService jmsRequestService;
    private final CategoryService categoryService;
    private final SimaRequestService requestService;

    public SimaResponseServiceImpl(SimaResponseRepository responseRepository, JMSRequestService jmsRequestService, CategoryService categoryService, SimaRequestService requestService) {
        this.responseRepository = responseRepository;
        this.jmsRequestService = jmsRequestService;
        this.categoryService = categoryService;
        this.requestService = requestService;
    }

    @Override
    public void persistSimaResponse(SimaResponse simaResponse, JMSRequest jmsRequest) throws SimaBusinessException {

    }

    @Override
    public AbstractResponseType getSimaResponse(Long requestId) throws SimaBusinessException {
        return null;
    }

    @Override
    public SimaResponse getSimaResponseById(Long responseId) {
        return null;
    }

    @Override
    public SimaResponse createAndPersistFakeReverseSimaResponse(SimaRequest simaRequest, boolean isSuccessful) throws SimaBusinessException {
        return null;
    }

    @Override
    public boolean isResponseAlreadyExist(String responseMessage) {
        String checkSum = DigestUtils.md5Hex(responseMessage);
        Optional<SimaResponse> optionalSimaResponse = responseRepository.findByCheckSUM(checkSum);
        return optionalSimaResponse.isPresent();
    }

    @Override
    public SimaResponse saveResponse(String responseMessage) throws SimaBusinessException {
        SimaResponse simaResponse = createSimaResponse(responseMessage);
        responseRepository.save(simaResponse);
        return simaResponse;
    }

    //  ============================================================================================================================================================================================
    //  UTILITIES
    //  ============================================================================================================================================================================================

    private SimaResponse createSimaResponse(String responseMessage) throws SimaBusinessException {
        String correlationId = SimaUtility.extractCorrelationId(responseMessage);
        SimaRequest simaRequest = requestService.loadSimaRequestByMessageId(correlationId);
        JMSRequest jmsResponse = jmsRequestService.createJmsRequest(responseMessage, SimaCodes.SIMA_SEQUENCE_CODE, correlationId, correlationId, correlationId);
        AbstractResponseType abstractResponseType = SimaUtility.parseResponseStream(responseMessage);
        ConstantCategoryElement ack = getSimaResponseAckStatus(abstractResponseType);
        SimaResponse simaResponse = new SimaResponse();
        simaResponse.setAckStatus(ack);
        simaResponse.setCheckSUM(DigestUtils.md5Hex(responseMessage));
        simaResponse.setJmsRequest(jmsResponse);
        simaResponse.setSimaRequest(simaRequest);
        simaRequest.setSimaResponse(simaResponse);
        simaResponse.setSimaResponseErrors(prepareSimaResponseError(abstractResponseType.getErrors()));
        return simaResponse;
    }

    private ConstantCategoryElement getSimaResponseAckStatus(AbstractResponseType abstractResponseType) throws SimaBusinessException {
        ConstantCategoryElement success = categoryService.getCategoryElement(SimaCodes.SIMA_RESPONSE_SUCCESS_ACK);
        ConstantCategoryElement failure = categoryService.getCategoryElement(SimaCodes.SIMA_RESPONSE_FAILURE_ACK);
        ConstantCategoryElement warning = categoryService.getCategoryElement(SimaCodes.SIMA_RESPONSE_WARNING_ACK);
        AckCodeType ack = abstractResponseType.getAck();
        return switch (ack) {
            case SUCCESS -> success;
            case FAILURE -> failure;
            case WARNING -> warning;
            default -> throw new SimaBusinessException(SimaResponseCodes.INVALID_SIMA_RESPONSE_STATUS);
        };
    }

    private List<SimaResponseError> prepareSimaResponseError(List<ErrorType> errors) {
        String dateTime = DateUtil.getCurrentDateTimeString();
        List<SimaResponseError> simaResponseErrorList = new ArrayList<>();
        for (ErrorType error : errors) {
            SimaResponseError simaResponseError = new SimaResponseError();
            String message = generateMessageWithParams(error);
            simaResponseError.setCreationDateTime(dateTime);
            simaResponseError.setLastModifiedDateTime(dateTime);
            simaResponseError.setCode(error.getCode());
            simaResponseError.setMessage(message);
            simaResponseErrorList.add(simaResponseError);
        }
        return simaResponseErrorList;
    }

    private String generateMessageWithParams(ErrorType error) {
        String message = error.getMessage();
        int i = 0;
        for (String param : error.getErrorParams()) {
            String index = "{" + i + "}";
            if (message.contains(index))
                message = message.replace(index, "'".concat(param).concat("'"));
            else
                message.concat(" <").concat(param).concat(">");
            i++;
        }
        return message;
    }
}
