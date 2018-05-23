package com.sunesoft.ecloud.caze.service.impl;

import com.sunesoft.ecloud.caseclient.dto.flow.TestDto;
import org.flowable.engine.HistoryService;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.engine.repository.Deployment;
import org.flowable.engine.repository.ProcessDefinition;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.spring.ProcessEngineFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @auther: niww
 * @date: 2018/5/21/021
 */
@Service
public class ActivityServiceImpl {
    @Autowired
    private RepositoryService repositoryService;
    //获取运行时服务组件
    @Autowired
    private RuntimeService runtimeService;
    //获取流程中的任务TASK组件
    @Autowired
    private TaskService taskService;
    @Autowired
    ProcessEngineFactoryBean processEngine;
    @Autowired

    HistoryService historyService;

    public void demo(){
        System.out.println("Number of process definitions : "
                + repositoryService.createProcessDefinitionQuery().count());
        System.out.println("Number of tasks : " + taskService.createTaskQuery().count());
//                runtimeService.startProcessInstanceByKey("oneTaskProcess");
        System.out.println("Number of tasks after process start: "
                + taskService.createTaskQuery().count());
        //部署流程
        //根据bpmn文件部署流程
//        Deployment deployment = repositoryService.createDeployment().addClasspathResource("demo2.bpmn").deploy();
////        获取流程定义
//        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().deploymentId(deployment.getId()).singleResult();
////        启动流程定义，返回流程实例
//        ProcessInstance pi = runtimeService.startProcessInstanceByKey("demo2");
        TestDto dto = new TestDto(2);
        Map<String,Object> map = new HashMap();
        map.put("entity",dto);
        runtimeService.startProcessInstanceByKey("com.zml.oa.vacation",map);

        System.out.println("Number of process definitions : "
                + repositoryService.createProcessDefinitionQuery().count());
        System.out.println("Number of tasks : " + taskService.createTaskQuery().count());
//                runtimeService.startProcessInstanceByKey("oneTaskProcess");
        System.out.println("Number of tasks after process start: "
                + taskService.createTaskQuery().count());
    }
}
