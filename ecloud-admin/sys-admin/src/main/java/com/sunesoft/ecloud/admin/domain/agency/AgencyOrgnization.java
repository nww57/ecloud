package com.sunesoft.ecloud.admin.domain.agency;

import com.sunesoft.ecloud.admin.domain.menu.Menu;
import com.sunesoft.ecloud.hibernate.BizEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: niww
 * @Date: 2018/3/25
 * 企业组织架构
 */
@Entity
@Table(name = "sys_ag_organization")
public class AgencyOrgnization extends BizEntity{


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
    @Column(name = "name")
    private Integer childCount;

    @ManyToOne
    @JoinColumn(name = "agId")
    private Agency agency;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pid")
    private AgencyOrgnization parentOrg;

    @OneToMany(targetEntity = AgencyOrgnization.class, cascade = { CascadeType.ALL }, mappedBy = "parentOrg")
    private List<AgencyOrgnization> childOrgList = new ArrayList<>();


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

    public AgencyOrgnization getParentOrg() {
        return parentOrg;
    }

    public void setParentOrg(AgencyOrgnization parentOrg) {
        this.parentOrg = parentOrg;
    }

    public List<AgencyOrgnization> getChildOrgList() {
        return childOrgList;
    }

    public void setChildOrgList(List<AgencyOrgnization> childOrgList) {
        this.childOrgList = childOrgList;
    }
}
