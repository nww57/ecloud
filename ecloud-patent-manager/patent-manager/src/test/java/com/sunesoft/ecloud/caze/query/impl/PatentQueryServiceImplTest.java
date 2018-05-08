package com.sunesoft.ecloud.caze.query.impl;

import com.sunesoft.ecloud.caseclient.dto.PatentBasicDto;
import com.sunesoft.ecloud.caseclient.enums.PatentNode;
import com.sunesoft.ecloud.caze.query.PatentQueryService;
import com.sunesoft.ecloud.common.result.ListResult;
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
        ListResult<PatentBasicDto> list = queryService.getPatentBasicInfoByPatentNode(UUID.fromString("01d134d6-3eef-4b60-9979-c6392554da25"), PatentNode.TOBEIMPROVED);
        System.out.println(34);
    }

    @Test
    public void queryPatentPaged() throws Exception {
    }

    @Test
    public void getPatentInfoById() throws Exception {
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