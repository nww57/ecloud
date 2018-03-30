package com.sunesoft.ecloud.admin.query.impl;

import com.sunesoft.ecloud.admin.query.AgencyRoleQueryService;

import com.sunesoft.ecloud.adminclient.dtos.AgencyRoleDto;

import com.sunesoft.ecloud.common.result.TResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

import static org.junit.Assert.*;

/**
 * @Author: niww
 * @Date: 2018/3/30

 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class AgencyRoleQueryServiceImplTest {

    @Autowired

    AgencyRoleQueryService roleQueryService;

    @Test
    public void findAgencyRolePaged() {
    }

    @Test
    public void getAgencyRoleBasicById() {
        TResult<AgencyRoleDto> dto = roleQueryService.getAgencyRoleBasicById(UUID.fromString("532b7d5c-e071-4b89-85f9-7f72fc979cbf"));
        System.out.println(132);
    }

    @Test
    public void getAgencyRoleFullById() {
    }

    @Test
    public void getAgencyRoleIdName() {
    }

}