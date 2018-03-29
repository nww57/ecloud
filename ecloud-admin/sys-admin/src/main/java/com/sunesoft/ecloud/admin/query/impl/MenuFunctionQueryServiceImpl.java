package com.sunesoft.ecloud.admin.query.impl;

import com.sunesoft.ecloud.admin.domain.menu.Menu;
import com.sunesoft.ecloud.admin.domain.menu.MenuFunction;
import com.sunesoft.ecloud.admin.query.MenuFunctionQueryService;
import com.sunesoft.ecloud.admin.repository.MenuFunctionRepository;
import com.sunesoft.ecloud.admin.repository.MenuRepository;
import com.sunesoft.ecloud.adminclient.dtos.MenuFunctionDto;
import com.sunesoft.ecloud.common.result.ListResult;
import com.sunesoft.ecloud.common.result.TResult;
import com.sunesoft.ecloud.common.sqlBuilderTool.SqlBuilder;
import com.sunesoft.ecloud.hibernate.sqlBuilder.HSqlBuilder;
import com.sunesoft.ecloud.hibernate.sqlExcute.GenericQuery;
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
@SuppressWarnings("All")
public class MenuFunctionQueryServiceImpl extends GenericQuery implements MenuFunctionQueryService {

    @Autowired
    MenuFunctionRepository menuFunctionRepository;

    @Autowired
    MenuRepository menuRepository;


    @Override
    public ListResult<MenuFunctionDto> queryMenuFunction(UUID uuid) {
        SqlBuilder sqlBuilder = HSqlBuilder.hFrom(MenuFunction.class, "f")
                .where("f.menuId",uuid)
                .select(MenuFunctionDto.class);
        List<MenuFunctionDto> list = this.queryList(sqlBuilder);
        return new ListResult(list);
    }
}
