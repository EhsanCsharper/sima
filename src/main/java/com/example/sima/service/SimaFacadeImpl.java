package com.example.sima.service;

import com.example.sima.DTO.share.HasUserPermissionDTO;
import com.example.sima.DTO.share.SharedCustomerDTO;
import com.example.sima.config.security.model.UserContext;
import com.example.sima.config.security.model.UserContextHolder;
import com.example.sima.utilities.SecurityUtility;
import org.springframework.stereotype.Service;

@Service
public class SimaFacadeImpl implements SimaFacade {


    @Override
    public String getUserName() {
        //String userName = SimaConfigLoader.getProperty(SimaCodes.USER_NAME);
        // todo: createConfigLoader
        return "userName";
    }

    @Override
    public String getPassword() {
        //String password = SimaConfigLoader.getProperty(SimaCodes.PASSWORD);
        // todo: createConfigLoader
        return "password";
    }

    @Override
    public String getBranchCode() {
        //String branchCode = SimaConfigLoader.getProperty(SimaCodes.BRANCH_CODE);
        // todo: createConfigLoader
        return "branchCode";
    }

    @Override
    public String getSimaVersion() {
        // String version = SimaConfigLoader.getProperty(SimaCodes.VERSION);
        // todo: createConfigLoader
        return "version";
    }

    @Override
    public SharedCustomerDTO loadCustomer(long customerId) {
        // todo: call CustomerService
        // return fake SharedCustomerDTO
        SharedCustomerDTO customerDTO = new SharedCustomerDTO();
        customerDTO.setId(customerId);
        customerDTO.setCustomerNumber(customerId);
        customerDTO.setReal(true);
        customerDTO.setTitle("title");
        return customerDTO;
    }

    @Override
    public HasUserPermissionDTO hasUserPermissionInAuthorizedOperations(String operation) {
        UserContext userContext = SecurityUtility.getUserContext();
        // todo: call UserService
        // return fake Response
        HasUserPermissionDTO hasUserPermissionDTO = new HasUserPermissionDTO();
        hasUserPermissionDTO.setHasUserPermission(true);
        return hasUserPermissionDTO;
    }
}