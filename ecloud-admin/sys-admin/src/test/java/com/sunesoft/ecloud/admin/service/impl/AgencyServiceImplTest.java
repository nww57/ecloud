package com.sunesoft.ecloud.admin.service.impl;

import com.sunesoft.ecloud.admin.service.AgencyService;
import com.sunesoft.ecloud.adminclient.dtos.AgencyDto;
import com.sunesoft.ecloud.common.result.TResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

import static org.junit.Assert.*;

/**
 * @Auther: niww
 * @Date: 2018/3/27/027
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class AgencyServiceImplTest {

    @Autowired
    AgencyService agencyService;

    @Test
    public void addOrUpdateAgency() throws Exception {
            AgencyDto dto = new AgencyDto();
            dto.setId(UUID.fromString("200e6946-70e3-4087-839a-0491c631caf1"));
            dto.setName("asdfasdfa");
            dto.setCode("DW00232");
            dto.setCountry("Chinasadfa");
            dto.setRegisterDate("2018-3-27");
            dto.setLeader("张伟asdf");
            dto.setEmail("123@qq.com");
            dto.setCellphone("12345678912");
            dto.setFax("010+26737123");
            dto.setProvince("江苏asdf");
            dto.setCity("常州adf");
            dto.setDistrict("武进adf");
            dto.setStreet("科教称adf");
            dto.setZipcode("21000adfad");
            dto.setServerEndDate("2019-3-27");
            TResult dto2 = agencyService.addOrUpdateAgency(dto);

//        for (int i = 2; i < 15; i++) {
//            AgencyDto dto = new AgencyDto();
//            dto.setName("点威知识产权");
//            dto.setCode("DW00"+i);
//            dto.setCountry("China");
//            dto.setRegisterDate("2018-3-27");
//            dto.setLeader("张伟"+i);
//            dto.setEmail("123@qq.com");
//            dto.setCellphone("12345678912");
//            dto.setFax("010+26737123");
//            dto.setProvince("江苏"+i);
//            dto.setCity("常州"+i);
//            dto.setDistrict("武进"+i);
//            dto.setStreet("科教称"+i);
//            dto.setZipcode("21000"+i);
//            dto.setServerEndDate("2019-3-27");
//            TResult dto2 = agencyService.addOrUpdateAgency(dto);
//        }
        System.out.println(23);
    }

    @Test
    public void delete() throws Exception {
        UUID u1 = UUID.fromString("0a3ddcb3-d39c-4cf6-acf9-974d19141219");
        TResult result = agencyService.delete(u1);
        System.out.println(23);
    }

    @Test
    public void deleteBatch() throws Exception {
        UUID u1 = UUID.fromString("0a3ddcb3-d39c-4cf6-acf9-974d19141219");
        UUID u2 = UUID.fromString("9e057d79-c2db-4ed7-996c-b481f7865df2");
        UUID[] s = new UUID[]{u1, u2};
        TResult result = agencyService.deleteBatch(s);
        System.out.println(23);
    }

}