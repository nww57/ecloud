package com.sunesoft.ecloud.adminclient.dtos;

import java.util.List;

/**
 * @Auther: niww
 * @Date: 2018/3/27/
 */
public class UserViewDto extends UserDto {

    /**
     * 角色信息列表
     */
    private List<BasicDto> roleList;

    /**
     * 机构信息列表
     */
    private List<BasicDto> agencyList;

    public List<BasicDto> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<BasicDto> roleList) {
        this.roleList = roleList;
    }

    public List<BasicDto> getAgencyList() {
        return agencyList;
    }

    public void setAgencyList(List<BasicDto> agencyList) {
        this.agencyList = agencyList;
    }
}
