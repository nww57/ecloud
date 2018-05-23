package com.sunesoft.ecloud.caze.process;

import com.sunesoft.ecloud.common.cretiria.TCretiria;
import com.sunesoft.ecloud.common.result.ListResult;
import com.sunesoft.ecloud.common.result.PagedResult;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.idm.api.User;
import org.flowable.task.service.impl.persistence.entity.TaskEntity;

import java.io.InputStream;
import java.util.Map;

/**
 * @auther: niww
 * @date: 2018/5/22/022
 */
public interface ProcessService<T> {

    /**
     * 查看自己完成的任务
     *
     * @param userId
     * @return
     */
    ListResult<T> findDoneTaskList(String userId) throws Exception;

    /**
     * 查询代办任务
     *
     * @param userId
     * @return
     */
    ListResult<T> findTodoTaskList(String userId) throws Exception;

    /**
     * 签收任务
     *
     * @param userId
     * @param taskId
     */
    void doClaim(String userId, String taskId) throws Exception;

    /**
     * 委派任务
     *
     * @param userId
     * @throws Exception
     */
    void doDelegateTask(String userId, String taskId) throws Exception;

    /**
     * 转办任务
     *
     * @param userId
     * @param taskId
     * @throws Exception
     */
    void doTransferTask(String userId, String taskId) throws Exception;

    /**
     * 完成任务
     *
     * @param taskId
     * @param variables
     */
    void taskComplete(String taskId, Map<String,Object> variables) throws Exception;

    /**
     * 撤销任务
     *
     * @param historyTaskId
     * @throws Exception
     */
    Integer revokeTask(String historyTaskId, String processInstanceId) throws Exception;
    

    /**
     * 跳转（包括回退和向前）至指定活动节点
     */
    void moveTo(String currentTaskId, String targetTaskDefinitionKey) throws Exception;

    /**
     * 跳转（包括回退和向前）至指定活动节点
     *
     * @param currentTaskEntity       当前任务节点
     * @param targetTaskDefinitionKey 目标任务节点（在模型定义里面的节点名称）
     * @throws Exception
     */
    void moveTo(TaskEntity currentTaskEntity, String targetTaskDefinitionKey) throws Exception;


    /**
     * 显示流程图,带流程跟踪
     *
     * @param processInstanceId
     * @return
     */
    InputStream getDiagram(String processInstanceId) throws Exception;

    /**
     * 显示图片-通过流程ID，不带流程跟踪(没有乱码问题)
     *
     * @param resourceType
     * @param processInstanceId
     * @return
     */
    InputStream getDiagramByProInstanceId_noTrace(String resourceType, String processInstanceId) throws Exception;

    /**
     * 显示图片-通过部署ID，不带流程跟踪(没有乱码啊问题)
     *
     * @param resourceType
     * @param processDefinitionId
     * @return
     * @throws Exception
     */
    InputStream getDiagramByProDefinitionId_noTrace(String resourceType, String processDefinitionId) throws Exception;

    /**
     * 读取已结束中的流程-admin查看
     *
     * @return
     */
    PagedResult<T> findFinishedProcessInstances(TCretiria query) throws Exception;

    /**
     * 各个审批人员查看自己完成的任务
     *
     * @param user
     * @return
     * @throws Exception
     */
    PagedResult<T> findFinishedTaskInstancesPaged(User user, TCretiria query) throws Exception;



    /**
     * 管理运行中流程
     *
     * @return
     * @throws Exception
     */
    PagedResult<ProcessInstance> listRuningProcessPaged(TCretiria query) throws Exception;

    /**
     * 激活流程实例
     *
     * @param processInstanceId
     * @throws Exception
     */
    void activateProcessInstance(String processInstanceId) throws Exception;

    /**
     * 挂起流程实例
     *
     * @param processInstanceId
     * @throws Exception
     */
    void suspendProcessInstance(String processInstanceId) throws Exception;

    /**
     * 测试 - 动态创建流程信息
     *
     * @throws Exception
     */
    void addProcessByDynamic() throws Exception;
}
