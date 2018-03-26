package com.sunesoft.ecloud.admin.domain;

import com.sunesoft.ecloud.hibernate.BizEntity;

import javax.persistence.*;

/**
 * @Author: niww
 * @Date: 2018/3/25
 * 企业组织架构
 */
@Entity
@Table(name = "sys_company_structure", schema = "ecloud", catalog = "")
public class CompanyStructure extends BizEntity{

    /**
     * 父级id
     */
    private String parentId;

    /**
     *名称
     */
    private String name;
    /**
     *代码
     */
    private String code;
    /**
     *完整代码
     */
    private String codeFull;
    /**
     *描述
     */
    private String description;
    /**
     *子节点数
     */
    private Integer childCount;

    @ManyToOne
    @JoinColumn(name = "compId")
    private Company company;

    @Basic
    @Column(name = "parentId")
    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }



    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "code")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    @Column(name = "codeFull")
    public String getCodeFull() {
        return codeFull;
    }

    public void setCodeFull(String codeFull) {
        this.codeFull = codeFull;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Basic
    @Column(name = "childCount")
    public Integer getChildCount() {
        return childCount;
    }

    public void setChildCount(Integer childCount) {
        this.childCount = childCount;
    }


    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
