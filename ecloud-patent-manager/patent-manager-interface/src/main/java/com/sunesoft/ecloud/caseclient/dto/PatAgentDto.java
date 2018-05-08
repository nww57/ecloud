package com.sunesoft.ecloud.caseclient.dto;

import java.util.UUID;

/**
 * @Author: niww
 * @Date: 2018/5/3
 */
public class PatAgentDto {


    private UUID id;

    private UUID patentId;

    /**
     * 姓名
     */
    private String name;

    /**
     *执证证号
     */
    private String licenseCode;

    /**
     *联系方式
     */
    private String cellphone;

    /**
     * 用于区分第一、第二代理人
     * 1 第一代理人
     * 2 第二代理人
     */
    private int sort;

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getPatentId() {
        return patentId;
    }

    public void setPatentId(UUID patentId) {
        this.patentId = patentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLicenseCode() {
        return licenseCode;
    }

    public void setLicenseCode(String licenseCode) {
        this.licenseCode = licenseCode;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }
}
