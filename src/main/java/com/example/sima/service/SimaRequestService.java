package com.example.sima.service;

import com.example.sima.DTO.mq.AbstractRequestType;
import com.example.sima.domain.ConstantCategoryElement;
import com.example.sima.domain.SimaRequest;
import com.example.sima.exception.SimaBusinessException;

public interface SimaRequestService {
    SimaRequest createSimaRequest(ConstantCategoryElement requestType);

    void persistSimaRequest(SimaRequest simaRequest, AbstractRequestType abstractRequestType) throws SimaBusinessException;
}
