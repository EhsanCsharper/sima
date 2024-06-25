package com.example.sima.utilities;

import com.example.sima.config.security.model.UserContext;
import com.example.sima.config.security.model.UserContextHolder;

public class SecurityUtility {
    public static void setUserContext(String username, String branchCode) {
        // todo: get other data from user resource service
        UserContext userContext = UserContext.getBuilder()
                .setUsername(username)
                .setLoginBranchCode(branchCode)
                .setFirstname("admin")
                .setLastname("admin")
                .build();
        UserContextHolder.setCurrentUserContext(userContext);
    }

    public static void setUserContextForMacro() {
        // todo: get other data from user resource service
        UserContext userContext = UserContext.getBuilder()
                .setUsername("macro")
                .setLoginBranchCode("1")
                .setFirstname("admin")
                .setLastname("admin")
                .build();
        UserContextHolder.setCurrentUserContext(userContext);
    }

    public static UserContext getUserContext() {
        return UserContextHolder.getCurrentUserContext();
    }
}
