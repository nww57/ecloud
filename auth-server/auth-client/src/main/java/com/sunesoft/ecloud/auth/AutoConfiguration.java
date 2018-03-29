package com.sunesoft.ecloud.auth;

import com.sunesoft.ecloud.auth.configs.UserAuthConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.sunesoft.ecloud.auth.configs"})
public class AutoConfiguration {

    @Bean
    UserAuthConfig getUserAuthConfig(){
        return new UserAuthConfig();
    }

}
