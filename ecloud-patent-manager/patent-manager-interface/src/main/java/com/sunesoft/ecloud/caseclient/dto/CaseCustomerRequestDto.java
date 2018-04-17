package com.sunesoft.ecloud.caseclient.dto;

import com.sunesoft.ecloud.caseclient.CaseCustomerRequestType;

import java.util.UUID;

/**
 * @Auther: niww
 * @Date: 2018/4/13/013
 */
public class CaseCustomerRequestDto {


    /**
     * 案件id
     */
    private UUID caseId;

    private UUID id;

    /**
     * 要求类型
     */
    private CaseCustomerRequestType requestType;

    /**
     *标题
     */
    private String title;

    /**
     *描述
     */
    private String description;

    public UUID getCaseId() {
        return caseId;
    }

    public void setCaseId(UUID caseId) {
        this.caseId = caseId;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public CaseCustomerRequestType getRequestType() {
        return requestType;
    }

    public void setRequestType(CaseCustomerRequestType requestType) {
        this.requestType = requestType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
