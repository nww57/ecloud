package com.sunesoft.ecloud.admin.query.impl;

import com.sunesoft.ecloud.admin.domain.menu.Menu;
import com.sunesoft.ecloud.admin.query.MenuQueryService;
import com.sunesoft.ecloud.admin.repository.MenuFunctionRepository;
import com.sunesoft.ecloud.admin.repository.MenuRepository;
import com.sunesoft.ecloud.adminclient.dtos.MenuDto;
import com.sunesoft.ecloud.adminclient.dtos.MenuSimpleDto;
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
 * @date: 2018/3/26 下午8:14
 * -
 */
@Service
public class MenuQueryServiceImpl extends GenericQuery implements MenuQueryService {

    @Autowired
    MenuRepository menuRepository;


    @Override
    public ListResult<MenuDto> findAllMenu() {
        SqlBuilder sqlBuilder = HSqlBuilder.hFrom(Menu.class, "m")
                .select(MenuDto.class);
        List<MenuDto> list = this.queryList(sqlBuilder);
        return new ListResult(list);
    }

    @Override
    public ListResult<MenuSimpleDto> findAllSimpleMenu() {
        SqlBuilder sqlBuilder = HSqlBuilder.hFrom(Menu.class, "m")
                .select(MenuSimpleDto.class);
        List<MenuSimpleDto> list = this.queryList(sqlBuilder);
        return new ListResult(list);
    }

    @Override
    public TResult<MenuDto> findMenuByID(UUID uuid) {
        SqlBuilder sqlBuilder = HSqlBuilder.hFrom(Menu.class, "m")
                .where("id", uuid)
                .select(MenuDto.class);
        MenuDto menuDto = (MenuDto) this.queryForObject(sqlBuilder);
        return new TResult<>(menuDto);
    }
}
