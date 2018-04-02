package com.sunesoft.ecloud.adminclient.dtos;


import com.sunesoft.ecloud.adminclient.UserType;

import java.util.*;
/**
 * @author: Zhouzh
 * @Date: 2018/3/23
 */
public class UserDto extends UserBasicDto{


    /**
     * 所属机构-id
     */
    private UUID organizationId;

    /**
     * 所属机构-名称
     */
    private String organizationName;


    /**
     * 角色Id
     */
    private List<UUID> roleIdList;

    /**
     * 角色名称
     */
    private List<String> roleNameList;

    private UUID agId;

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public List<String> getRoleNameList() {
        return roleNameList;
    }

    public void setRoleNameList(List<String> roleNameList) {
        this.roleNameList = roleNameList;
    }


    public List<UUID> getRoleIdList() {
        return roleIdList;
    }

    public void setRoleIdList(List<UUID> roleIdList) {
        this.roleIdList = roleIdList;
    }

    public UUID getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(UUID organizationId) {
        this.organizationId = organizationId;
    }

    public UUID getAgId() {
        return agId;
    }

    public void setAgId(UUID agId) {
        this.agId = agId;
    }
}
