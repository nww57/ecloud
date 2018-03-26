package com.sunesoft.ecloud.admin.domain;

import com.sunesoft.ecloud.hibernate.BizEntity;

import javax.persistence.*;

/**
 * @Author: niww
 * @Date: 2018/3/25
 * 企业组织架构
 */
@Entity
@Table(name = "company_structure", schema = "ecloud", catalog = "")
public class CompanyStructure extends BizEntity{

    private String parentId;
    private String compId;
    /**
     *
     */
    private String name;
    /**
     *
     */
    private String code;
    /**
     *
     */
    private String codeFull;
    /**
     *
     */
    private String description;
    /**
     *
     */
    private Integer childCount;
    /**
     *
     */



    @Basic
    @Column(name = "parentId")
    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    @Basic
    @Column(name = "compId")
    public String getCompId() {
        return compId;
    }

    public void setCompId(String compId) {
        this.compId = compId;
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



}
