package com.sunesoft.ecloud.adminclient.dtos;

import java.util.UUID;

/**
 * Created by jzj on 2018/4/11.
 * 代理人dto
 */
public class AgentDto {

    private UUID id;

    /**
     *姓名
     */
    private String name;

    /**
     *执业证号
     */
    private String licenseCode;

    /**
     *手机
     */
    private String mobile;

    /**
     *所属企业
     */
    private UUID agId;

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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public UUID getAgId() {
        return agId;
    }

    public void setAgId(UUID agId) {
        this.agId = agId;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
