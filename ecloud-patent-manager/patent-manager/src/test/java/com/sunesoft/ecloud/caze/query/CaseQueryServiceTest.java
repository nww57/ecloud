package com.sunesoft.ecloud.caze.query;

import com.sunesoft.ecloud.caseclient.criterias.CaseInfoQueryCriteria;
import com.sunesoft.ecloud.caseclient.dto.CaseCustomerRequestDto;
import com.sunesoft.ecloud.caseclient.dto.CaseInfoListDto;
import com.sunesoft.ecloud.caseclient.dto.CaseMessageListDto;
import com.sunesoft.ecloud.common.cretiria.TCretiria;
import com.sunesoft.ecloud.common.result.PagedResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

import static org.junit.Assert.*;

/**
 * @Auther: niww
 * @Date: 2018/4/16/016
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CaseQueryServiceTest {

    @Autowired
    CaseQueryService caseQueryService;

    @Test
    public void queryCaseInfoByPaged() throws Exception {
        CaseInfoQueryCriteria criteria  = new CaseInfoQueryCriteria();
        criteria.setAgId(UUID.fromString("01d134d6-3eef-4b60-9979-c6392554da25"));
        PagedResult<CaseInfoListDto> result = caseQueryService.queryCaseInfoByPaged(criteria);
        System.out.println(23);
    }

    @Test
    public void queryCaseBasicInfoById() throws Exception {
    }

    @Test
    public void queryCaseCustomerRequestByPaged() throws Exception {
        PagedResult<CaseCustomerRequestDto> result = caseQueryService.queryCaseCustomerRequestByPaged(UUID.fromString("9cac8eaf-cd2d-4a9d-81ef-2526a71bd5fe"),new TCretiria());
        System.out.println(23);
    }

    @Test
    public void queryCaseMessageByPaged() throws Exception {
        PagedResult<CaseMessageListDto> result = caseQueryService.queryCaseMessageByPaged(UUID.fromString("9cac8eaf-cd2d-4a9d-81ef-2526a71bd5fe"),new TCretiria());
        System.out.println(23);
    }

}
