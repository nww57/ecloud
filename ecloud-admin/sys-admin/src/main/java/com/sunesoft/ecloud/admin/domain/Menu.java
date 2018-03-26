package com.sunesoft.ecloud.admin.domain;

import com.sunesoft.ecloud.hibernate.IEntity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @Author: niww
 * @Date: 2018/3/25
 * 菜单
 */
@Entity
@Table(name = "sys_menu", schema = "ecloud", catalog = "")
public class Menu extends IEntity{
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
    private String type;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pid")
    private Menu parentMenu;

    @OneToMany(targetEntity = Menu.class, cascade = { CascadeType.ALL }, mappedBy = "parentMenu")
    private List<Menu> childMenuList = new ArrayList<>();

    @OneToMany(mappedBy = "menu",cascade = CascadeType.ALL)
    private List<CompanyMenuRelEntity> companyMenuList = new ArrayList<>();

    @Basic
    @Column(name = "menuIndex")
    public String getMenuIndex() {
        return menuIndex;
    }

    public void setMenuIndex(String menuIndex) {
        this.menuIndex = menuIndex;
    }

    @Basic
    @Column(name = "routeCode")
    public String getRouteCode() {
        return routeCode;
    }

    public void setRouteCode(String routeCode) {
        this.routeCode = routeCode;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "sort")
    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "frontDisc")
    public String getFrontDisc() {
        return frontDisc;
    }

    public void setFrontDisc(String frontDisc) {
        this.frontDisc = frontDisc;
    }

    @Basic
    @Column(name = "icon")
    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Basic
    @Column(name = "childCount")
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

    public List<CompanyMenuRelEntity> getCompanyMenuList() {
        return companyMenuList;
    }

    public void setCompanyMenuList(List<CompanyMenuRelEntity> companyMenuList) {
        this.companyMenuList = companyMenuList;
    }
}
