package com.sunesoft.ecloud.admin.domain.menu;

import com.sunesoft.ecloud.hibernate.IEntity;

import javax.persistence.*;


/**
 * @Author: niww
 * @Date: 2018/3/25
 * 菜单权限
 */
@Entity
@Table(name = "sys_menu_func", schema = "ecloud", catalog = "")
public class MenuFunction extends IEntity{
    /**
     * 权限名称
     */
    private String name;
    /**
     * 资源编码
     */
    private String resCode;
    /**
     *资源类型
     */
    private String resType;
    /**
     *资源名称
     */
    private String resName;
    /**
     *资源地址
     */
    private String resUrl;
    /**
     *资源请求类型
     */
    private String resRequestType;
    /**
     *描述
     */
    private String description;

    /**
     * 所属菜单
     */
    @ManyToOne
    @JoinColumn(name="menuId")
    private Menu menu;

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
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
    @Column(name = "resCode")
    public String getResCode() {
        return resCode;
    }

    public void setResCode(String resCode) {
        this.resCode = resCode;
    }

    @Basic
    @Column(name = "resType")
    public String getResType() {
        return resType;
    }

    public void setResType(String resType) {
        this.resType = resType;
    }

    @Basic
    @Column(name = "resName")
    public String getResName() {
        return resName;
    }

    public void setResName(String resName) {
        this.resName = resName;
    }

    @Basic
    @Column(name = "resUrl")
    public String getResUrl() {
        return resUrl;
    }

    public void setResUrl(String resUrl) {
        this.resUrl = resUrl;
    }

    @Basic
    @Column(name = "resRequestType")
    public String getResRequestType() {
        return resRequestType;
    }

    public void setResRequestType(String resRequestType) {
        this.resRequestType = resRequestType;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }




}
