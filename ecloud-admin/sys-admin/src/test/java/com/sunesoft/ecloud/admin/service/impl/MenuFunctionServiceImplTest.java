package com.sunesoft.ecloud.admin.service.impl;

import com.sunesoft.ecloud.admin.service.MenuFunctionService;
import com.sunesoft.ecloud.adminclient.dtos.MenuFunctionDto;
import com.sunesoft.ecloud.common.result.TResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

import static org.junit.Assert.*;

/**
 * @author: jiangzhenjing
 * @date: 2018/3/28 上午10:59
 * -
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class MenuFunctionServiceImplTest {

    @Autowired
    MenuFunctionService menuFunctionService;


    @Test
    public void addOrUpdateFunction() throws Exception {
        MenuFunctionDto menuFunctionDto=new MenuFunctionDto();
        menuFunctionDto.setId(UUID.fromString("ca7c25cb-896d-411a-93c8-97c8f8921a48"));
        menuFunctionDto.setName("Function5啊");
        menuFunctionDto.setDescription("cccccc");
        menuFunctionDto.setResName("ccccc");
        menuFunctionDto.setResUrl("cccccc");
        TResult tResult = menuFunctionService.addOrUpdateFunction(menuFunctionDto, UUID.fromString("52996c7b-ba83-4af0-ad92-04084b4fac52"));
        System.out.println(tResult);

    }

    @Test
    public void delete() throws Exception {
    }

}