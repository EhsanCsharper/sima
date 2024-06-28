package com.example.sima.service;

import com.example.sima.DTO.mq.IdentifierType;
import com.example.sima.DTO.request.SimaCustomerRequestDTO;
import com.example.sima.domain.SimaCustomer;
import com.example.sima.exception.SimaBusinessException;

public interface SimaCustomerService {
    long sendIsPartyBlockedRequest(SimaCustomerRequestDTO requestDTO) throws SimaBusinessException;

    SimaCustomer loadSimaCustomer(SimaCustomerRequestDTO requestDTO) throws SimaBusinessException;

    IdentifierType getIdentifier(SimaCustomer simaCustomer) throws SimaBusinessException;

    SimaCustomer loadCustomerByRequestId(long requestId);
}
