package com.sunesoft.ecloud.admin.service.impl;

import com.sunesoft.ecloud.admin.service.AgencyService;
import com.sunesoft.ecloud.adminclient.dtos.AgencyDto;
import com.sunesoft.ecloud.common.result.TResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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

//            dto.setId(UUID.fromString("d2d512f3-0a6c-4373-9ab2-a348fb616d7a"));
            dto.setName("超级管理员所属企业");
            dto.setCode("sune");
            dto.setCountry("中国");
            dto.setRegisterDate(LocalDate.now());
            dto.setLeader("张伟asdf");
            dto.setEmail("123@qq.com");
            dto.setCellphone("1596146415");
            dto.setFax("010+26737123");
            dto.setProvince("江苏省");
            dto.setCity("常州市");
            dto.setDistrict("武进区");
            dto.setStreet("科教称城");
            dto.setZipcode("213100");
            dto.setServerEndDate(LocalDateTime.now());

//        List<UUID> uuidList = new ArrayList<UUID>(){{
//            add(UUID.fromString("5612c844-5d55-4a26-916d-51ce17efc0c7"));
////            add(UUID.fromString("56cfb947-2cda-4216-b1e8-92bd804d4a89"));
//            add(UUID.fromString("78ef2cfe-b5ea-46cb-bf52-e4cd37f1ffba"));

//        }} ;
//
//        dto.setMenuIds(uuidList);

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
        UUID u1 = UUID.fromString("01d134d6-3eef-4b60-9979-c6392554da24");
        TResult result = agencyService.delete(u1);
        System.out.println(23);
    }

    @Test
    public void deleteBatch() throws Exception {
        UUID u1 = UUID.fromString("1621cf35-2f8e-4b8c-8724-d29d2709052b");
        UUID u2 = UUID.fromString("54511220-993b-4428-89c4-35fdf7001e26");
        TResult result = agencyService.deleteBatch(u1,u2);
        System.out.println(23);
    }

}