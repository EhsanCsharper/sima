package com.example.sima.config.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.core.oidc.OidcScopes;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class ApiSecurityConfiguration {

    @Value("${sima.security.sso}")
    private boolean isSsoEnable;

    @Value("${jwksUri}")
    private String jwksUri;

    @Bean
    public SecurityFilterChain ApiSecurityFilterChain(HttpSecurity httpSecurity) throws Exception {
        if (isSsoEnable) {
            httpSecurity
                    .authorizeHttpRequests(a -> a.requestMatchers(
                            new AntPathRequestMatcher("/api/**")
                    ).authenticated())
                    .oauth2ResourceServer(r -> r.jwt(c -> {
                        c.jwkSetUri(jwksUri);
                        c.jwtAuthenticationConverter(new CustomJwtAuthenticationTokenConverter());
                    }))
                    .authorizeHttpRequests(a -> a.requestMatchers(
                            m -> !m.getRequestURI().contains("api")
                    ).authenticated())
                    .oauth2Login(Customizer.withDefaults());
            return httpSecurity.build();
        } else {
            return httpSecurity.userDetailsService(userDetailsService()).authorizeHttpRequests(a -> a.anyRequest().permitAll()).httpBasic(Customizer.withDefaults()).build();
        }
    }

    public UserDetailsService userDetailsService() {
        return new InMemoryUserDetailsManager(User.withUsername("admin").password("admin").authorities("read").build());
    }

    @Bean
    @Profile("dev")
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }


    @Bean
    public ClientRegistrationRepository clientRegistrationRepository() {
        return new InMemoryClientRegistrationRepository(demoASClientRegistration());
    }

    private ClientRegistration demoASClientRegistration() {
        return ClientRegistration.withRegistrationId("simaASClient")
                .clientId("client")
                .clientSecret("secret")
                .clientName("simaASClient")
                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
                .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
                .scope(OidcScopes.OPENID)
                .redirectUri("http://192.168.3.218:8080/login/oauth2/code/simaASClient")
                .authorizationUri("http://localhost:7070/oauth2/authorize")
                .tokenUri("http://localhost:7070/oauth2/token")
                .jwkSetUri("http://localhost:7070/oauth2/jwks")
                .build();
    }
}
