package com.sunesoft.ecloud.caze.domain;

import com.sunesoft.ecloud.hibernate.IEntity;
import com.sunesoft.ecloud.hibernate.PatEntity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @Auther: niww
 * @Date: 2018/5/3/003
 */
@Entity
@Table(name = "pat_agent", schema = "springcloud", catalog = "")
public class PatAgent extends PatEntity{

    /**
     * 所属专利
     */
    @ManyToOne
    @JoinColumn(name = "patentId")
    private ContractPatentInfo patentInfo;

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
