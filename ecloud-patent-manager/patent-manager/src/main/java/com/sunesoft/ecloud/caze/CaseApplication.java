package com.sunesoft.ecloud.caze;

import com.sunesoft.ecloud.hibernate.repository.BaseRepositoryImpl;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
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
    @Bean
    public CommandLineRunner init(final RepositoryService repositoryService,
                                  final RuntimeService runtimeService,
                                  final TaskService taskService) {

        return new CommandLineRunner() {
            @Override
            public void run(String... strings) throws Exception {
                System.out.println("Number of process definitions : "
                        + repositoryService.createProcessDefinitionQuery().count());
                System.out.println("Number of tasks : " + taskService.createTaskQuery().count());
//                runtimeService.startProcessInstanceByKey("oneTaskProcess");
                System.out.println("Number of tasks after process start: "
                        + taskService.createTaskQuery().count());
            }
        };
    }
}
