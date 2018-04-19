package com.sunesoft.ecloud.caze;

import com.sunesoft.ecloud.hibernate.repository.BaseRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @Auther: niww
 * @Date: 2018/4/13/013
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients({"com.sunesoft.ecloud.adminclient.clientService"})
@ComponentScan("com.sunesoft.ecloud")
@EnableJpaRepositories(basePackages = {"com.sunesoft.ecloud"}, repositoryBaseClass = BaseRepositoryImpl.class)
public class CaseApplication {
    public static void main(String[] args) {
        SpringApplication.run(CaseApplication.class,args);
    }
}
