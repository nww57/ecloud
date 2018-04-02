package com.sunesoft.ecloud.admin.query.impl;


import com.sunesoft.ecloud.admin.query.AgencyOrganizationQueryService;
import com.sunesoft.ecloud.adminclient.cretirias.AgencyOrganizationCriteria;
import com.sunesoft.ecloud.adminclient.dtos.AgencyOrganizationDto;
import com.sunesoft.ecloud.adminclient.dtos.BasicDto;
import com.sunesoft.ecloud.common.result.ListResult;
import com.sunesoft.ecloud.common.result.TResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

/**
 * @Author: niww
 * @Date: 2018/3/28
 */


@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class AgencyOrganizationQueryServiceImplTest {

    @Autowired

    AgencyOrganizationQueryService queryService;

    @Test
    public void findAgencyOrganization() throws Exception {
        AgencyOrganizationCriteria criteria = new AgencyOrganizationCriteria();

        ListResult<AgencyOrganizationDto> dto =queryService.findAgencyOrganization(criteria);

        System.out.println(23);
    }

    @Test
    public void findAgencyOrganizationBasicById() throws Exception {

        TResult<AgencyOrganizationDto> re = queryService.findAgencyOrganizationBasicById(UUID.fromString("ef9aa352-f81f-4b62-904f-3c15cc2ad32c"));
        System.out.println(23);
    }

    @Test
    public void getOrganizationIdName() throws Exception {
        ListResult<BasicDto> s = queryService.getOrganizationIdName();
        System.out.println(23);
    }


}