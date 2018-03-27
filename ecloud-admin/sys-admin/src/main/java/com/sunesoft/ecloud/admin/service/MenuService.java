package com.sunesoft.ecloud.admin.service;

import com.sunesoft.ecloud.adminclient.dtos.MenuDto;
import com.sunesoft.ecloud.common.result.TResult;

import java.util.UUID;

/**
 * @author: jiangzhenjing
 * @date: 2018/3/26 下午7:35
 * -
 */
public interface MenuService {
    /**
     * 新增修改菜单
     */
    TResult addOrUpdateMenu(MenuDto menuDto);

    /**
     * 删除菜单
     */
    TResult delete(UUID uuid);
}
