package com.sunesoft.ecloud.admin.domain.menu;

import com.sunesoft.ecloud.admin.domain.MenuType;
import com.sunesoft.ecloud.hibernate.IEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: niww
 * @Date: 2018/3/25
 * 菜单
 */
@Entity
@Table(name = "sys_menu", schema = "ecloud", catalog = "")
public class Menu extends IEntity{

    @ManyToOne
    @JoinColumn(name = "moduleId")
    private Module module;

    /**
     * 索引
     */
    @Column(name = "menuIndex")
    private String menuIndex;

    /**
     * 路径编码
     */
    @Column(name = "routeCode")
    private String routeCode;

    /**
     *菜单名称
     */
    @Column(name = "name")
    private String name;

    /**
     *路径资源
     */
    @Column(name = "url")
    private String url;

    /**
     *菜单类型
     */
    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private MenuType type;


    /**
     *排序
     */
    @Column(name = "sort")
    private Integer sort;

    /**
     *描述
     */
    @Column(name = "description")
    private String description;

    /**
     *前段组件
     */
    @Column(name = "frontDisc")
    private String frontDisc;

    /**
     *图标
     */
    @Column(name = "icon")
    private String icon;

    /**
     *子节点数
     */
    @Column(name = "childCount")
    private Integer childCount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pid")
    private Menu parentMenu;

    @OneToMany(targetEntity = Menu.class, cascade = { CascadeType.ALL }, mappedBy = "parentMenu")
    private List<Menu> childMenuList = new ArrayList<>();


    @OneToMany(mappedBy = "menu")
    private List<MenuFunction> menuFunctions = new ArrayList<>();


    @Basic
    public String getMenuIndex() {
        return menuIndex;
    }

    public void setMenuIndex(String menuIndex) {
        this.menuIndex = menuIndex;
    }

    @Basic
    public String getRouteCode() {
        return routeCode;
    }

    public void setRouteCode(String routeCode) {
        this.routeCode = routeCode;
    }

    @Basic
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Basic
    public MenuType getType() {
        return type;
    }

    public void setType(MenuType type) {
        this.type = type;
    }

    @Basic
    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @Basic
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    public String getFrontDisc() {
        return frontDisc;
    }

    public void setFrontDisc(String frontDisc) {
        this.frontDisc = frontDisc;
    }

    @Basic
    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Basic
    public Integer getChildCount() {
        return childCount;
    }

    public void setChildCount(Integer childCount) {
        this.childCount = childCount;
    }

    public Menu getParentMenu() {
        return parentMenu;
    }

    public void setParentMenu(Menu parentMenu) {
        this.parentMenu = parentMenu;
    }

    public List<Menu> getChildMenuList() {
        return childMenuList;
    }

    public void setChildMenuList(List<Menu> childMenuList) {
        this.childMenuList = childMenuList;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public List<MenuFunction> getMenuFunctions() {
        return menuFunctions;
    }

    public void setMenuFunctions(List<MenuFunction> menuFunctions) {
        this.menuFunctions = menuFunctions;
    }
}
