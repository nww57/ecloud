package com.sunesoft.ecloud.adminclient.dtos;

import java.util.UUID;

/**
 * @author: jiangzhenjing
 * @date: 2018/3/26 下午6:54
 * -
 */
public class ModuleDto {

    private UUID uuid;

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

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getModuleDesc() {
        return moduleDesc;
    }

    public void setModuleDesc(String moduleDesc) {
        this.moduleDesc = moduleDesc;
    }
}
