package com.sunesoft.ecloud.caze.service.impl;

import com.sunesoft.ecloud.caze.process.ProcessService;
import com.sunesoft.ecloud.common.result.ListResult;
import org.flowable.task.api.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * @auther: niww
 * @date: 2018/5/22/022
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class ActivityServiceImplTest {

    @Autowired
    ProcessService processService;

    @Autowired
    ActivityServiceImpl activityService;

    @Test
    public void demo() throws Exception {
        activityService.demo();
        ListResult result = processService.findTodoTaskList("1344ae7b-5e8f-4183-ba80-05ce54108472");

        System.out.println(23);
    }

    @Test
    public void test1() throws Exception {
        //先查询代办任务
        ListResult result = processService.findTodoTaskList("1344ae7b-5e8f-4183-ba80-05ce54108472");
//        //完成第一
        List<Task> taskList = (List<Task>) result.getResult();
        Task t = taskList.get(0);
        Map<String,Object> variables = new HashMap<>();
        variables.put("isPass",true);
        processService.taskComplete(t.getId(),variables);
        //在查询
        ListResult result2 = processService.findTodoTaskList("1344ae7b-5e8f-4183-ba80-05ce54108472");
        //查询下一个人的代办任务
        ListResult result3 = processService.findTodoTaskList("10ae8d3a-f095-4024-8dd9-4d7a42e80193");
        //查询已办任务
        ListResult result4 = processService.findDoneTaskList("1344ae7b-5e8f-4183-ba80-05ce54108472");
        System.out.println(23);
    }


}