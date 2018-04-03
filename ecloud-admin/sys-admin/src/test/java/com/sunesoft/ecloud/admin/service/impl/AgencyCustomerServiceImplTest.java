package com.sunesoft.ecloud.admin.service.impl;

import com.sunesoft.ecloud.admin.service.AgencyCustomerService;
import com.sunesoft.ecloud.adminclient.dtos.AgencyCustomerDto;
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
public class AgencyCustomerServiceImplTest {

    @Autowired
    AgencyCustomerService customerService;

    @Test
    public void addOrUpdateAgencyCustomer() throws Exception {
        AgencyCustomerDto dto  = new AgencyCustomerDto();
        dto.setName("客户1");
        dto.setLeader("负责人1");
        dto.setLeaderEmail("123123@163.com");
        dto.setLeaderMobile("1231313123");
        dto.setProvince("北京市");
        dto.setCity("市辖区");
        dto.setDistrict("东城区");
        dto.setStreet("高新区XXX");
        dto.setSignDate("2018-04-03 11:06:52");
        dto.setConsultantId(UUID.fromString("0f35220d-718e-4e53-b260-cb329d7fb407"));
        customerService.addOrUpdateAgencyCustomer(dto);
        System.out.println(23);
    }

    @Test
    public void delete() throws Exception {
        customerService.delete(UUID.fromString("178894eb-9d04-4d23-a79e-927bc952b07c"));
    }

    @Test
    public void deleteBatch() throws Exception {
        customerService.deleteBatch(UUID.fromString("98ca3092-cc29-4214-a67b-4064878d890b"),UUID.fromString("d93cf511-3c1f-4562-905c-93c68b3bee00"));
    }

}