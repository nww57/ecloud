package com.sunesoft.ecloud.adminclient.dtos;

import com.sunesoft.ecloud.adminclient.MenuType;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @Auther: niww
 * @Date: 2018/4/9/009
 */
public class UserMenuDto{


    private UUID id;

    /**
     * 父级id
     */
    private UUID pid;

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
    private MenuType type = MenuType.LINK;

    /**
     * 菜单功能
     */
    private List<MenuFunctionDto> menuFunctions = new ArrayList<>();

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

    public List<MenuFunctionDto> getMenuFunctions() {
        return menuFunctions;
    }

    public void setMenuFunctions(List<MenuFunctionDto> menuFunctions) {
        this.menuFunctions = menuFunctions;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getPid() {
        return pid;
    }

    public void setPid(UUID pid) {
        this.pid = pid;
    }
}
