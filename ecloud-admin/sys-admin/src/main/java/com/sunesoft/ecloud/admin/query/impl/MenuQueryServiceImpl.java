package com.sunesoft.ecloud.admin.query.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sunesoft.ecloud.admin.domain.agency.AgencyAuthorizedMenu;
import com.sunesoft.ecloud.admin.domain.menu.Menu;
import com.sunesoft.ecloud.admin.domain.menu.MenuFunction;
import com.sunesoft.ecloud.admin.query.MenuQueryService;
import com.sunesoft.ecloud.admin.repository.MenuFunctionRepository;
import com.sunesoft.ecloud.admin.repository.MenuRepository;
import com.sunesoft.ecloud.adminclient.dtos.AgencyAuthorizedMenuDto;
import com.sunesoft.ecloud.adminclient.dtos.MenuDto;
import com.sunesoft.ecloud.adminclient.dtos.MenuFunctionDto;
import com.sunesoft.ecloud.adminclient.dtos.MenuSimpleDto;
import com.sunesoft.ecloud.common.TreeEntity;
import com.sunesoft.ecloud.common.TreeUtils;
import com.sunesoft.ecloud.common.result.ListResult;
import com.sunesoft.ecloud.common.result.TResult;
import com.sunesoft.ecloud.common.sqlBuilderTool.SqlBuilder;
import com.sunesoft.ecloud.auth.UserContext;
import com.sunesoft.ecloud.hibernate.sqlBuilder.HSqlBuilder;
import com.sunesoft.ecloud.hibernate.sqlExcute.GenericQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author: jiangzhenjing
 * @date: 2018/3/26 下午8:14
 * -
 */
@Service
@SuppressWarnings("All")
public class MenuQueryServiceImpl extends GenericQuery implements MenuQueryService {

    @Autowired
    MenuRepository menuRepository;

    @Value("${ecloud.agId}")
    private UUID agId;

    @Override
    public ListResult<MenuDto> findAllMenu() {//要有功能的
        //取出所有菜单
        SqlBuilder sqlBuilder = HSqlBuilder.hFrom(Menu.class, "m")
                .select(MenuDto.class);
        List<MenuDto> menulist = this.queryList(sqlBuilder);
        List<MenuFunctionDto> functionlist = new ArrayList<>();
        SqlBuilder sqlBuilder1 = null;
        for (MenuDto menuDto : menulist) {
            //取出所有菜单功能
            sqlBuilder1 = HSqlBuilder.hFrom(MenuFunction.class, "f")
                    .where("f.menuId", menuDto.getId())
                    .select(MenuFunctionDto.class);
            functionlist = this.queryList(sqlBuilder1);
            menuDto.setMenuFunctions(functionlist);
        }
        List<MenuDto> listResult = TreeUtils.transformationTree(menulist);
        return new ListResult(listResult);
    }

    @Override
    public ListResult<MenuSimpleDto> findAllSimpleMenu() {//没有功能的
        SqlBuilder sqlBuilder = HSqlBuilder.hFrom(Menu.class, "m")
                .select(MenuSimpleDto.class);
        List<MenuSimpleDto> list = this.queryList(sqlBuilder);
        List<MenuSimpleDto> listResult = TreeUtils.transformationTree(list);
        return new ListResult(listResult);
    }

    @Override
    public ListResult<MenuDto> findAgAllMenu() {//这里要获取有功能的
        //查出企业菜单权限表
        SqlBuilder sqlBuilder = HSqlBuilder.hFrom(AgencyAuthorizedMenu.class, "a")
                .where("a.agId", agId)
//                .where("a.agId", UUID.fromString("d2d512f3-0a6c-4373-9ab2-a348fb616d7a"))
                .select(AgencyAuthorizedMenuDto.class)
                .setFieldValue("agencyId","a.agId")
                .setFieldValue("menuId","a.menuId");
        List<AgencyAuthorizedMenuDto> list = this.queryList(sqlBuilder);
        List<String> menuIds = new ArrayList<>();
        for (AgencyAuthorizedMenuDto agencyAuthorizedMenuDto : list) {
            menuIds.add(agencyAuthorizedMenuDto.getMenuId().toString());
        }
        //取出所有菜单
        SqlBuilder sqlBuilder1 = HSqlBuilder.hFrom(Menu.class, "m")
                .where("m.id",menuIds)
                .select(MenuDto.class);
        List<MenuDto> menulist = this.queryList(sqlBuilder1);
        List<MenuFunctionDto> functionlist = new ArrayList<>();
        SqlBuilder sqlBuilder2 = null;
        for (MenuDto menuDto : menulist) {
            //取出所有菜单功能
            sqlBuilder2 = HSqlBuilder.hFrom(MenuFunction.class, "f")
                    .where("f.menuId", menuDto.getId())
                    .select(MenuFunctionDto.class);
            functionlist = this.queryList(sqlBuilder2);
            menuDto.setMenuFunctions(functionlist);
        }
        List<MenuDto> listResult = TreeUtils.transformationTree(menulist);
        return new ListResult(listResult);
    }

    @Override
    public TResult<MenuDto> findMenuByID(UUID uuid) {//有功能的
        //查询Menu
        SqlBuilder sqlBuilder = HSqlBuilder.hFrom(Menu.class, "m")
                .where("m.id", uuid)
                .select(MenuDto.class);
        MenuDto menuDto = (MenuDto) this.queryForObject(sqlBuilder);
        //查询menuFunction
        SqlBuilder sqlBuilder1 = HSqlBuilder.hFrom(MenuFunction.class, "f")
                .where("f.menuId", uuid)
                .select(MenuFunctionDto.class);
        List<MenuFunctionDto> list = this.queryList(sqlBuilder1);
        menuDto.setMenuFunctions(list);
        return new TResult<>(menuDto);
    }

    @Override
    public TResult<MenuFunctionDto> findMenuFunctionsByID(UUID uuid) {
        SqlBuilder sqlBuilder = HSqlBuilder.hFrom(MenuFunction.class, "f")
                .where("f.menuId", uuid)
                .select(MenuFunctionDto.class);
        List<MenuFunctionDto> list = this.queryList(sqlBuilder);
        return new ListResult(list);
    }

}
