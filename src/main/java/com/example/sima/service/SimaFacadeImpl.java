package com.example.sima.service;

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
}