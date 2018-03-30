package com.sunesoft.ecloud.adminclient.dtos;

import java.util.UUID;

/**
 * @Author: niww
 * @Date: 2018/3/30
 */
public class MenuFuncIdDto {

    private UUID menuId;
    private UUID funcId;

    public UUID getMenuId() {
        return menuId;
    }

    public void setMenuId(UUID menuId) {
        this.menuId = menuId;
    }

    public UUID getFuncId() {
        return funcId;
    }

    public void setFuncId(UUID funcId) {
        this.funcId = funcId;
    }
}
