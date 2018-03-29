package com.sunesoft.ecloud.admin.query.impl;

import com.sunesoft.ecloud.admin.query.AgencyRoleQueryService;
import com.sunesoft.ecloud.adminclient.cretirias.AgencyRoleCriteria;
import com.sunesoft.ecloud.adminclient.dtos.AgencyRoleDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @Auther: niww
 * @Date: 2018/3/29/029
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class AgencyRoleQueryServiceImplTest {

    @Autowired
    AgencyRoleQueryService queryService;

    @Test
    public void findAgencyRolePaged() throws Exception {
        AgencyRoleCriteria criteria = new AgencyRoleCriteria();
        Page<AgencyRoleDto> roleList = queryService.findAgencyRolePaged(criteria);
        System.out.println(23);
    }

    @Test
    public void getAgencyRoleBasicById() throws Exception {
    }

    @Test
    public void getAgencyRoleFullById() throws Exception {
    }

    @Test
    public void getAgencyRoleIdName() throws Exception {
    }

}