package com.sunesoft.ecloud.adminclient.dtos;

import com.sunesoft.ecloud.common.sqlBuilderTool.annotations.SqlIgnore;

import java.util.List;
import java.util.UUID;

/**
 * @auther: niww
 * @date: 2018/5/24/024
 */
public class FlowRoleUserDto {

    private UUID roleId;

    private String name;

    private String code;

    private String description;

    @SqlIgnore
    private List<BasicDto> userList;


    public UUID getRoleId() {
        return roleId;
    }

    public void setRoleId(UUID roleId) {
        this.roleId = roleId;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<BasicDto> getUserList() {
        return userList;
    }

    public void setUserList(List<BasicDto> userList) {
        this.userList = userList;
    }
}
