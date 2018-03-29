package com.sunesoft.ecloud.admin.domain.menu;

import com.sunesoft.ecloud.admin.domain.ResourcesRequestType;
import com.sunesoft.ecloud.admin.domain.ResourcesType;
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
    @Column(name = "name")
    private String name;

    /**
     * 资源编码
     */
    @Column(name = "resCode")
    private String resCode;

    /**
     *资源类型
     */
    @Column(name = "resType")
    @Enumerated(EnumType.STRING)
    private ResourcesType resType;

    /**
     *资源名称
     */
    @Column(name = "resName")
    private String resName;

    /**
     *资源地址
     */
    @Column(name = "resUrl")
    private String resUrl;

    /**
     *资源请求类型
     */
    @Column(name = "resRequestType")
    @Enumerated(EnumType.STRING)
    private ResourcesRequestType resRequestType;

    /**
     *描述
     */
    @Column(name = "description")
    private String description;

    /**
     * 所属菜单
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="menuId")
    private Menu menu;

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    @Basic
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    public String getResCode() {
        return resCode;
    }

    public void setResCode(String resCode) {
        this.resCode = resCode;
    }

    @Basic
    public ResourcesType getResType() {
        return resType;
    }

    public void setResType(ResourcesType resType) {
        this.resType = resType;
    }

    @Basic
    public String getResName() {
        return resName;
    }

    public void setResName(String resName) {
        this.resName = resName;
    }

    @Basic
    public String getResUrl() {
        return resUrl;
    }

    public void setResUrl(String resUrl) {
        this.resUrl = resUrl;
    }

    @Basic
    public ResourcesRequestType getResRequestType() {
        return resRequestType;
    }

    public void setResRequestType(ResourcesRequestType resRequestType) {
        this.resRequestType = resRequestType;
    }

    @Basic
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }




}
