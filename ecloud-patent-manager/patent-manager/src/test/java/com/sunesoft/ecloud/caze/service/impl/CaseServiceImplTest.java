package com.sunesoft.ecloud.caze.service.impl;

import com.sunesoft.ecloud.caseclient.CaseCustomerRequestType;
import com.sunesoft.ecloud.caseclient.CaseType;
import com.sunesoft.ecloud.caseclient.dto.CaseCustomerRequestDto;
import com.sunesoft.ecloud.caseclient.dto.CaseInfoDto;
import com.sunesoft.ecloud.caseclient.dto.CaseMessageDto;
import com.sunesoft.ecloud.caze.domain.CaseInfo;
import com.sunesoft.ecloud.caze.service.CaseService;
import com.sunesoft.ecloud.common.result.TResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.Assert.*;

/**
 * @Auther: niww
 * @Date: 2018/4/13/013
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CaseServiceImplTest {

    @Autowired
    CaseService caseService;

    @Test
    public void addOrUpdateCase() throws Exception {
        CaseInfoDto dto = new CaseInfoDto();
        dto.setAgId(UUID.fromString("01d134d6-3eef-4b60-9979-c6392554da25"));
        dto.setCaseType(CaseType.SAMEDAYAPPLY_PATENT);
        dto.setCaseName("一个水龙头");
        dto.setComments("备注");
        dto.setCustomerId(UUID.fromString("696f3f81-f3bb-4ebc-99f0-9c3a5decfdf2"));
        dto.setFeeReduceRate(new BigDecimal("1"));
        dto.setCaseCreatorName("test");
        TResult re = caseService.addOrUpdateCase(dto);
        System.out.println(23);
    }

    @Test
    public void addOrUpdateCaseCustomerRequest() throws Exception {
        CaseCustomerRequestDto dto = new CaseCustomerRequestDto();
        dto.setCaseId(UUID.fromString("9cac8eaf-cd2d-4a9d-81ef-2526a71bd5fe"));
        dto.setRequestType(CaseCustomerRequestType.PAYOFFICIALFEEBYSELF_DEMAND);
        dto.setTitle("");
        dto.setDescription("我要官费自缴");
        TResult result = caseService.addOrUpdateCaseCustomerRequest(dto);
        System.out.println(23);

    }

    @Test
    public void addOrUpdateCaseMessage() throws Exception {
        CaseMessageDto messageDto = new CaseMessageDto();
        messageDto.setCaseId(UUID.fromString("9cac8eaf-cd2d-4a9d-81ef-2526a71bd5fe"));
        messageDto.setMessagerId(UUID.fromString("a0924fac-4270-4fbc-b2ac-af823ecdcc66"));
        messageDto.setContent("来看看的2");
        TResult result = caseService.addOrUpdateCaseMessage(messageDto);
        System.out.println(23);
    }

    @Test
    public void deleteCaseCustomerRequest(){
        caseService.deleteCaseCustomerRequest(UUID.fromString("6059904c-9463-4553-ab2f-f2e322110f01"));
        System.out.println(23);
    }

}