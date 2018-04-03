package com.sunesoft.ecloud.admin.service.impl;

import com.sunesoft.ecloud.admin.service.AgencyOrganizationService;
import com.sunesoft.ecloud.adminclient.dtos.AgencyOrganizationDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
        for(int i=1;i<4;i++){
            AgencyOrganizationDto dto = new AgencyOrganizationDto();
            dto.setPid(UUID.fromString("e116808d-d31b-4aab-8b1a-b360edbc2225"));
//        dto.setAgId(UUID.fromString("1326723e-9532-4ec0-9d2f-6bad0a65db3b"));
            dto.setName("策划部2的下属部门"+i);
            dto.setDescription("");
            dto.setCode("02020"+i);
//        dto.setLeaderId(UUID.fromString("06d11ea7-44d3-4267-8b26-15db3e6d70b2"));
            organizationService.addOrUpdateOrganization(dto);
        }

        System.out.println(23);
    }

    @Test
    public void delete() throws Exception {
        organizationService.delete(UUID.fromString("19b7e85b-5536-49fe-950c-4ac279d0549e"));
        System.out.println(23);
    }

    @Test
    public void deleteBatch() throws Exception {
    }

}