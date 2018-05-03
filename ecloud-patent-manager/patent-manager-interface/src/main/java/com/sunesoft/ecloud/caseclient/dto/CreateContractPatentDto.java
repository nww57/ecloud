package com.sunesoft.ecloud.caseclient.dto;

import com.sunesoft.ecloud.caseclient.PatentType;

import java.util.UUID;

/**
 * @Auther: niww
 * @Date: 2018/5/3/003
 * 创建合同案件dto
 */
public class CreateContractPatentDto {

    /**
     * 所属合同
     */
    private UUID contractId;

    /**
     * 专利类型
     */
    private PatentType patentType;

    /**
     * 案件号
     */
    private String caseNo;

    /**
     * 专利名称
     */
    private String patentName;

    public UUID getContractId() {
        return contractId;
    }

    public void setContractId(UUID contractId) {
        this.contractId = contractId;
    }

    public PatentType getPatentType() {
        return patentType;
    }

    public void setPatentType(PatentType patentType) {
        this.patentType = patentType;
    }

    public String getCaseNo() {
        return caseNo;
    }

    public void setCaseNo(String caseNo) {
        this.caseNo = caseNo;
    }

    public String getPatentName() {
        return patentName;
    }

    public void setPatentName(String patentName) {
        this.patentName = patentName;
    }
}
