package com.sunesoft.ecloud.adminclient.dtos;

import com.sunesoft.ecloud.adminclient.MenuType;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author: Zhouzh
 * @Date: 2018/3/26
 */
public class MenuDto {

    private UUID uuid;

    private ModuleDto module;

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
    private MenuType type;


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
     * 父级节点菜单
     */
    private MenuDto parentMenu;


    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public ModuleDto getModule() {
        return module;
    }

    public void setModule(ModuleDto module) {
        this.module = module;
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

    public MenuDto getParentMenu() {
        return parentMenu;
    }

    public void setParentMenu(MenuDto parentMenu) {
        this.parentMenu = parentMenu;
    }

}
