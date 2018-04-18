package com.sunesoft.ecloud.admin.service.impl;

import com.sunesoft.ecloud.admin.service.ParameterService;
import com.sunesoft.ecloud.adminclient.dtos.ParameterDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

import static org.junit.Assert.*;

/**
 * @author: jiangzhenjing
 * @date: 2018/4/18 上午10:05
 * -
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class ParameterServiceImplTest {

    @Autowired
    ParameterService parameterService;



    @Test
    public void addOrUpdate() throws Exception {
        ParameterDto parameterDto=new ParameterDto();
        parameterDto.setParamName("aaaaa");
        parameterService.addOrUpdate(parameterDto, UUID.fromString(""));

    }

    @Test
    public void delete() throws Exception {
    }

}