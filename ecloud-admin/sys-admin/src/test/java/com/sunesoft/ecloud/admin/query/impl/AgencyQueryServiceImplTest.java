package com.sunesoft.ecloud.admin.query.impl;

import com.sunesoft.ecloud.admin.query.AgencyQueryService;
import com.sunesoft.ecloud.adminclient.cretirias.AgencyCriteria;
import com.sunesoft.ecloud.adminclient.dtos.AgencyBasicDto;
import com.sunesoft.ecloud.adminclient.dtos.AgencyDto;
import com.sunesoft.ecloud.common.result.TResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

import static org.junit.Assert.*;

/**
 * @Auther: niww
 * @Date: 2018/3/27/027
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class AgencyQueryServiceImplTest {

    @Autowired
    AgencyQueryService agencyQueryService;

    @Test
    public void findAgencyPaged() throws Exception {
        AgencyCriteria c = new AgencyCriteria();
        Page<AgencyDto> page =  agencyQueryService.findAgencyPaged(c);
        System.out.println(23);
    }

    @Test
    public void findAgencyBasicInfoById() throws Exception {
        TResult<AgencyBasicDto> result = agencyQueryService.findAgencyBasicInfoById(UUID.fromString("200e6946-70e3-4087-839a-0491c631caf1"));
        System.out.println(213);
    }

    @Test
    public void findAgencyFullInfoById() throws Exception {

    }


    @Test
    public void testGetOrganizationIdName(){
    }

    @Test
    public void testFindAgencyDetailInfoById(){
        TResult<AgencyDto> dtoList = agencyQueryService.findAgencyDetailInfoById(UUID.fromString("9ef4707f-16a2-4654-b598-ddce9973b1cc"));
        System.out.println(23);
    }

}