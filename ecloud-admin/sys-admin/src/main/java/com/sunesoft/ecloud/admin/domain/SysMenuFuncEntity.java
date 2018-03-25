package com.sunesoft.ecloud.admin.domain;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @Author: niww
 * @Date: 2018/3/25
 */
@Entity
@Table(name = "sys_menu_func", schema = "ecloud", catalog = "")
public class SysMenuFuncEntity {
    private String id;
    private Byte isActive;
    private String name;
    private String resCode;
    private String resType;
    private String resName;
    private String resUrl;
    private String resRequestType;
    private String description;
    private Timestamp createDatetime;
    private String createBy;
    private Timestamp lastModifyDatetime;
    private String lastModifyBy;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "isActive")
    public Byte getIsActive() {
        return isActive;
    }

    public void setIsActive(Byte isActive) {
        this.isActive = isActive;
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
    @Column(name = "resCode")
    public String getResCode() {
        return resCode;
    }

    public void setResCode(String resCode) {
        this.resCode = resCode;
    }

    @Basic
    @Column(name = "resType")
    public String getResType() {
        return resType;
    }

    public void setResType(String resType) {
        this.resType = resType;
    }

    @Basic
    @Column(name = "resName")
    public String getResName() {
        return resName;
    }

    public void setResName(String resName) {
        this.resName = resName;
    }

    @Basic
    @Column(name = "resUrl")
    public String getResUrl() {
        return resUrl;
    }

    public void setResUrl(String resUrl) {
        this.resUrl = resUrl;
    }

    @Basic
    @Column(name = "resRequestType")
    public String getResRequestType() {
        return resRequestType;
    }

    public void setResRequestType(String resRequestType) {
        this.resRequestType = resRequestType;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SysMenuFuncEntity that = (SysMenuFuncEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(isActive, that.isActive) &&
                Objects.equals(name, that.name) &&
                Objects.equals(resCode, that.resCode) &&
                Objects.equals(resType, that.resType) &&
                Objects.equals(resName, that.resName) &&
                Objects.equals(resUrl, that.resUrl) &&
                Objects.equals(resRequestType, that.resRequestType) &&
                Objects.equals(description, that.description) &&
                Objects.equals(createDatetime, that.createDatetime) &&
                Objects.equals(createBy, that.createBy) &&
                Objects.equals(lastModifyDatetime, that.lastModifyDatetime) &&
                Objects.equals(lastModifyBy, that.lastModifyBy);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, isActive, name, resCode, resType, resName, resUrl, resRequestType, description, createDatetime, createBy, lastModifyDatetime, lastModifyBy);
    }
}
