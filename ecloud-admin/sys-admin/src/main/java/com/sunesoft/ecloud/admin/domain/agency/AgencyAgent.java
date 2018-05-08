package com.sunesoft.ecloud.admin.domain.agency;

import com.sunesoft.ecloud.adminclient.TechnologyEnum;
import com.sunesoft.ecloud.hibernate.BizEntity;

import javax.persistence.*;

/**
 * Created by jzj on 2018/4/11.
 * 代理人
 */
@Entity
@Table(name = "sys_ag_agent")
public class AgencyAgent extends BizEntity{

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
     *联系方式
     */
    @Column(name = "cellphone")
    private String cellphone;

    /**
     * 技术领域
     */
    @Column(name = "techDomain")
    @Enumerated(EnumType.STRING)
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

    public TechnologyEnum getTechDomain() {
        return techDomain;
    }

    public void setTechDomain(TechnologyEnum techDomain) {
        this.techDomain = techDomain;
    }
}
