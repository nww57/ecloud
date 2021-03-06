package com.sunesoft.ecloud.adminclient.dtos;

import com.sunesoft.ecloud.adminclient.MenuType;
import com.sunesoft.ecloud.common.TreeEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Zhouzh
 * @Date: 2018/3/26
 */
public class MenuDto  extends TreeEntity {


    private ModuleDto moduleDto;

    /**
     * 索引
     */
    private String menuIndex;

    /**
     * 路径编码
     */
    private String routeCode;

    /**
     *菜单名称
     */
    private String name;

    /**
     *路径资源
     */
    private String url;

    /**
     *菜单类型
     */
    private MenuType type =MenuType.LINK;


    /**
     *排序
     */
    private Integer sort;

    /**
     *描述
     */
    private String description;

    /**
     *前段组件
     */
    private String frontDisc;

    /**
     *图标
     */
    private String icon;

    /**
     *子节点数
     */
    private Integer childCount;

    /**
     * 父级节点
     */
    private MenuSimpleDto parentSimpleMenu;


    /**
     * 子级节点菜单
     */
    private List<MenuDto> children= new ArrayList<>();

    /**
     * 菜单功能
     */
    private List<MenuFunctionDto> menuFunctions = new ArrayList<>();

    public ModuleDto getModuleDto() {
        return moduleDto;
    }

    public void setModuleDto(ModuleDto moduleDto) {
        this.moduleDto = moduleDto;
    }

    public String getMenuIndex() {
        return menuIndex;
    }

    public void setMenuIndex(String menuIndex) {
        this.menuIndex = menuIndex;
    }

    public String getRouteCode() {
        return routeCode;
    }

    public void setRouteCode(String routeCode) {
        this.routeCode = routeCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public MenuType getType() {
        return type;
    }

    public void setType(MenuType type) {
        this.type = type;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFrontDisc() {
        return frontDisc;
    }

    public void setFrontDisc(String frontDisc) {
        this.frontDisc = frontDisc;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getChildCount() {
        return childCount;
    }

    public void setChildCount(Integer childCount) {
        this.childCount = childCount;
    }

    public MenuSimpleDto getParentSimpleMenu() {
        return parentSimpleMenu;
    }

    public void setParentSimpleMenu(MenuSimpleDto parentSimpleMenu) {
        this.parentSimpleMenu = parentSimpleMenu;
    }

    public List<MenuDto> getChildren() {
        return children;
    }

    public void setChildren(List list) {
        this.children = list;
    }

    public List<MenuFunctionDto> getMenuFunctions() {
        return menuFunctions;
    }

    public void setMenuFunctions(List<MenuFunctionDto> menuFunctions) {
        this.menuFunctions = menuFunctions;
    }
}
