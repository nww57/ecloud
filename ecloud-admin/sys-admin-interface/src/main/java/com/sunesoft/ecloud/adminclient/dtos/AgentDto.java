package com.sunesoft.ecloud.adminclient.dtos;

import com.sunesoft.ecloud.adminclient.TechnologyEnum;

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
     *联系方式
     */
    private String cellphone;

    /**
     *所属企业
     */
    private UUID agId;

    /**
     * 技术领域
     */
    private TechnologyEnum techDomain;

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

    public TechnologyEnum getTechDomain() {
        return techDomain;
    }

    public void setTechDomain(TechnologyEnum techDomain) {
        this.techDomain = techDomain;
    }
}
