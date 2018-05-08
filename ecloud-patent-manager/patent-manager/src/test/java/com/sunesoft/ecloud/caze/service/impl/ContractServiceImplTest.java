package com.sunesoft.ecloud.caze.service.impl;

import com.sunesoft.ecloud.caseclient.dto.ContractDto;
import com.sunesoft.ecloud.caze.service.ContractService;
import com.sunesoft.ecloud.common.result.TResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.Assert.*;

/**
 * @Auther: niww
 * @Date: 2018/5/4/004
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class ContractServiceImplTest {

    @Autowired
    ContractService contractService;

    private static final UUID AGID = UUID.fromString("01d134d6-3eef-4b60-9979-c6392554da25");


    @Test
    public void addOrUpdateContract() throws Exception {
        ContractDto dto = new ContractDto();
        dto.setAgId(UUID.fromString("01d134d6-3eef-4b60-9979-c6392554da25"));
        dto.setContractName("测试合同");
        dto.setContractNo(contractService.generateContractNo(AGID).getResult().toString());
        dto.setCustomerId(UUID.fromString("0849dd08-8456-4b7f-a3a7-7bf33292558a"));
        dto.setSalesmanId(UUID.fromString("fc98e1ca-92f0-4f2e-b68c-f0129978c1bf"));
        dto.setIntroducerId(UUID.fromString("fc98e1ca-92f0-4f2e-b68c-f0129978c1bf"));
        dto.setSignDate(LocalDate.now());
        dto.setCreatorId(UUID.fromString("fc98e1ca-92f0-4f2e-b68c-f0129978c1bf"));
        TResult result =contractService.addOrUpdateContract(dto);
        System.out.println(23);
    }

    @Test
    public void deleteContract() throws Exception {
    }

    @Test
    public void deleteContract1() throws Exception {
    }

}