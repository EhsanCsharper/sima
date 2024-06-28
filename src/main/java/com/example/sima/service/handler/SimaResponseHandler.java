package com.example.sima.service.handler;

import com.example.sima.DTO.mq.AbstractResponseType;
import com.example.sima.DTO.mq.AckCodeType;
import com.example.sima.domain.SimaResponse;
import com.example.sima.exception.SimaBusinessException;
import com.example.sima.exception.SimaResponseCodes;

import java.util.Objects;

public interface SimaResponseHandler {
    void handelResponse(SimaResponse simaResponse, AbstractResponseType responseType) throws SimaBusinessException;

    default boolean isResponseSuccess(AbstractResponseType abstractResponseType) throws SimaBusinessException {
        if (Objects.nonNull(abstractResponseType) && AckCodeType.SUCCESS == abstractResponseType.getAck() && abstractResponseType.getErrors().isEmpty()) {
            return true;
        } else if (Objects.nonNull(abstractResponseType) && AckCodeType.FAILURE == abstractResponseType.getAck()) {
            return false;
        } else {
            throw new SimaBusinessException(SimaResponseCodes.SIMA_UNKNOWN_ERROR);
        }
    }
}
