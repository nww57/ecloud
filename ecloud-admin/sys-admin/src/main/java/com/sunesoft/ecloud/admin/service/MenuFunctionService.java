package com.sunesoft.ecloud.admin.service;

import com.sunesoft.ecloud.adminclient.dtos.MenuFunctionDto;
import com.sunesoft.ecloud.common.result.TResult;

import java.util.List;
import java.util.UUID;

/**
 * @author: jiangzhenjing
 * @date: 2018/3/26 下午7:08
 * -
 */
public interface MenuFunctionService {

    /**
     * 新增修改菜单功能
     */
    TResult addOrUpdateFunction(MenuFunctionDto menuFunctionDto);

    /**
     * 删除菜单功能
     */
    TResult delete(List ids);

    /**
     * 查询菜单功能
     */
    TResult queryMenuFunction(UUID uuid);
}
