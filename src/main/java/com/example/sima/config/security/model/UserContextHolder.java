package com.example.sima.config.security.model;

public class UserContextHolder {
    private static final ThreadLocal<UserContext> currentUserContext = new ThreadLocal<>();

    public static UserContext getCurrentUserContext() {
        return currentUserContext.get();
    }

    public static void setCurrentUserContext(UserContext userContext) {
        currentUserContext.set(userContext);
    }

    public static void clear() {
        currentUserContext.remove();
    }
}
