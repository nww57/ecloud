package com.sunesoft.ecloud.admin.domain.menu;

import com.sunesoft.ecloud.hibernate.IEntity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @Author: niww
 * @Date: 2018/3/25
 * 模块
 */
@Entity
@Table(name = "sys_module", schema = "ecloud", catalog = "")
public class Module extends IEntity{

    /**
     * 模块代码
     */
    private String moduleCode;
    /**
     * 名称
     */
    private String moduleName;
    /**
     * 描述
     */
    private String moduleDesc;


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




}
