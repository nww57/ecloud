package com.sunesoft.ecloud.adminclient.dtos;


import java.util.List;

/**
 * @Auther: niww
 * @Date: 2018/4/3/003
 */
public class UserMenuAuthDto extends UserBasicDto{


    private List<MenuDto> userMenu;

    public List<MenuDto> getUserMenu() {
        return userMenu;
    }

    public void setUserMenu(List<MenuDto> userMenu) {
        this.userMenu = userMenu;
    }
}
