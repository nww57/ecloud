package com.sunesoft.ecloud.caseclient.dto;

import com.sunesoft.ecloud.caseclient.enums.PatentType;

import java.util.UUID;

/**
 * @Auther: niww
 * @Date: 2018/4/13/013
 */
public class PatentBasicDto {

    private UUID id;

    /**
     * 专利名称
     */
    private String name;

    /**
     * 案件号
     */
    private String caseNo;

    /**
     * 专利类型
     */
    private PatentType patentType;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCaseNo() {
        return caseNo;
    }

    public void setCaseNo(String caseNo) {
        this.caseNo = caseNo;
    }

    public PatentType getPatentType() {
        return patentType;
    }

    public void setPatentType(PatentType patentType) {
        this.patentType = patentType;
    }
}
