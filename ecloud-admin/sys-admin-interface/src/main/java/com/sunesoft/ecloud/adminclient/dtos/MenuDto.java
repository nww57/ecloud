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

    private MenuDto parentMenu;

    private List<MenuDto> childMenuList = new ArrayList<>();


    private List<MenuFunctionDto> menuFunctions;





}
