package com.sunesoft.ecloud.admin.domain.agency;

import com.sunesoft.ecloud.hibernate.IEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.UUID;

/**
 * Created by jzj on 2018/4/11.
 * 代理人
 */
@Entity
@Table(name = "sys_ag_agent")
public class AgencyAgent extends IEntity{

    /**
     * 姓名
     */
    @Column(name = "name")
    private String name;

    /**
     *执证证号
     */
    @Column(name = "licenseCode")
    private String licenseCode;

    /**
     *手机号
     */
    @Column(name = "mobile")
    private String mobile;

    /**
     *所属企业
     */
    @Column(name = "agId")
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
}
