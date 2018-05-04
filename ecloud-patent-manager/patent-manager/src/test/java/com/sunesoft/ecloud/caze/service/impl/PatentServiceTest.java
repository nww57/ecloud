package com.sunesoft.ecloud.caze.service.impl;

import com.sunesoft.ecloud.adminclient.AgencyType;
import com.sunesoft.ecloud.caseclient.dto.CreateContractPatentDto;
import com.sunesoft.ecloud.caseclient.enums.PatentType;
import com.sunesoft.ecloud.caze.service.PatentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

import static org.junit.Assert.*;

/**
 * @Auther: niww
 * @Date: 2018/5/4/004
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class PatentServiceTest {

    @Autowired
    PatentService patentService;

    private static final UUID AGID = UUID.fromString("01d134d6-3eef-4b60-9979-c6392554da25");

    @Test
    public void addPatent() throws Exception {
        CreateContractPatentDto dto = new CreateContractPatentDto();
        dto.setAgId(AGID);
        dto.setCaseNo("AJ201805040003");
        dto.setContractId(UUID.fromString("d58827df-6f5a-421a-a935-3c2102a48e87"));
        dto.setPatentType(PatentType.UTILITYMODEL_PATENT);
        dto.setPatentName("测试专利");
        dto.setCreatorId(UUID.fromString("fc98e1ca-92f0-4f2e-b68c-f0129978c1bf"));
        patentService.addPatent(dto);
        System.out.println(23);
    }

    @Test
    public void deletePatent() throws Exception {
    }

    @Test
    public void deletePatent1() throws Exception {
    }

}