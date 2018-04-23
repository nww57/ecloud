package com.sunesoft.ecloud.admin.query.impl;

import com.sunesoft.ecloud.admin.query.ParameterQueryService;
import com.sunesoft.ecloud.adminclient.dtos.ParameterDto;
import com.sunesoft.ecloud.common.result.ListResult;
import com.sunesoft.ecloud.common.result.TResult;
import com.sunesoft.ecloud.common.utils.JsonHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

import static org.junit.Assert.*;

/**
 * @author: jiangzhenjing
 * @date: 2018/4/19 下午6:00
 * -
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class ParameterQueryServiceImplTest {

    @Autowired
    ParameterQueryService parameterQueryService;

    @Test
    public void queryParaneterByTypeId() throws Exception {
        ListResult<ParameterDto> parameterDtoListResult = parameterQueryService.queryParameterByTypeId(UUID.fromString("cf1fa17f-f97d-4dc3-831e-32421940ecfe"));
        System.out.println(JsonHelper.toJson(parameterDtoListResult));
    }

    @Test
    public void queryParaneterById() throws Exception {
        TResult<ParameterDto> parameterDtoTResult = parameterQueryService.queryParameterById(UUID.fromString("f625d6dd-c52a-49da-b038-a9b59037c5d0"));
        System.out.println(JsonHelper.toJson(parameterDtoTResult));
    }

    @Test
    public void queryAllParaneter() throws Exception {
        ListResult<ParameterDto> parameterDtoListResult = parameterQueryService.queryAllParameter();
        System.out.println(JsonHelper.toJson(parameterDtoListResult));

    }

}