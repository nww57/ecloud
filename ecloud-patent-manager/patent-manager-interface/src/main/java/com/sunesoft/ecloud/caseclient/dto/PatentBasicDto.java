package com.sunesoft.ecloud.caseclient.dto;

import com.sunesoft.ecloud.caseclient.PatentType;

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
     * 专利号
     */
    private String patentNo;

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

    public String getPatentNo() {
        return patentNo;
    }

    public void setPatentNo(String patentNo) {
        this.patentNo = patentNo;
    }

    public PatentType getPatentType() {
        return patentType;
    }

    public void setPatentType(PatentType patentType) {
        this.patentType = patentType;
    }
}
