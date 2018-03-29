package com.sunesoft.ecloud.admin.service.impl;

import com.sunesoft.ecloud.admin.service.AgencyOrganizationService;
import com.sunesoft.ecloud.adminclient.dtos.AgencyOrganizationDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

import static org.junit.Assert.*;

/**
 * @Auther: niww
 * @Date: 2018/3/28/028
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class AgencyOrganizationServiceImplTest {

    @Autowired
    AgencyOrganizationService organizationService;

    @Test
    public void addOrUpdateOrganization() throws Exception {
        AgencyOrganizationDto dto = new AgencyOrganizationDto();
        dto.setParentId(UUID.fromString("cad1d2ae-f872-4e95-ae8e-656d5945563d"));
        dto.setAgId(UUID.fromString("200e6946-70e3-4087-839a-0491c631caf1"));
        dto.setName("策划部 下属部门 4");
        dto.setDescription("队伍及4");
        dto.setCode("0204");
        dto.setLeaderId(UUID.fromString("06d11ea7-44d3-4267-8b26-15db3e6d70b2"));
        organizationService.addOrUpdateOrganization(dto);
        System.out.println(23);
    }

    @Test
    public void delete() throws Exception {
    }

    @Test
    public void deleteBatch() throws Exception {
    }

}