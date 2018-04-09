package com.sunesoft.ecloud.admin.query.impl;

import com.sunesoft.ecloud.admin.domain.agency.AgencyOrganization;
import com.sunesoft.ecloud.admin.domain.agency.User;
import com.sunesoft.ecloud.admin.query.UserQueryService;
import com.sunesoft.ecloud.admin.repository.UserRepository;
import com.sunesoft.ecloud.adminclient.UserPositionType;
import com.sunesoft.ecloud.adminclient.UserType;
import com.sunesoft.ecloud.adminclient.cretirias.UserCriteria;
import com.sunesoft.ecloud.adminclient.dtos.*;
import com.sunesoft.ecloud.common.result.ListResult;
import com.sunesoft.ecloud.common.result.TResult;
import com.sunesoft.ecloud.common.sqlBuilderTool.SqlBuilder;
import com.sunesoft.ecloud.common.utils.BeanUtil;
import com.sunesoft.ecloud.hibernate.sqlBuilder.HSqlBuilder;
import com.sunesoft.ecloud.hibernate.sqlExcute.GenericQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: Zhouzh
 * @Date: 2018/3/23
 */
@Service
@SuppressWarnings("All")
public class UserQueryServiceImpl extends GenericQuery implements UserQueryService {



    @Autowired
    UserRepository userRepository;

    @Override
    public Page<UserDto> findUserPaged(UserCriteria cretiria) {
        UUID agId = cretiria.getAgId();
        if(null == agId){
            throw new IllegalArgumentException("企业id不能为null");
        }
        PageRequest pageable = new PageRequest(cretiria.getPageIndex(),cretiria.getPageSize(),null);
        StringBuilder sb = new StringBuilder("");
        sb.append("select u.id,u.userName,u.realName,u.callphone,u.email,u.isWorkon,u.create_datetime createDate,org.name organizationName ," +
                " (select GROUP_CONCAT(r.name) from sys_ag_user_role ur LEFT JOIN sys_ag_role r on r.id = ur.roleId where ur.userId = u.id) roleName " +
                " from sys_user u " +
                " LEFT JOIN sys_ag_organization org on org.id = u.structureId " +
                " where u.agId = '").append(agId).append("' limit ").append(cretiria.getPageIndex()*cretiria.getPageSize()).append(",").append(cretiria.getPageSize());
        List<UserDto> dtoList = queryList(sb.toString(),null,UserDto.class);
        String queryCount = "select count(*) from sys_user u where u.agId = '"+agId+"'";
        int count = queryCount(queryCount,null);
        Page page= new PageImpl(dtoList,pageable,count);
        return page;

    }

    @Override
    public UserDto findUserByUserName(String userName) {
        StringBuilder sql = new StringBuilder("select * form sys_user u where u.username = :username");
        Map param  = new HashMap();
        param.put("username",userName);
        return queryForObject(sql.toString(),param,UserDto.class);
    }


    @Override
    public TResult<UserBasicDto> getUserBasicInfoById(UUID id) {
        SqlBuilder<UserBasicDto> builder = HSqlBuilder.hFrom(User.class,"user")
                .where("id",id)
                .select(UserBasicDto.class);
        UserBasicDto user =  queryForObject(builder);
        return new TResult<>(user);
    }


    @Override
    public TResult<UserDto> findUserFullById(UUID id) {
        SqlBuilder<UserDto> builder = HSqlBuilder.hFrom(User.class, "user")
                .leftJoin(AgencyOrganization.class,"org")
                .on("user.structureId = org.id")
                .where("id",id)
                .setFieldValue("organizationId","org.id")
                .setFieldValue("organizationName","org.name")
                .select(UserDto.class);
        UserDto userInfo = queryForObject(builder);
        String sql = "select r.id id,r.name name from sys_user u left join sys_ag_user_role ur on u.id = ur.userId left join sys_ag_role r on ur.roleId = r.id where u.id = :id";
        Map params = new HashMap();
        params.put("id",id.toString());
        List<BasicDto> roleList = super.queryList(sql,params,BasicDto.class);
        if(null != roleList && roleList.size()>0){
            List<UUID> roleId = new ArrayList<>();
            List<String> roleName = new ArrayList<>();
            roleList.forEach(role->{
                roleId.add(role.getId());
                roleName.add(role.getName());
            });
            userInfo.setRoleIdList(roleId);
            userInfo.setRoleNameList(roleName);
        }
        return new TResult<>(userInfo);
    }


    @Override
    public ListResult<BasicDto> getUserIdName() {
        //获取所有负责人
        SqlBuilder<BasicDto> userBuilder = HSqlBuilder.hFrom(User.class,"u")
                .setFieldValue("name","u.realName")
                .select(BasicDto.class);
        List<BasicDto> userList = queryList(userBuilder);
        return new ListResult<>(userList);
    }

