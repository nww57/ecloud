package com.sunesoft.ecloud.admin.query;

import com.sunesoft.ecloud.adminclient.dtos.MenuDto;
import com.sunesoft.ecloud.adminclient.dtos.MenuFunctionDto;
import com.sunesoft.ecloud.adminclient.dtos.MenuSimpleDto;
import com.sunesoft.ecloud.common.result.ListResult;
import com.sunesoft.ecloud.common.result.TResult;

import java.util.UUID;

/**
 * @author: jiangzhenjing
 * @date: 2018/3/26 下午8:10
 * -
 */
public interface MenuQueryService {

    /**
     * 查询菜单（所有）
     */
    ListResult<MenuDto> findAllMenu();

    /**
     * 查询简易菜单（含ID 名称）
     */
    ListResult<MenuSimpleDto> findAllSimpleMenu();


    /**
     * 查询企业下所有菜单
     */
    ListResult<MenuSimpleDto> findAgAllSimpleMenu();

    /**
     * 根据菜单ID查询菜单详情
     */
    TResult<MenuDto> findMenuByID(UUID uuid);


    /**
     * 根据菜单ID查询菜单功能详情
     */
    TResult<MenuFunctionDto> findMenuFunctionsByID(UUID uuid);

}
