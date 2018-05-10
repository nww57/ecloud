package com.sunesoft.ecloud.admin;

import com.sunesoft.ecloud.hibernate.repository.BaseRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author: Zhouzh
 * @Date: 2018/3/21
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@ComponentScan("com.sunesoft.ecloud")
@EnableJpaRepositories(basePackages = {"com.sunesoft.ecloud"}, repositoryBaseClass = BaseRepositoryImpl.class)
public class sysAdminApplicationBootstrap {
    public static void main(String[] args) {
        SpringApplication.run(sysAdminApplicationBootstrap.class, args);
    }

}
