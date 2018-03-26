package com.sunesoft.ecloud.admin.query;

import com.sunesoft.ecloud.common.result.TResult;

import java.util.UUID;

/**
 * @author: jiangzhenjing
 * @date: 2018/3/26 下午8:11
 * -
 */
public interface MenuFunctionQueryService {

    /**
     * 查询菜单功能
     */
    TResult queryMenuFunction(UUID uuid);
}
