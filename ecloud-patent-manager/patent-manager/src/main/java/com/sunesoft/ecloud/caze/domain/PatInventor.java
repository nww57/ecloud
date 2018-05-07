package com.sunesoft.ecloud.caze.domain;

import com.sunesoft.ecloud.hibernate.IEntity;

import javax.persistence.*;

/**
 * @Auther: niww
 * @Date: 2018/5/3/003
 */
@Entity
@Table(name = "pat_inventor", schema = "springcloud", catalog = "")
public class PatInventor extends IEntity {

    /**
     * 所属专利
     */
    @ManyToOne
    @JoinColumn(name = "patentId")
    private PatentInfo patentInfo;

    /**
     * 姓名
     */
    @Column(name = "name")
    private String name;

    /**
     *国家code
     */
    @Column(name = "countryCode")
    private String countryCode;

    /**
     *国家name
     */
    @Column(name = "countryName")
    private String countryName;

    /**
     *身份证
     */
    @Column(name = "idCode")
    private String idCode;

    /**
     *是否公开
     */
    @Column(name = "open")
    private Boolean open;


    /**
     * 联系方式
     */
    @Column(name = "cellphone")
    private String cellphone;

    public PatInventor(PatentInfo patentInfo) {
        this.patentInfo = patentInfo;
    }

    public PatentInfo getPatentInfo() {
        return patentInfo;
    }

    public void setPatentInfo(PatentInfo patentInfo) {
        this.patentInfo = patentInfo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getIdCode() {
        return idCode;
    }

    public void setIdCode(String idCode) {
        this.idCode = idCode;
    }

    public Boolean getOpen() {
        return open;
    }

    public void setOpen(Boolean open) {
        this.open = open;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }
}
