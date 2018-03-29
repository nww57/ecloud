package com.sunesoft.ecloud.adminclient.dtos;

import com.sunesoft.ecloud.adminclient.ResourcesRequestType;
import com.sunesoft.ecloud.adminclient.ResourcesType;

import java.util.UUID;

/**
 * @author: jiangzhenjing
 * @date: 2018/3/26 下午6:53
 * -菜单功能编辑显示
 */
public class MenuFunctionDto {

    private UUID id;

    /**
     * 所属菜单id
     */
    private UUID menuId;

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
    private ResourcesType resType;

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
    private ResourcesRequestType resRequestType;

    /**
     *描述
     */
    private String description;


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

    public String getResCode() {
        return resCode;
    }

    public void setResCode(String resCode) {
        this.resCode = resCode;
    }

    public ResourcesType getResType() {
        return resType;
    }

    public void setResType(ResourcesType resType) {
        this.resType = resType;
    }

    public String getResName() {
        return resName;
    }

    public void setResName(String resName) {
        this.resName = resName;
    }

    public String getResUrl() {
        return resUrl;
    }

    public void setResUrl(String resUrl) {
        this.resUrl = resUrl;
    }

    public ResourcesRequestType getResRequestType() {
        return resRequestType;
    }

    public void setResRequestType(ResourcesRequestType resRequestType) {
        this.resRequestType = resRequestType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UUID getMenuId() {
        return menuId;
    }

    public void setMenuId(UUID menuId) {
        this.menuId = menuId;
    }
}
