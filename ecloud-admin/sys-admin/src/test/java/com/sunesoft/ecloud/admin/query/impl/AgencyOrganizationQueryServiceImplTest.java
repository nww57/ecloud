package com.sunesoft.ecloud.admin.query.impl;

import com.sunesoft.ecloud.admin.query.AgencyOrganizationQueryServicce;
import com.sunesoft.ecloud.adminclient.dtos.BasicDto;
import com.sunesoft.ecloud.common.result.ListResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @Author: niww
 * @Date: 2018/3/28
 */

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class AgencyOrganizationQueryServiceImplTest {

    @Autowired
    AgencyOrganizationQueryServicce queryServicce;
    @Test
    public void findAgencyOrganization() {
    }

    @Test
    public void findAgencyOrganizationBasicById() {
    }

    @Test
    public void getOrganizationIdName() {
        ListResult<BasicDto> t = queryServicce.getOrganizationIdName();
        System.out.println(23);
    }
}