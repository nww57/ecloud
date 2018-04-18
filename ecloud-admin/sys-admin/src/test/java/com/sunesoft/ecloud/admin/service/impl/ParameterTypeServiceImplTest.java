package com.sunesoft.ecloud.admin.service.impl;

import com.sunesoft.ecloud.admin.service.ParameterTypeService;
import com.sunesoft.ecloud.adminclient.dtos.ParameterTypeDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

import static org.junit.Assert.*;

/**
 * @author: jiangzhenjing
 * @date: 2018/4/18 上午10:20
 * -
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class ParameterTypeServiceImplTest {

    @Autowired
    ParameterTypeService parameterTypeService;


    @Test
    public void addOrUpdate() throws Exception {
        ParameterTypeDto parameterTypeDto=new ParameterTypeDto();
        parameterTypeDto.setPid(UUID.fromString("cf1fa17f-f97d-4dc3-831e-32421940ecfe"));
        parameterTypeDto.setParamTypeName("bbbbbbb");
        parameterTypeService.addOrUpdate(parameterTypeDto);
        System.out.println("11111111");

    }

    @Test
    public void delete() throws Exception {
    }

}