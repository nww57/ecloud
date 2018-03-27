package com.sunesoft.ecloud.admin.query.impl;

import com.sunesoft.ecloud.admin.domain.menu.MenuFunction;
import com.sunesoft.ecloud.admin.query.MenuFunctionQueryService;
import com.sunesoft.ecloud.admin.repository.MenuFunctionRepository;
import com.sunesoft.ecloud.adminclient.dtos.MenuFunctionDto;
import com.sunesoft.ecloud.common.result.ListResult;
import com.sunesoft.ecloud.common.result.TResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @author: jiangzhenjing
 * @date: 2018/3/26 下午8:13
 * -
 */
@Service
public class MenuFunctionQueryServiceImpl implements MenuFunctionQueryService {

    @Autowired
    MenuFunctionRepository menuFunctionRepository;


    @Override
    public ListResult<MenuFunctionDto> queryMenuFunction(UUID uuid) {
        ListResult<MenuFunctionDto> menuFunctionDtoListResult = menuFunctionRepository.findMenuFunctionsByMenuId(uuid);
        return menuFunctionDtoListResult;
    }
}
