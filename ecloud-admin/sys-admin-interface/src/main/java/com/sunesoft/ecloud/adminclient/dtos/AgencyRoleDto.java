package com.sunesoft.ecloud.adminclient.dtos;

import java.util.List;
import java.util.UUID;

/**
 * Created by jzj on 2018/3/26.
 * 角色信息
 */
public class AgencyRoleDto extends  BasicDto{

    /**
     * 所属企业id
     */
    private UUID agId;

    /**
     * 角色描述
     */
    private String description;

    /**
     * 权限信息
     */
    private List<AgencyRoleMenuDto> authList;


    public UUID getAgId() {
        return agId;
    }

    public void setAgId(UUID agId) {
        this.agId = agId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<AgencyRoleMenuDto> getAuthList() {
        return authList;
    }

    public void setAuthList(List<AgencyRoleMenuDto> authList) {
        this.authList = authList;
    }
}
