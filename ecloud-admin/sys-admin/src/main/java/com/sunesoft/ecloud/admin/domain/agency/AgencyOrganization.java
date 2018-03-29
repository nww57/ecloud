package com.sunesoft.ecloud.admin.domain.agency;

import com.sunesoft.ecloud.hibernate.BizEntity;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @Author: niww
 * @Date: 2018/3/25
 * 企业组织架构
 */
@Entity
@Table(name = "sys_ag_organization")
public class AgencyOrganization extends BizEntity{


    /**
     *名称
     */
    @Column(name = "name")
    private String name;
    /**
     *代码
     */
    @Column(name = "code")
    private String code;
    /**
     *完整代码
     */
    @Column(name = "codeFull")
    private String codeFull;
    /**
     *描述
     */
    @Column(name = "description")
    private String description;
    /**
     *子节点数
     */
    @Column(name = "childCount")
    private Integer childCount;

    /**
     *负责人Id
     */
    @Column(name = "leaderId",columnDefinition = "char(36)")
    @Type(type = "uuid-char")
    private UUID leaderId;

    @ManyToOne
    @JoinColumn(name = "agId")
    private Agency agency;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parentId")
    private AgencyOrganization parentOrg;

    @OneToMany(targetEntity = AgencyOrganization.class, cascade = { CascadeType.ALL }, mappedBy = "parentOrg")
    private List<AgencyOrganization> childOrgList = new ArrayList<>();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCodeFull() {
        return codeFull;
    }

    public void setCodeFull(String codeFull) {
        this.codeFull = codeFull;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getChildCount() {
        return childCount;
    }

    public void setChildCount(Integer childCount) {
        this.childCount = childCount;
    }

    public Agency getAgency() {
        return agency;
    }

    public void setAgency(Agency agency) {
        this.agency = agency;
    }

    public AgencyOrganization getParentOrg() {
        return parentOrg;
    }

    public void setParentOrg(AgencyOrganization parentOrg) {
        this.parentOrg = parentOrg;
    }

    public List<AgencyOrganization> getChildOrgList() {
        return childOrgList;
    }

    public void setChildOrgList(List<AgencyOrganization> childOrgList) {
        this.childOrgList = childOrgList;
    }

    public UUID getLeaderId() {
        return leaderId;
    }

    public void setLeaderId(UUID leaderId) {
        this.leaderId = leaderId;
    }
}
