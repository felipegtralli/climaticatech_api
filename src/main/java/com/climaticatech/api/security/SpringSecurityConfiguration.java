package com.climaticatech.api.security;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> auth.requestMatchers(HttpMethod.POST).authenticated().
                                                requestMatchers(HttpMethod.DELETE).authenticated().
                                                anyRequest().permitAll());


        http.httpBasic(withDefaults());

        http.csrf(csfr -> csfr.disable());

        return http.build();
    }
}
