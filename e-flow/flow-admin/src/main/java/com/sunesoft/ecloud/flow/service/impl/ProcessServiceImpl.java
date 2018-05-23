package com.sunesoft.ecloud.caze.process;

import com.sunesoft.ecloud.common.cretiria.TCretiria;
import com.sunesoft.ecloud.common.result.ListResult;
import com.sunesoft.ecloud.common.result.PagedResult;
import com.sunesoft.ecloud.common.result.resultFactory.ResultFactory;
import org.flowable.engine.*;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.idm.api.User;
import org.flowable.spring.ProcessEngineFactoryBean;
import org.flowable.task.api.Task;
import org.flowable.task.api.history.HistoricTaskInstance;
import org.flowable.task.api.history.HistoricTaskInstanceQuery;
import org.flowable.task.service.impl.persistence.entity.TaskEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * @auther: niww
 * @date: 2018/5/22/022
 */
@Service
public class ProcessServiceImpl implements ProcessService {

    @Autowired
    protected RuntimeService runtimeService;

    @Autowired
    protected IdentityService identityService;

    @Autowired
    protected TaskService taskService;

    @Autowired
    protected RepositoryService repositoryService;

    @Autowired
    protected HistoryService historyService;

    @Autowired
    ProcessEngineFactoryBean processEngineFactory;

    @Autowired
    ProcessEngineConfiguration processEngineConfiguration;

    @Autowired
    private ProcessEngine processEngine;



    @Override
    public ListResult findDoneTaskList(String userId) throws Exception {
        HistoricTaskInstanceQuery historyQuery = historyService.createHistoricTaskInstanceQuery().taskAssignee(userId).finished();
        List<HistoricTaskInstance> list = historyQuery.orderByHistoricTaskInstanceEndTime().desc().list();
        return ResultFactory.listResult(list);
    }

    @Override
    public ListResult findTodoTaskList(String userId) throws Exception {
        List<Task> tasks = taskService.createTaskQuery().taskAssignee(userId).orderByTaskCreateTime().desc().list();
        return new ListResult<>(tasks);
    }

    @Override
    public void doClaim(String userId, String taskId) throws Exception {

    }

    @Override
    public void doDelegateTask(String userId, String taskId) throws Exception {

    }

    @Override
    public void doTransferTask(String userId, String taskId) throws Exception {

    }

    @Override
    public void taskComplete(String taskId, Map variables) throws Exception {
        taskService.complete(taskId,variables);
    }


    @Override
    public Integer revokeTask(String historyTaskId, String processInstanceId) throws Exception {
        return null;
    }

    @Override
    public void moveTo(String currentTaskId, String targetTaskDefinitionKey) throws Exception {

    }

    @Override
    public void moveTo(TaskEntity currentTaskEntity, String targetTaskDefinitionKey) throws Exception {

    }

    @Override
    public InputStream getDiagram(String processInstanceId) throws Exception {
        return null;
    }

    @Override
    public InputStream getDiagramByProInstanceId_noTrace(String resourceType, String processInstanceId) throws Exception {
        return null;
    }

    @Override
    public InputStream getDiagramByProDefinitionId_noTrace(String resourceType, String processDefinitionId) throws Exception {
        return null;
    }

    @Override
    public PagedResult findFinishedProcessInstances(TCretiria query) throws Exception {
        return null;
    }

    @Override
    public PagedResult findFinishedTaskInstancesPaged(User user, TCretiria query) throws Exception {
        return null;
    }

    @Override
    public PagedResult<ProcessInstance> listRuningProcessPaged(TCretiria query) throws Exception {
        return null;
    }

    @Override
    public void activateProcessInstance(String processInstanceId) throws Exception {

    }

    @Override
    public void suspendProcessInstance(String processInstanceId) throws Exception {

    }

    @Override
    public void addProcessByDynamic() throws Exception {

    }

}
