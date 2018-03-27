package com.sunesoft.ecloud.admin.query.impl;

import com.sunesoft.ecloud.admin.query.AgencyQueryService;
import com.sunesoft.ecloud.adminclient.cretirias.AgencyCriteria;
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
        TResult<AgencyDto> result = agencyQueryService.findAgencyBasicInfoById(UUID.fromString("faa8cdeb-6ffd-4bbe-a9e1-c87398b54c1b"));
        System.out.println(213);
    }

    @Test
    public void findAgencyFullInfoById() throws Exception {
    }

}