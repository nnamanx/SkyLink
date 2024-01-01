package com.namanx.security_ms.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

public interface SecurityConfigurer  {

    void configure(HttpSecurity httpSecurity) throws Exception;
}
