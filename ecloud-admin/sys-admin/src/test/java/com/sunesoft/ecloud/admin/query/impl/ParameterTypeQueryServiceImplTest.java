package com.sunesoft.ecloud.admin.query.impl;

import com.sunesoft.ecloud.admin.query.ParameterTypeQueryService;
import com.sunesoft.ecloud.adminclient.dtos.ParameterTypeDto;
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
 * @date: 2018/4/19 下午6:27
 * -
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class ParameterTypeQueryServiceImplTest {

    @Autowired
    ParameterTypeQueryService parameterTypeQueryService;

    @Test
    public void queryParaneterTypeById() throws Exception {
        TResult<ParameterTypeDto> parameterTypeDtoTResult = parameterTypeQueryService.queryParaneterTypeById(UUID.fromString("cf1fa17f-f97d-4dc3-831e-32421940ecfe"));
        System.out.println(JsonHelper.toJson(parameterTypeDtoTResult));
    }

    @Test
    public void queryAllParaneterType() throws Exception {
        ListResult<ParameterTypeDto> parameterTypeDtoListResult = parameterTypeQueryService.queryAllParaneterType();
        System.out.println(JsonHelper.toJson(parameterTypeDtoListResult));
    }

}