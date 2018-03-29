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
        dto.setName("来看看的企业");
        dto.setLeader("张三");
        dto.setLeaderEmail("23@qq.com");
        dto.setLeaderMobile("3232323232");
        dto.setProvince("江苏");
        dto.setCity("常州");
        dto.setDistrict("武进");
        dto.setStreet("高新区XXX");
        dto.setConsultantId(UUID.fromString("93c14d85-efc5-41ba-9546-b00e4d03feef"));
        customerService.addOrUpdateAgencyCustomer(dto);
        System.out.println(23);
    }

    @Test
    public void delete() throws Exception {
    }

    @Test
    public void deleteBatch() throws Exception {
    }

}