package com.example.sima.config.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfiguration {

    @Value("${sima.security.sso}")
    private boolean isSsoEnable;

    @Value("${jwksUri}")
    private String jwksUri;

    @Bean
    public SecurityFilterChain securityFilterChain1(HttpSecurity httpSecurity) throws Exception {
        if (isSsoEnable) {
            httpSecurity.oauth2ResourceServer(
                    r -> r.jwt(c -> {
                        c.jwkSetUri(jwksUri);
                        c.jwtAuthenticationConverter(new CustomJwtAuthenticationTokenConverter());
                    })
            );
            return httpSecurity.authorizeHttpRequests(a -> a.anyRequest().authenticated()).build();

        } else {
            return httpSecurity
                    .userDetailsService(userDetailsService())
                    .authorizeHttpRequests(a -> a.anyRequest().permitAll())
                    .httpBasic(Customizer.withDefaults())
                    .build();
        }
    }

    public UserDetailsService userDetailsService() {
        return new InMemoryUserDetailsManager(
                User
                        .withUsername("admin")
                        .password("admin")
                        .authorities("read")
                        .build()
        );
    }

    @Bean
    @Profile("dev")
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    /*@Bean
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
                .redirectUri("http://192.168.1.5:8080/login/oauth2/code/simaASClient")
                .authorizationUri("http://localhost:7070/oauth2/authorize")
                .tokenUri("http://localhost:7070/oauth2/token")
                .jwkSetUri("http://localhost:7070/oauth2/jwks")
                .build();
    }*/
}
