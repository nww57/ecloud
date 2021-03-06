package com.sunesoft.ecloud.caze.domain;

import com.sunesoft.ecloud.adminclient.TechnologyEnum;
import com.sunesoft.ecloud.hibernate.IEntity;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

/**
 * @Auther: niww
 * @Date: 2018/5/3/003
 */
@Entity
@Table(name = "pat_agent", schema = "springcloud", catalog = "")
public class PatAgent extends IEntity{

    /**
     * 所属专利
     */
    @ManyToOne
    @JoinColumn(name = "patentId")
    private PatentInfo patentInfo;

    /**
     * 代理机构代理人id
     */
    @Column(name = "agencyAgentId",columnDefinition = "char(36)")
    @Type(type = "uuid-char")
    private UUID agencyAgentId;

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
     * 用于区分第一、第二代理人
     */
    @Column(name = "sort")
    private int sort;

    /**
     * 技术领域
     */
    @Column(name = "techDomain")
    @Enumerated(EnumType.STRING)
    private TechnologyEnum techDomain;

    public PatAgent() {
    }

    public PatAgent(PatentInfo patentInfo) {
        this.patentInfo = patentInfo;
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

    public PatentInfo getPatentInfo() {
        return patentInfo;
    }

    public void setPatentInfo(PatentInfo patentInfo) {
        this.patentInfo = patentInfo;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public UUID getAgencyAgentId() {
        return agencyAgentId;
    }

    public void setAgencyAgentId(UUID agencyAgentId) {
        this.agencyAgentId = agencyAgentId;
    }

    public TechnologyEnum getTechDomain() {
        return techDomain;
    }

    public void setTechDomain(TechnologyEnum techDomain) {
        this.techDomain = techDomain;
    }
}
