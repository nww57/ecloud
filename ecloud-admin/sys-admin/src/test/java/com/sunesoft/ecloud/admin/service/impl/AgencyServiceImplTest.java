package com.sunesoft.ecloud.admin.service.impl;

import com.sunesoft.ecloud.admin.service.AgencyService;
import com.sunesoft.ecloud.adminclient.dtos.AgencyDto;
import com.sunesoft.ecloud.common.result.TResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
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

            dto.setId(UUID.fromString("cf2c49a1-12a9-4219-938e-af99047ab575"));
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
            dto.setServerEndDate("2019-3-27 13:23:23");

        List<UUID> uuidList = new ArrayList<UUID>(){{

//            add(UUID.fromString("1d4597c4-fa81-41a9-ae98-0af2cb20d261"));
//            add(UUID.fromString("e1014027-32a6-4418-8573-b39c3f517379"));
            add(UUID.fromString("ea5313a4-bbcf-4e72-b7cc-e4730c929378"));

        }} ;
        dto.setMenuIds(uuidList);

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
        UUID u1 = UUID.fromString("0486ce7e-8abd-4b59-bb41-deadba759805");
        TResult result = agencyService.delete(u1);
        System.out.println(23);
    }

    @Test
    public void deleteBatch() throws Exception {
        UUID u1 = UUID.fromString("4a98324d-dedc-4c4f-afce-daa87cf499b0");
        UUID[] s = new UUID[]{u1};
        TResult result = agencyService.deleteBatch(s);
        System.out.println(23);
    }

}