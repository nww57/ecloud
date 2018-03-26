package com.sunesoft.ecloud.adminclient.dtos;

import java.util.List;

/**
 * @author: Zhouzh
 * @Date: 2018/3/26
 */
public class AgencyViewDto extends AgencyDto{

   private List<MenuDto> menuDtoList;

    public List<MenuDto> getMenuDtoList() {
        return menuDtoList;
    }

    public void setMenuDtoList(List<MenuDto> menuDtoList) {
        this.menuDtoList = menuDtoList;
    }
}
