package com.sunesoft.ecloud.admin.domain;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @Author: niww
 * @Date: 2018/3/25
 */
@Entity
@Table(name = "company_structure", schema = "ecloud", catalog = "")
public class CompanyStructureEntity {
    private String id;
    private String parentId;
    private String compId;
    private String name;
    private String code;
    private String codeFull;
    private String description;
    private Timestamp createDatetime;
    private String createBy;
    private Timestamp lastModifyDatetime;
    private String lastModifyBy;
    private Integer childCount;
    private String leaderId;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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
    @Column(name = "createDatetime")
    public Timestamp getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(Timestamp createDatetime) {
        this.createDatetime = createDatetime;
    }

    @Basic
    @Column(name = "createBy")
    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    @Basic
    @Column(name = "lastModifyDatetime")
    public Timestamp getLastModifyDatetime() {
        return lastModifyDatetime;
    }

    public void setLastModifyDatetime(Timestamp lastModifyDatetime) {
        this.lastModifyDatetime = lastModifyDatetime;
    }

    @Basic
    @Column(name = "lastModifyBy")
    public String getLastModifyBy() {
        return lastModifyBy;
    }

    public void setLastModifyBy(String lastModifyBy) {
        this.lastModifyBy = lastModifyBy;
    }

    @Basic
    @Column(name = "childCount")
    public Integer getChildCount() {
        return childCount;
    }

    public void setChildCount(Integer childCount) {
        this.childCount = childCount;
    }

    @Basic
    @Column(name = "leaderId")
    public String getLeaderId() {
        return leaderId;
    }

    public void setLeaderId(String leaderId) {
        this.leaderId = leaderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompanyStructureEntity that = (CompanyStructureEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(parentId, that.parentId) &&
                Objects.equals(compId, that.compId) &&
                Objects.equals(name, that.name) &&
                Objects.equals(code, that.code) &&
                Objects.equals(codeFull, that.codeFull) &&
                Objects.equals(description, that.description) &&
                Objects.equals(createDatetime, that.createDatetime) &&
                Objects.equals(createBy, that.createBy) &&
                Objects.equals(lastModifyDatetime, that.lastModifyDatetime) &&
                Objects.equals(lastModifyBy, that.lastModifyBy) &&
                Objects.equals(childCount, that.childCount) &&
                Objects.equals(leaderId, that.leaderId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, parentId, compId, name, code, codeFull, description, createDatetime, createBy, lastModifyDatetime, lastModifyBy, childCount, leaderId);
    }
}
