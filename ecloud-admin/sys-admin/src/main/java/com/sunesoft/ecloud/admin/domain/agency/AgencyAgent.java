package com.sunesoft.ecloud.admin.domain.agency;

import com.sunesoft.ecloud.hibernate.BizEntity;
import com.sunesoft.ecloud.hibernate.IEntity;
import org.hibernate.annotations.Type;

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
