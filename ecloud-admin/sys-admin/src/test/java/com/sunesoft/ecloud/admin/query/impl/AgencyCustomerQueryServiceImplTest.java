package com.sunesoft.ecloud.admin.query.impl;

import com.sunesoft.ecloud.admin.query.AgencyCustomerQueryService;
import com.sunesoft.ecloud.adminclient.cretirias.AgencyCustomerCriteria;
import com.sunesoft.ecloud.adminclient.dtos.AgencyCustomerDto;
import com.sunesoft.ecloud.common.result.PagedResult;
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
 * @Date: 2018/3/29/029
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class AgencyCustomerQueryServiceImplTest {

    @Autowired
    AgencyCustomerQueryService queryService;

    @Test
    public void findAgencyCustomerPaged() throws Exception {
        AgencyCustomerCriteria customerCriteria = new AgencyCustomerCriteria();
        customerCriteria.setPageIndex(0);
        PagedResult<AgencyCustomerDto> s = queryService.findAgencyCustomerPaged(customerCriteria);
        System.out.println(23);
    }

    @Test
    public void findAgencyCustomerBasicById() throws Exception {
        TResult<AgencyCustomerDto> dtoTResult = queryService.findAgencyCustomerBasicById(UUID.fromString("87a3f982-7a95-4072-ae24-e87385ca8d56"));
        System.out.println(23);
    }

}