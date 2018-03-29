package com.sunesoft.ecloud.admin.query.impl;

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
import com.sunesoft.ecloud.common.result.ListResult;
import com.sunesoft.ecloud.common.result.TResult;
import com.sunesoft.ecloud.common.sqlBuilderTool.SqlBuilder;
import com.sunesoft.ecloud.auth.UserContext;
import com.sunesoft.ecloud.hibernate.sqlBuilder.HSqlBuilder;
import com.sunesoft.ecloud.hibernate.sqlExcute.GenericQuery;
import org.springframework.beans.factory.annotation.Autowired;
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


    @Override
    public ListResult<MenuDto> findAllMenu() {//要有功能的
        //取出所有菜单
        SqlBuilder sqlBuilder = HSqlBuilder.hFrom(Menu.class, "m")
                .select(MenuDto.class);
        List<MenuDto> menulist = this.queryList(sqlBuilder);
        List<MenuFunctionDto> functionlist=new ArrayList<>();
        SqlBuilder sqlBuilder1=null;
        for (MenuDto menuDto : menulist) {
            //取出所有菜单功能
            sqlBuilder1 = HSqlBuilder.hFrom(MenuFunction.class, "f")
                    .where("f.menuId", menuDto.getId())
                    .select(MenuFunctionDto.class);
            functionlist = this.queryList(sqlBuilder1);
            menuDto.setMenuFunctions(functionlist);
        }
        return new ListResult(menulist);
    }

    @Override
    public ListResult<MenuSimpleDto> findAllSimpleMenu() {//没有功能的
        SqlBuilder sqlBuilder = HSqlBuilder.hFrom(Menu.class, "m")
                .select(MenuSimpleDto.class);
        List<MenuSimpleDto> list = this.queryList(sqlBuilder);
        //这里要处理好父子级
        List<MenuSimpleDto> listResult = this.transformationTree(list);
        return new ListResult(listResult);
    }

    @Override
    public ListResult<MenuDto> findAgAllMenu() {//这里要获取有功能的
        //查出企业菜单权限表
        SqlBuilder sqlBuilder = HSqlBuilder.hFrom(AgencyAuthorizedMenu.class, "a")
                .where("a.agencyId", UserContext.getAgencyId())
                .select(AgencyAuthorizedMenuDto.class);
        List<AgencyAuthorizedMenuDto> list = this.queryList(sqlBuilder);
        String menuIds="";
        for (AgencyAuthorizedMenuDto agencyAuthorizedMenuDto : list) {
            menuIds+=agencyAuthorizedMenuDto.getMenuId()+",";
        }
        //取出所有菜单
        SqlBuilder sqlBuilder1 = HSqlBuilder.hFrom(Menu.class, "m")
                .where("m.id", "%"+menuIds+"%")
                .select(MenuDto.class);
        List<MenuDto> menulist = this.queryList(sqlBuilder1);
        List<MenuFunctionDto> functionlist=new ArrayList<>();
        SqlBuilder sqlBuilder2=null;
        for (MenuDto menuDto : menulist) {
            //取出所有菜单功能
            sqlBuilder2 = HSqlBuilder.hFrom(MenuFunction.class, "f")
                    .where("f.menuId", menuDto.getId())
                    .select(MenuFunctionDto.class);
            functionlist = this.queryList(sqlBuilder2);
            menuDto.setMenuFunctions(functionlist);
        }
        return new ListResult(menulist);
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
        List<MenuFunctionDto> list = this.queryList(sqlBuilder);
        menuDto.setMenuFunctions(list);
        return new TResult<>(menuDto);
    }

    @Override
    public TResult<MenuFunctionDto> findMenuFunctionsByID(UUID uuid) {
        SqlBuilder sqlBuilder = HSqlBuilder.hFrom(MenuFunction.class, "f")
                .where("f.menuId",uuid)
                .select(MenuFunctionDto.class);
        List<MenuFunctionDto> list = this.queryList(sqlBuilder);
        return new ListResult(list);
    }


    /**
     * 将list转成树形结构
     * 使用递归方法建树
     */
    public static List<MenuSimpleDto> transformationTree(List<MenuSimpleDto> list) {
        List<MenuSimpleDto> trees = new ArrayList<MenuSimpleDto>();
        for (MenuSimpleDto treeNode : list) {//找到根节点
            if (treeNode.getParentMenu()==null) {
                trees.add(findChildren(treeNode,list));
            }
        }
        return trees;
    }
    /**
     * 递归查找子节点
     */
    public static MenuSimpleDto findChildren(MenuSimpleDto treeNode,List<MenuSimpleDto> list) {
        for (MenuSimpleDto it : list) {
            if(treeNode.getId().equals(it.getParentMenu().getId())) {//查到的节点是当前节点treeNode的子节点
//                if (treeNode.getChiledrenMenu() == null) {
//                    treeNode.setChiledrenMenu(new ArrayList<MenuSimpleDto>());
//                }
                treeNode.getChiledrenMenu().add(findChildren(it,list));
            }
        }
        return treeNode;
    }






}
