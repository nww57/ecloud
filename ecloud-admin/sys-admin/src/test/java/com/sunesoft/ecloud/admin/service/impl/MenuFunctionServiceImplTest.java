package com.sunesoft.ecloud.admin.service.impl;

import com.sunesoft.ecloud.admin.service.MenuFunctionService;
import com.sunesoft.ecloud.adminclient.dtos.MenuFunctionDto;
import com.sunesoft.ecloud.common.result.TResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;
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
//        menuFunctionDto.setId(UUID.fromString("ca7c25cb-896d-411a-93c8-97c8f8921a48"));
//
        menuFunctionDto.setName("新增");
        menuFunctionDto.setDescription("cccccc");
        menuFunctionDto.setResName("ccccc");
        menuFunctionDto.setResUrl("cccccc");
        TResult tResult = menuFunctionService.addOrUpdateFunction(menuFunctionDto, UUID.fromString("1d4597c4-fa81-41a9-ae98-0af2cb20d261"));

        System.out.println(tResult);

    }

    @Test
    public void delete() throws Exception {
        List<UUID> list=new ArrayList<>();
//        list.add(UUID.fromString("0d615ddd-63e5-4f54-a570-a72e7b3f111a"));
//        list.add(UUID.fromString("82e9e915-c9ee-4df5-8879-f7269ebe12f6"));
//        list.add(UUID.fromString("ca7c25cb-896d-411a-93c8-97c8f8921a48"));
        TResult delete = menuFunctionService.delete(list);
        System.out.println(delete);
    }

}