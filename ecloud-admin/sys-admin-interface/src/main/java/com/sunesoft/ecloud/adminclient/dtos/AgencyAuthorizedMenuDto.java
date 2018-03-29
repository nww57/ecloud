package com.sunesoft.ecloud.adminclient.dtos;

import java.util.List;
import java.util.UUID;

/**
 * @author: jiangzhenjing
 * @date: 2018/3/29 下午1:12
 * -企业菜单权限
 */
public class AgencyAuthorizedMenuDto {


    private  UUID id;

    /**
     * 机构id
     */
    private UUID agencyId;

    /**
     * 菜单id
     */
    private UUID menuId;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(UUID agencyId) {
        this.agencyId = agencyId;
    }

    public UUID getMenuId() {
        return menuId;
    }

    public void setMenuId(UUID menuId) {
        this.menuId = menuId;
    }
}
