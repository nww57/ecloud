package com.sunesoft.ecloud.adminclient.dtos;


import com.sunesoft.ecloud.adminclient.MenuType;
import com.sunesoft.ecloud.common.TreeEntity;
import com.sunesoft.ecloud.common.sqlBuilderTool.annotations.AliasName;
import com.sunesoft.ecloud.common.sqlBuilderTool.annotations.FieldWithoutCheck;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author: Zhouzh
 * @Date: 2018/3/26
 */
public class MenuSimpleDto extends TreeEntity {


    /**
     * 索引
     */
    private String menuIndex;

    /**
     *菜单名称
     */
    private String name;

    /**
     *排序
     */
    private Integer sort;


    /**
     * 子级节点菜单
     */
    private List<MenuSimpleDto> chiledren= new ArrayList<>();


    public String getMenuIndex() {
        return menuIndex;
    }

    public void setMenuIndex(String menuIndex) {
        this.menuIndex = menuIndex;
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

    public List<MenuSimpleDto> getChiledren() {
        return chiledren;
    }

    public void setChiledren(List list) {
        this.chiledren = list;
    }

}
