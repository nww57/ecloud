package com.sunesoft.ecloud.admin.query.impl;

import com.sunesoft.ecloud.admin.query.AgencyRoleQueryService;

import com.sunesoft.ecloud.adminclient.cretirias.AgencyRoleCriteria;
import com.sunesoft.ecloud.adminclient.dtos.AgencyRoleDto;

import com.sunesoft.ecloud.common.result.TResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.data.domain.Page;
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
        AgencyRoleCriteria criteria = new AgencyRoleCriteria();
        criteria.setPageIndex(0);
        Page<AgencyRoleDto> lsit = roleQueryService.findAgencyRolePaged(criteria);
        System.out.println(23);
    }

    @Test
    public void getAgencyRoleBasicById() {
        TResult<AgencyRoleDto> dto = roleQueryService.getAgencyRoleBasicById(UUID.fromString("cdd070e2-9e48-455c-ab86-6a9973fd1ca5"));
        System.out.println(132);
    }

    @Test
    public void getAgencyRoleFullById() {
    }

    @Test
    public void getAgencyRoleIdName() {
    }

}