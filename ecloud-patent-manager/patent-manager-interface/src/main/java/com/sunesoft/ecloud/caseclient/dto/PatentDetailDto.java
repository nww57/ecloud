package com.sunesoft.ecloud.caseclient.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: niww
 * @Date: 2018/5/3
 */
public class PatentDetailDto extends PatentDetailBasicDto{


    /**
     * 申请人列表
     */
    private List<PatApplicantDto> applicantList = new ArrayList<>();

    /**
     * 发明人列表
     */
    private List<PatInventorDto> inventorList = new ArrayList<>();


    /**
     * 代理人列表
     */
    private List<PatAgentDto> agentList = new ArrayList<>();


    /**
     * 优先权项里诶包
     */
    private List<PatPriorityClaimsDto> priorityClaimsList = new ArrayList<>();

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
