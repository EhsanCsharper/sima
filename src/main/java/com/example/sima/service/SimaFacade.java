package com.example.sima.service;

import com.example.sima.DTO.share.HasUserPermissionDTO;
import com.example.sima.DTO.share.SharedCustomerDTO;

public interface SimaFacade {

    String getUserName();

    String getPassword();

    String getBranchCode();

    String getSimaVersion();

    SharedCustomerDTO loadCustomer(long customerId);

    HasUserPermissionDTO hasUserPermissionInAuthorizedOperations(String operation);

}
