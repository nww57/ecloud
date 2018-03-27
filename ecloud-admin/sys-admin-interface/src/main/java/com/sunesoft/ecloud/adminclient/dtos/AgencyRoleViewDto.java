package com.sunesoft.ecloud.adminclient.dtos;

import java.util.List;

/**
 * @Auther: niww
 * @Date: 2018/3/27/027
 */
public class AgencyRoleViewDto extends AgencyRoleDto{

    /**
     * 所有菜单信息
     */
    private List<MenuDto> menuList;

    public List<MenuDto> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<MenuDto> menuList) {
        this.menuList = menuList;
    }
}
