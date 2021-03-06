package com.sunesoft.ecloud.caze.domain;

import com.sunesoft.ecloud.hibernate.IEntity;

import javax.persistence.*;

/**
 * @Auther: niww
 * @Date: 2018/5/3/003
 * 优先权项
 */
@Entity
@Table(name = "pat_priorityclaims", schema = "springcloud", catalog = "")
public class PatPriorityClaims extends IEntity {

    /**
     * 所属专利
     */
    @ManyToOne
    @JoinColumn(name = "patentId")
    private PatentInfo patentInfo;

    /**
     *原受理机构名称
     */
    @Column(name = "priorAgencyName")
    private String priorAgencyName;
    /**
     *国别名称
     */
    @Column(name = "countryName")
    private String countryName;
    /**
     *国别Code
     */
    @Column(name = "countryCode")
    private String countryCode;
    /**
     *在先申请日
     */
    @Column(name = "priorApplicationDate")
    private String priorApplicationDate;
    /**
     *在先申请号
     */
    @Column(name = "priorApplicationNo")
    private String priorApplicationNo;

    public PatPriorityClaims() {
    }

    public PatPriorityClaims(PatentInfo patentInfo) {
        this.patentInfo = patentInfo;
    }

    public PatentInfo getPatentInfo() {
        return patentInfo;
    }

    public void setPatentInfo(PatentInfo patentInfo) {
        this.patentInfo = patentInfo;
    }

    public String getPriorAgencyName() {
        return priorAgencyName;
    }

    public void setPriorAgencyName(String priorAgencyName) {
        this.priorAgencyName = priorAgencyName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getPriorApplicationDate() {
        return priorApplicationDate;
    }

    public void setPriorApplicationDate(String priorApplicationDate) {
        this.priorApplicationDate = priorApplicationDate;
    }

    public String getPriorApplicationNo() {
        return priorApplicationNo;
    }

    public void setPriorApplicationNo(String priorApplicationNo) {
        this.priorApplicationNo = priorApplicationNo;
    }
}
