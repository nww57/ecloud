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
        menuFunctionDto.setName("Function4啊");
        menuFunctionDto.setDescription("bbbbbb");
        menuFunctionDto.setResName("bbbbb");
        menuFunctionDto.setResUrl("bbbbbb");
        TResult tResult = menuFunctionService.addOrUpdateFunction(menuFunctionDto, UUID.fromString("8c831c8f-9ffc-42af-b40d-46dce4218fec"));
        System.out.println(tResult);

    }

    @Test
    public void delete() throws Exception {
    }

}