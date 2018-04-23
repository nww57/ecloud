package com.sunesoft.ecloud.caze.query;

import com.sunesoft.ecloud.caseclient.PatentType;
import com.sunesoft.ecloud.caseclient.criterias.CaseInfoQueryCriteria;
import com.sunesoft.ecloud.caseclient.dto.CaseCustomerRequestDto;
import com.sunesoft.ecloud.caseclient.dto.CaseInfoListDto;
import com.sunesoft.ecloud.caseclient.dto.CaseMessageListDto;
import com.sunesoft.ecloud.common.cretiria.TCretiria;
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
        criteria.setPatentType(PatentType.INVENTION_PATENT);
        PagedResult<CaseInfoListDto> result = caseQueryService.queryCaseInfoByPaged(criteria);
        System.out.println(23);
    }

    @Test
    public void queryCaseBasicInfoById() throws Exception {
        TResult<CaseInfoListDto> result = caseQueryService.queryCaseBasicInfoById(UUID.fromString("a4c8362b-9e8e-4a08-a1eb-71ebd87e86da"));
        System.out.println(23);
    }

    @Test
    public void queryCaseCustomerRequestByPaged() throws Exception {
        PagedResult<CaseCustomerRequestDto> result = caseQueryService.queryCaseCustomerRequestByPaged(UUID.fromString("9cac8eaf-cd2d-4a9d-81ef-2526a71bd5fe"),new TCretiria());
        System.out.println(23);
    }

    @Test
    public void queryCaseMessageByPaged() throws Exception {
        PagedResult<CaseMessageListDto> result = caseQueryService.queryCaseMessageByPaged(UUID.fromString("9805ae93-3b2e-4cc8-b575-69fba4e87616"),new TCretiria());
        System.out.println(23);
    }

}
