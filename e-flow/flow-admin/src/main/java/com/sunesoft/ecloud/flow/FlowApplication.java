package com.sunesoft.ecloud;

import com.sunesoft.ecloud.hibernate.repository.BaseRepositoryImpl;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients({"com.sunesoft.ecloud.adminclient.clientService"})
@ComponentScan("com.sunesoft.ecloud")
@EnableJpaRepositories(basePackages = {"com.sunesoft.ecloud"}, repositoryBaseClass = BaseRepositoryImpl.class)
public class FlowApplication {
    public static void main( String[] args ) {
        System.out.println( "Hello World!" );
    }
}
