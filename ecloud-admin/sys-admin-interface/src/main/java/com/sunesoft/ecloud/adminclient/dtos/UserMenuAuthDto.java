package com.sunesoft.ecloud.adminclient.dtos;


import java.util.List;

/**
 * @Auther: niww
 * @Date: 2018/4/3/003
 */
public class UserMenuAuthDto extends UserBasicDto{


    private List<MenuDto> menuList;

    public List<MenuDto> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<MenuDto> menuList) {
        this.menuList = menuList;
    }
}
