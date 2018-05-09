package com.sunesoft.ecloud.caze.query.impl;

import com.sunesoft.ecloud.caseclient.criterias.PatentNodeQueryCriteria;
import com.sunesoft.ecloud.caseclient.criterias.PatentQueryCriteria;
import com.sunesoft.ecloud.caseclient.dto.PatentBasicDto;
import com.sunesoft.ecloud.caseclient.dto.PatentDetailDto;
import com.sunesoft.ecloud.caseclient.dto.PatentListDto;
import com.sunesoft.ecloud.caseclient.enums.PatentNode;
import com.sunesoft.ecloud.caseclient.enums.PatentType;
import com.sunesoft.ecloud.caze.query.PatentQueryService;
import com.sunesoft.ecloud.common.result.ListResult;
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
 * @Date: 2018/5/7/007
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class PatentQueryServiceImplTest {

    @Autowired
    PatentQueryService queryService;
    private static final UUID AGID = UUID.fromString("01d134d6-3eef-4b60-9979-c6392554da25");
    @Test
    public void getPatentNodeCount() throws Exception {
        queryService.getPatentNodeCount(AGID);
    }

    @Test
    public void getPatentBasicInfoByPatentNode() throws Exception {
        PatentNodeQueryCriteria criteria = new PatentNodeQueryCriteria();
        criteria.setAgId(UUID.fromString("01d134d6-3eef-4b60-9979-c6392554da25"));
        criteria.setPatentNode(PatentNode.TOBEIMPROVED);
        ListResult<PatentBasicDto> list = queryService.getPatentBasicInfoByPatentNode(criteria);
        System.out.println(34);
    }

    @Test
    public void queryPatentPaged() throws Exception {
        PatentQueryCriteria criteria = new PatentQueryCriteria();
        criteria.setPageIndex(0);
        criteria.setAgId(AGID);
        criteria.setPatentType(PatentType.INVENTION_PATENT);
        PagedResult<PatentListDto> result = queryService.queryPatentPaged(criteria);
        System.out.println(23);
    }

    @Test
    public void getPatentInfoById() throws Exception {
        TResult<PatentDetailDto> dto = queryService.getPatentInfoById(UUID.fromString("c3b1679c-7320-43ab-8fc4-96ee1358c067"));
        System.out.println(23);
    }

    @Test
    public void getPatentElement() throws Exception {
    }

    @Test
    public void getPatentOfficialFeeInfo() throws Exception {
    }

    @Test
    public void getPatentApplicants() throws Exception {
    }

    @Test
    public void getPatentInventors() throws Exception {
    }

    @Test
    public void getPatentAgents() throws Exception {
    }

    @Test
    public void getPatentPriorityClaims() throws Exception {
    }

}