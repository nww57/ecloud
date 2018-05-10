package com.sunesoft.ecloud;

import com.sunesoft.ecloud.hibernate.repository.BaseRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableJpaRepositories(basePackages = {"com.sunesoft.ecloud"}, repositoryBaseClass = BaseRepositoryImpl.class)
public class AuthApplicationBootstrap {

    public static void main(String[] args) {
        SpringApplication.run(AuthApplicationBootstrap.class, args);
    }
}
