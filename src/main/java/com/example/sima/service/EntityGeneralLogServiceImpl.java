package com.example.sima.service;

import com.example.sima.SharedCodes;
import com.example.sima.config.security.model.UserContext;
import com.example.sima.config.security.model.UserContextHolder;
import com.example.sima.domain.log.EntityGeneralLog;
import com.example.sima.repository.EntityGeneralLogRepository;
import com.fanap.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class EntityGeneralLogServiceImpl implements EntityGeneralLogService {
    private static final Logger logger = LoggerFactory.getLogger(EntityGeneralLogServiceImpl.class);

    private final EntityGeneralLogRepository repository;


    public EntityGeneralLogServiceImpl(EntityGeneralLogRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(EntityGeneralLog generalLog) {
        UserContext userContext = UserContextHolder.getCurrentUserContext();
        generalLog.setDate(DateUtil.getCurrentDate());
        generalLog.setTime(DateUtil.getCurrentDateTime()[1]);
        generalLog.setUserCode(userContext.getUsername());
        generalLog.setUserFirstName(userContext.getFirstName());
        generalLog.setUserLastName(userContext.getLastName());
        generalLog.setBranchCode(userContext.getLoginBranchCode());
        // todo: implement transactionCode generation
        // generalLog.setTransactionCode("someCode");
        repository.save(generalLog);
    }
}
