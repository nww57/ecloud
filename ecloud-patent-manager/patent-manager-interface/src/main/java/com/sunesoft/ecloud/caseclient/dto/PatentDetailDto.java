package com.sunesoft.ecloud.caseclient.dto;

import com.sunesoft.ecloud.adminclient.TechnologyEnum;
import com.sunesoft.ecloud.caseclient.enums.PatentType;

import java.util.List;
import java.util.UUID;

/**
 * @Author: niww
 * @Date: 2018/5/3
 */
public class PatentDetailDto extends PatentDetailBasicDto{


    /**
     * 申请人列表
     */
    private List<PatApplicantDto> applicantList;

    /**
     * 发明人列表
     */
    private List<PatInventorDto> inventorList;


    /**
     * 代理人列表
     */
    private List<PatAgentDto> agentList;


    /**
     * 优先权项里诶包
     */
    private List<PatPriorityClaimsDto> priorityClaimsList;

    public List<PatApplicantDto> getApplicantList() {
        return applicantList;
    }

    public void setApplicantList(List<PatApplicantDto> applicantList) {
        this.applicantList = applicantList;
    }

    public List<PatInventorDto> getInventorList() {
        return inventorList;
    }

    public void setInventorList(List<PatInventorDto> inventorList) {
        this.inventorList = inventorList;
    }

    public List<PatAgentDto> getAgentList() {
        return agentList;
    }

    public void setAgentList(List<PatAgentDto> agentList) {
        this.agentList = agentList;
    }

    public List<PatPriorityClaimsDto> getPriorityClaimsList() {
        return priorityClaimsList;
    }

    public void setPriorityClaimsList(List<PatPriorityClaimsDto> priorityClaimsList) {
        this.priorityClaimsList = priorityClaimsList;
    }
}
