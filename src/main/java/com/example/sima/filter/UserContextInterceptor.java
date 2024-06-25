package com.example.sima.filter;

import com.example.sima.config.security.model.UserContext;
import com.example.sima.config.security.model.UserContextHolder;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Objects;

@Component
public class UserContextInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(UserContextInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (Objects.isNull(authentication) || Objects.isNull(authentication.getName())) {
            throw new RuntimeException("authentication failed. UserContext can not be set.");
        }
        String username = authentication.getName();
        // todo: // get other data from user resource service
        UserContext userContext = UserContext.getBuilder()
                .setUsername(username)
                .setLoginBranchCode("1")
                .setFirstname("admin")
                .setLastname("admin")
                .build();
        UserContextHolder.setCurrentUserContext(userContext);
        logger.debug(UserContextHolder.getCurrentUserContext().toString() + "\r\n" + "set.");
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        logger.debug(UserContextHolder.getCurrentUserContext().toString() + "\r\n" + "removed.");
        UserContextHolder.clear();
    }
}
