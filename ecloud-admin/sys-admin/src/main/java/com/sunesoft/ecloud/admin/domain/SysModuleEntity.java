package com.sunesoft.ecloud.admin.domain;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @Author: niww
 * @Date: 2018/3/25
 */
@Entity
@Table(name = "sys_module", schema = "ecloud", catalog = "")
public class SysModuleEntity {
    private String id;
    private Byte isActive;
    private String moduleCode;
    private String moduleName;
    private String moduleDesc;
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
    @Column(name = "moduleCode")
    public String getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    @Basic
    @Column(name = "moduleName")
    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    @Basic
    @Column(name = "moduleDesc")
    public String getModuleDesc() {
        return moduleDesc;
    }

    public void setModuleDesc(String moduleDesc) {
        this.moduleDesc = moduleDesc;
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
        SysModuleEntity that = (SysModuleEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(isActive, that.isActive) &&
                Objects.equals(moduleCode, that.moduleCode) &&
                Objects.equals(moduleName, that.moduleName) &&
                Objects.equals(moduleDesc, that.moduleDesc) &&
                Objects.equals(createDatetime, that.createDatetime) &&
                Objects.equals(createBy, that.createBy) &&
                Objects.equals(lastModifyDatetime, that.lastModifyDatetime) &&
                Objects.equals(lastModifyBy, that.lastModifyBy);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, isActive, moduleCode, moduleName, moduleDesc, createDatetime, createBy, lastModifyDatetime, lastModifyBy);
    }
}
