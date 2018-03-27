package com.sunesoft.ecloud.adminclient.dtos;

import java.util.List;
import java.util.UUID;

/**
 * Created by jzj on 2018/3/26.
 * 角色菜单权限
 */
public class AgencyRoleMenuDto {

    /**
     * 菜单id
     */
    private UUID menuId;

    /**
     * 功能id
     */
    private List<UUID> funcId;

    public UUID getMenuId() {
        return menuId;
    }

    public void setMenuId(UUID menuId) {
        this.menuId = menuId;
    }

    public List<UUID> getFuncId() {
        return funcId;
    }

    public void setFuncId(List<UUID> funcId) {
        this.funcId = funcId;
    }

}
