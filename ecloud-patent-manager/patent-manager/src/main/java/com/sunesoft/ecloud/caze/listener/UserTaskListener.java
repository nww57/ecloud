package com.sunesoft.ecloud.caze.listener;

import org.flowable.engine.RepositoryService;
import org.flowable.engine.delegate.TaskListener;
import org.flowable.engine.repository.ProcessDefinition;
import org.flowable.task.service.delegate.DelegateTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


/**
 * @auther: niww
 * @date: 2018/5/22/022
 */
@Component("userTaskListener")
public class UserTaskListener implements TaskListener {
    @Autowired
    RepositoryService repositoryService;


    @Override
    public void notify(DelegateTask delegateTask) {

        String processDefinitionId = delegateTask.getProcessDefinitionId();    //com.zml.oa.vacation:8:30012
        ProcessDefinition processDefinition = this.repositoryService.createProcessDefinitionQuery().processDefinitionId(processDefinitionId).singleResult();
        String processDefinitionName = processDefinition.getName();            //请假流程
        String processDefinitionKey = processDefinition.getKey();            //com.zml.oa.vacation
        String taskDefinitionKey = delegateTask.getTaskDefinitionKey();        //directorAudit
        try {

            switch (taskDefinitionKey) {
                case "managerAudit": {
                    delegateTask.setAssignee("1344ae7b-5e8f-4183-ba80-05ce54108472");
                    System.out.println("wanggy");
                    break;
                }
                case "directorAudit": {
                    delegateTask.setAssignee("wangwu");
                    System.out.println("wangwu");
                    break;
                }
                case "modifyApply": {
                    System.out.println("没有组");
                    break;
                }
            }


        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