    @Override
    public ListResult<UserPositionDto> getPositionList() {
        UserPositionType[] positionTypes = UserPositionType.values();
        List<UserPositionDto> positionDtos = new ArrayList<>();
        UserPositionDto positionDto ;
        for (UserPositionType position : positionTypes) {
            positionDto = new UserPositionDto();
            positionDto.setCode(position.getCode());
            positionDto.setName(position.getName());
            positionDtos.add(positionDto);
        }
        return new ListResult<>(positionDtos);
    }

    @Override
    public TResult<UserMenuAuthDto> getUserAuthMenuList(UUID id) {
        UserMenuAuthDto authDto = new UserMenuAuthDto();
        //获取基本信息
        TResult<UserBasicDto> result = getUserBasicInfoById(id);
        UserBasicDto basicDto = result.getResult();
        UserType userType = basicDto.getUserType();
        List<MenuDto> menuDtoList = null;
        List<MenuFunctionDto> functionDtoList = null;
        UUID agId = basicDto.getAgId();
        if(Objects.equals(UserType.SUPER_ADMIN,userType)){
            //如果是超级用户,获取所有菜单及所有功能项
            //获取所有菜单
            String sql = "select m.id,m.menuIndex,m.routeCode,m.name,m.url,m.sort,m.description,m.frontDisc,m.icon,m.pid from sys_menu m ";
            menuDtoList = queryList(sql,null,MenuDto.class);
            //获取所有功能项
            String funcSql = "select f.id,f.name,f.menuId,f.resCode,f.resType,f.resName,f.resUrl,f.resRequestType,f.description from sys_menu_func f ";
            functionDtoList = queryList(funcSql,null,MenuFunctionDto.class);
        }else if(Objects.equals(UserType.AGENCY_ADMIN,userType)){
            //如果是企业管理员用户，找企业的菜单
            //获取菜单
            String sql = "select m.id,m.menuIndex,m.routeCode,m.name,m.url,m.sort,m.description,m.frontDisc,m.icon,m.pid from sys_ag_authmenu am left join sys_menu m on m.id = am.menuId  where am.agId = :agId";
            Map map = new HashMap();
            map.put("agId",agId.toString());
            menuDtoList = queryList(sql,map,MenuDto.class);
            //获取功能
            List<UUID> menuIdList = menuDtoList.stream().map(MenuDto::getId).collect(Collectors.toList());
            String funcSql = "select f.id,f.name,f.menuId,f.resCode,f.resType,f.resName,f.resUrl,f.resRequestType,f.description from sys_menu_func f where f.menuId in (:idList)";
            List<String> menuIdListString = menuIdList.stream().map(UUID::toString).collect(Collectors.toList());
            Map funMap = new HashMap();
            funMap.put("idList",menuIdListString);
            functionDtoList = queryList(funcSql,funMap,MenuFunctionDto.class);

        }else if(Objects.equals(UserType.AGENCY_USER,userType)){
            //如果是普通用户，根据用户的角色去找菜单及权限
            //1.找出用户拥有的所有菜单 （用户-->角色-->菜单）
            String sql = "select m.id,m.menuIndex,m.routeCode,m.name,m.url,m.sort,m.description,m.frontDisc,m.icon,m.pid from sys_user u " +
                    " INNER JOIN sys_ag_user_role ur on ur.userId = u.id " +
                    " INNER JOIN sys_ag_role_authmenu rm on rm.roleId = ur.roleId " +
                    " INNER JOIN sys_ag_authmenu am on am.id = rm.menuId " +
                    " INNER JOIN sys_menu m on am.menuId = m.id " +
                    " where u.id = :uid";
            Map map = new HashMap();
            map.put("uid",id.toString());
            menuDtoList = queryList(sql,map,MenuDto.class);
            //2.找出用户拥有的菜单的功能
            String funcSql = "select f.id,f.name,f.menuId,f.resCode,f.resType,f.resName,f.resUrl,f.resRequestType,f.description from sys_user u " +
                    " INNER JOIN sys_ag_user_role ur on ur.userId = u.id " +
                    " INNER JOIN sys_ag_role_authmenu rm on rm.roleId = ur.roleId " +
                    " INNER JOIN sys_ag_menu_authfunc rf on rm.id = rf.roleMenuId " +
                    " INNER JOIN sys_menu_func f on rf.funcId = f.id where u.id=:uid";
             functionDtoList = queryList(funcSql,map,MenuFunctionDto.class);
        }else{
            throw new IllegalArgumentException("无效的用户类型");
        }

        //3.装配
        //先将func匹配进menu
        List<MenuFunctionDto> finalFunctionDtoList = functionDtoList;
        menuDtoList.forEach(menu->{
            finalFunctionDtoList.forEach(func->{
                if(Objects.equals(func.getMenuId(),menu.getId())){
                    menu.getMenuFunctions().add(func);
                }
            });
        });
        //处理menu,转换成树形结构
        List<MenuDto> treeList = buildTree(menuDtoList);
        authDto.setMenuList(treeList);
        return new TResult<>(authDto);
    }

