package com.sunesoft.ecloud.caze.query.impl;

import com.sunesoft.ecloud.caseclient.criterias.ContractQueryCriteria;
import com.sunesoft.ecloud.caseclient.dto.ContractDetailDto;
import com.sunesoft.ecloud.caseclient.dto.ContractDto;
import com.sunesoft.ecloud.caze.query.ContractQueryService;
import com.sunesoft.ecloud.common.result.PagedResult;
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
 * @Date: 2018/5/4/004
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class ContractQueryServiceImplTest {

    @Autowired
    ContractQueryService contractQueryService;

    private static final UUID AGID = UUID.fromString("01d134d6-3eef-4b60-9979-c6392554da25");
    @Test
    public void queryContractPaged() throws Exception {
        ContractQueryCriteria criteria  =new ContractQueryCriteria();
        criteria.setPageIndex(0);
        criteria.setAgId(AGID);
        PagedResult<ContractDto> list = contractQueryService.queryContractPaged(criteria);
        System.out.println(23);
    }

    @Test
    public void getContractDetailById() throws Exception {
        TResult<ContractDetailDto> result = contractQueryService.getContractDetailById(UUID.fromString("d58827df-6f5a-421a-a935-3c2102a48e87"));
        System.out.println(23);
    }

}