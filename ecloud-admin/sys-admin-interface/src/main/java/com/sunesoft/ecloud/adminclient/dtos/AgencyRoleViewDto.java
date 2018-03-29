package com.sunesoft.ecloud.adminclient.dtos;

import java.util.List;

/**
 * @Auther: niww
 * @Date: 2018/3/27/027
 */
public class AgencyRoleViewDto extends BasicDto{

    /**
     * 描述
     */
    private String description;

    /**
     * 所有菜单信息
     */
    private List<RoleMenuCheckedDto> menuList;

    public List<RoleMenuCheckedDto> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<RoleMenuCheckedDto> menuList) {
        this.menuList = menuList;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