    @Override
    public ListResult<UserMenuDto> getUserMenuList(UUID id) {
        UserMenuDto authDto = new UserMenuDto();
        //获取基本信息
        TResult<UserBasicDto> result = getUserBasicInfoById(id);
        UserBasicDto basicDto = result.getResult();
        UserType userType = basicDto.getUserType();
        List<UserMenuDto> menuDtoList = null;
        List<MenuFunctionDto> functionDtoList = null;
        UUID agId = basicDto.getAgId();
        if(Objects.equals(UserType.SUPER_ADMIN,userType)){
            //如果是超级用户,获取所有菜单及所有功能项
            //获取所有菜单
            String sql = "select m.id,m.menuIndex,m.routeCode,m.name,m.url,m.sort,m.description,m.frontDisc,m.icon,m.pid from sys_menu m order by m.pid ,m.sort";
            menuDtoList = queryList(sql,null,UserMenuDto.class);
            //获取所有功能项
            String funcSql = "select f.id,f.name,f.menuId,f.resCode,f.resType,f.resName,f.resUrl,f.resRequestType,f.description from sys_menu_func f ";
            functionDtoList = queryList(funcSql,null,MenuFunctionDto.class);
        }else if(Objects.equals(UserType.AGENCY_ADMIN,userType)){
            //如果是企业管理员用户，找企业的菜单
            //获取菜单
            String sql = "select m.id,m.menuIndex,m.routeCode,m.name,m.url,m.sort,m.description,m.frontDisc,m.icon,m.pid from sys_ag_authmenu am left join sys_menu m on m.id = am.menuId  where am.agId = :agId order by m.pid ,m.sort";
            Map map = new HashMap();
            map.put("agId",agId.toString());
            menuDtoList = queryList(sql,map,UserMenuDto.class);
            //获取功能
            List<UUID> menuIdList = menuDtoList.stream().map(UserMenuDto::getId).collect(Collectors.toList());
            String funcSql = "select f.id,f.name,f.menuId,f.resCode,f.resType,f.resName,f.resUrl,f.resRequestType,f.description from sys_menu_func f where f.menuId in (:idList)";
            List<String> menuIdListString = menuIdList.stream().map(UUID::toString).collect(Collectors.toList());
            Map funMap = new HashMap();
            funMap.put("idList",menuIdListString);
            functionDtoList = queryList(funcSql,funMap,MenuFunctionDto.class);

        }else if(Objects.equals(UserType.AGENCY_USER,userType)){
            //如果是普通用户，根据用户的角色去找菜单及权限
            //1.找出用户拥有的所有菜单 （用户-->角色-->菜单）
            String sql = "select m.id,m.menuIndex,m.routeCode,m.name,m.url,m.sort,m.description,m.frontDisc,m.icon,m.pid from sys_user u " +
                    " INNER JOIN sys_ag_user_role ur on ur.userId = u.id " +
                    " INNER JOIN sys_ag_role_authmenu rm on rm.roleId = ur.roleId " +
                    " INNER JOIN sys_ag_authmenu am on am.id = rm.menuId " +
                    " INNER JOIN sys_menu m on am.menuId = m.id " +
                    " where u.id = :uid order by m.pid ,m.sort";
            Map map = new HashMap();
            map.put("uid",id.toString());
            menuDtoList = queryList(sql,map,UserMenuDto.class);
            //2.找出用户拥有的菜单的功能
            String funcSql = "select f.id,f.name,f.menuId,f.resCode,f.resType,f.resName,f.resUrl,f.resRequestType,f.description from sys_user u " +
                    " INNER JOIN sys_ag_user_role ur on ur.userId = u.id " +
                    " INNER JOIN sys_ag_role_authmenu rm on rm.roleId = ur.roleId " +
                    " INNER JOIN sys_ag_menu_authfunc rf on rm.id = rf.roleMenuId " +
                    " INNER JOIN sys_menu_func f on rf.funcId = f.id where u.id=:uid";
            functionDtoList = queryList(funcSql,map,MenuFunctionDto.class);
        }else{
            throw new IllegalArgumentException("无效的用户类型");
        }

        //3.装配
        //将func匹配进menu
        List<MenuFunctionDto> finalFunctionDtoList = functionDtoList;
        menuDtoList.forEach(menu->{
            finalFunctionDtoList.forEach(func->{
                if(Objects.equals(func.getMenuId(),menu.getId())){
                    menu.getMenuFunctions().add(func);
                }
            });
        });
        return new ListResult<>(menuDtoList);
    }


    /**
     * 将集合数据转化成树形结构
     * @param dtoList 集合数据
     * @return 返回树形结构数据
     */
    private static List<MenuDto> buildTree(List<MenuDto> dtoList){
        List<MenuDto> treeList = new ArrayList<>();
        dtoList.forEach(parent->{
            if(null == parent.getPid()){
                treeList.add(parent);
            }
            dtoList.forEach(child->{
                if(Objects.equals(child.getPid(),parent.getId())){
                    if(null == parent.getChildren()){
                        parent.setChildren(new ArrayList<>());
                    }
                    parent.getChildren().add(child);
                }
            });
        });
        return treeList;
    }

}
