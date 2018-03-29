package com.sunesoft.ecloud.adminclient.dtos;

import com.sunesoft.ecloud.adminclient.MenuType;

import java.util.UUID;

/**
 * @author: Zhouzh
 * @Date: 2018/3/26
 */
public class MenuSimpleDto {

    private UUID id;

    /**
     *菜单名称
     */
    private String name;

    /**
     *排序
     */
    private Integer sort;

    /**
     * 父级节点菜单
     */
    private MenuSimpleDto parentMenu;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public MenuSimpleDto getParentMenu() {
        return parentMenu;
    }

    public void setParentMenu(MenuSimpleDto parentMenu) {
        this.parentMenu = parentMenu;
    }

}
