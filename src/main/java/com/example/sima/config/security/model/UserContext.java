package com.example.sima.config.security.model;

import org.springframework.security.core.Authentication;

public class UserContext {
    private String  username;
    private String loginBranchCode;
    private String firstName;
    private String lastName;

    public UserContext(UserContextBuilder userContextBuilder) {
        this.username = userContextBuilder.username;
        this.loginBranchCode = userContextBuilder.loginBranchCode;
        this.firstName = userContextBuilder.firstname;
        this.lastName = userContextBuilder.lastname;
    }

    public String getUsername() {
        return username;
    }

    public String getLoginBranchCode() {
        return loginBranchCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public static UserContextBuilder getBuilder() {
        return new UserContextBuilder();
    }

    public static class UserContextBuilder {
        private String username;
        private String loginBranchCode;
        private String firstname;
        private String lastname;
        private Authentication authentication;

        public UserContextBuilder setUsername(String username) {
            this.username = username;
            return this;
        }

        public UserContextBuilder setLoginBranchCode(String loginBranchCode) {
            this.loginBranchCode = loginBranchCode;
            return this;
        }

        public UserContextBuilder setFirstname(String firstname) {
            this.firstname = firstname;
            return this;
        }

        public UserContextBuilder setLastname(String lastname) {
            this.lastname = lastname;
            return this;
        }

        public UserContext build() {
            return new UserContext(this);
        }
    }

    @Override
    public String toString() {
        return "UserContext{" +
                "username='" + username + '\'' +
                ", loginBranchCode='" + loginBranchCode + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
