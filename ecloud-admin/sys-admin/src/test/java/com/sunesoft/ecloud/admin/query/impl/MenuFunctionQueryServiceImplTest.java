package com.sunesoft.ecloud.admin.query.impl;

import com.sunesoft.ecloud.admin.query.MenuFunctionQueryService;
import com.sunesoft.ecloud.adminclient.dtos.MenuFunctionDto;
import com.sunesoft.ecloud.common.result.ListResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

import static org.junit.Assert.*;

/**
 * @author: jiangzhenjing
 * @date: 2018/3/28 上午11:00
 * -
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class MenuFunctionQueryServiceImplTest {

    @Autowired
    MenuFunctionQueryService menuFunctionQueryService;


    @Test
    public void queryMenuFunction() throws Exception {
        ListResult<MenuFunctionDto> menuFunctionDtoListResult = menuFunctionQueryService.queryMenuFunction(UUID.fromString("b0da86c4-1e6a-49c4-8883-352b9384cacc"));
        System.out.println(menuFunctionDtoListResult);
    }

}