package com.chiara.exercises.cornucopia.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.invoke

import org.springframework.security.web.SecurityFilterChain

/**
 * Configuration class that overrides the default config provided by Spring Security.
 * With this config, authentication is required (in the form of basic HTTP authentication)
 * in order to access all app endpoints, but the csrf protection is disabled;
 * this allows Postman to send status-changing requests
 * without any need to send any csrf token (I was not sending one from the app anyway,
 * I should learn how to do so!
 * Or I could explore authorization by JWT...)
 */

@Configuration
@EnableWebSecurity
class WebSecurityConfig  {

    @Bean
    fun filterChain (httpSecurity : HttpSecurity) : SecurityFilterChain {
        httpSecurity
            .invoke {
                csrf { disable() }
                authorizeRequests { authorize(anyRequest, authenticated) }
                httpBasic {}
        }
        return httpSecurity.build()
    }
}