package com.sunesoft.ecloud.adminclient.dtos;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by jzj on 2018/3/26.
 * 角色信息
 */
public class AgencyRoleDto extends  BasicDto{


    /**
     * 角色描述
     */
    private String description;

    /**
     * 权限信息
     */
    private Map<UUID,List<UUID>> authList;


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Map<UUID, List<UUID>> getAuthList() {
        return authList;
    }

    public void setAuthList(Map<UUID, List<UUID>> authList) {
        this.authList = authList;
    }
}
