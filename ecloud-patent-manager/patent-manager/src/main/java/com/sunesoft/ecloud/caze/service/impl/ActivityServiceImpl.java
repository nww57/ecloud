package com.sunesoft.ecloud.caze.service.impl;

import org.flowable.engine.HistoryService;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.spring.ProcessEngineFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        //部署流程
        repositoryService.createDeployment().addClasspathResource("myprocess.bpmn").deploy();
        //开启流程，myprocess是流程的ID
        runtimeService.startProcessInstanceByKey("patent");
    }
}
