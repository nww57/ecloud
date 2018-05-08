package com.sunesoft.ecloud.caze.service.impl;

import com.sunesoft.ecloud.adminclient.AgencyType;
import com.sunesoft.ecloud.caseclient.dto.*;
import com.sunesoft.ecloud.caseclient.enums.PatentType;
import com.sunesoft.ecloud.caseclient.enums.TechnologyEnum;
import com.sunesoft.ecloud.caze.domain.PatInventor;
import com.sunesoft.ecloud.caze.service.PatentService;
import com.sunesoft.ecloud.common.result.TResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.*;

/**
 * @Auther: niww
 * @Date: 2018/5/4/004
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class PatentServiceImplTest {

    @Autowired
    PatentService patentService;

    private static final UUID AGID = UUID.fromString("01d134d6-3eef-4b60-9979-c6392554da25");

    @Test
    public void addPatent() throws Exception {
        CreateContractPatentDto dto = new CreateContractPatentDto();
        dto.setAgId(AGID);
        dto.setCaseNo(patentService.generateCaseNo(AGID).getResult().toString());
        dto.setContractId(UUID.fromString("559d1e13-bc8c-4afe-bdd4-583e19cb4ce2"));
        dto.setPatentType(PatentType.UTILITYMODEL_PATENT);
        dto.setPatentName("测试专利-这是一个实用新型");
        dto.setCreatorId(UUID.fromString("fc98e1ca-92f0-4f2e-b68c-f0129978c1bf"));
        TResult result = patentService.addPatent(dto);
        System.out.println(23);
    }

    @Test
    public void updatePatentInfo() throws Exception{
        UpdatePatentDto dto = new UpdatePatentDto();
        dto.setPatentId(UUID.fromString("fa27f9c5-80e6-46b2-9f6e-71cfb008ba23"));
        dto.setPatentName("修改一一下专利名称");
        dto.setTechDomain(TechnologyEnum.BIOMEDICINE);
        dto.setEngineerLeaderId(UUID.fromString("fc98e1ca-92f0-4f2e-b68c-f0129978c1bf"));

        dto.setIsAdvancePublicity(true);
        dto.setIsFeeReduce(true);
        dto.setIsRealTrial(true);
        dto.setIsReqPriority(true);

        List<PatPriorityClaimsDto> claimsDtoList = new ArrayList<>();
        PatPriorityClaimsDto claimsDto = new PatPriorityClaimsDto();
        claimsDto.setPriorAgencyName("优先权项-测试一下");
        claimsDtoList.add(claimsDto);
        PatPriorityClaimsDto claimsDto2 = new PatPriorityClaimsDto();
        claimsDto2.setPriorAgencyName("优先权项2-测试一下");
        claimsDtoList.add(claimsDto2);
        dto.setPriorityClaimsList(claimsDtoList);

        List<PatApplicantDto> applicantDtoList = new ArrayList();
        PatApplicantDto applicantDto = new PatApplicantDto();
        applicantDto.setName("申请人-测试一下");
        applicantDtoList.add(applicantDto);
        PatApplicantDto applicantDto2 = new PatApplicantDto();
        applicantDto2.setName("申请人2-测试一下");
        applicantDtoList.add(applicantDto2);
        dto.setApplicantList(applicantDtoList);

        List<PatInventorDto> inventorDtoList = new ArrayList<>();
        PatInventorDto inventorDto = new PatInventorDto();
        inventorDto.setName("发明人2-测试一下");
        inventorDtoList.add(inventorDto);
        PatInventorDto inventorDto2 = new PatInventorDto();
        inventorDto2.setName("发明人2-测试一下");
        inventorDtoList.add(inventorDto2);
        dto.setInventorList(inventorDtoList);

        List<PatAgentDto> agentDtoList = new ArrayList<>();
        PatAgentDto agentDto = new PatAgentDto();
        agentDto.setName("代理人-测试一下");
        agentDtoList.add(agentDto);
        PatAgentDto agentDto2 = new PatAgentDto();
        agentDto2.setName("代理人2-测试一下");
        agentDtoList.add(agentDto2);
        dto.setAgentList(agentDtoList);

        patentService.updatePatent(dto);
        System.out.println(23);
    }

    @Test
    public void deletePatent() throws Exception {
    }

    @Test
    public void deletePatent1() throws Exception {
    }

}