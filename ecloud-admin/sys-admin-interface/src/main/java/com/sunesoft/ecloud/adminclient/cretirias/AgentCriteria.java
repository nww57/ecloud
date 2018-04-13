package com.sunesoft.ecloud.adminclient.cretirias;

import com.sunesoft.ecloud.common.cretiria.TCretiria;

import java.util.UUID;

/**
 * @Auther: niww
 * @Date: 2018/4/12/
 */
public class AgentCriteria extends TCretiria {

    /**
     * 所属企业id
     */
    private UUID agId;

    /**
     * 姓名
     */
    private String name;

    /**
     *执业证号
     */
    private String licenseCode;

    /**
     * 手机
     */
    private String mobile;

    /**
     * 关键字
     */
    private String keywords;

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

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }
}
