package com.sunesoft.ecloud.adminclient.dtos;

/**
 * @author: Zhouzh
 * @Date: 2018/3/26
 */
public class MenuWithSelectDto extends MenuDto {


    private Boolean selected;

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }
}
