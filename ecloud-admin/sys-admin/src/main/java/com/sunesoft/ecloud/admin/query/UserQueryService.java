package com.sunesoft.ecloud.admin.query;

import com.sunesoft.ecloud.adminclient.cretirias.UserCriteria;
import com.sunesoft.ecloud.adminclient.dtos.*;
import com.sunesoft.ecloud.common.result.ListResult;
import com.sunesoft.ecloud.common.result.TResult;
import org.springframework.data.domain.Page;

import java.util.UUID;

/**
 * @author: Zhouzh
 * @Date: 2018/3/23
 */
public interface UserQueryService {

    /**
     * 分页查找用户信息
     * @param criteria
     * @return
     */
    Page<UserDto> findUserPaged(UserCriteria criteria);

    /**
     * 根据用户名查找用户信息
     * @param userName 用户名
     * @return 返回用户信息
     */
    UserDto findUserByUserName(String userName);



    /**
     * 根据id查询用户基本信息
     * @param id 用户id
     * @return 返回用户基本信息
     */
    TResult<UserBasicDto> getUserBasicInfoById(UUID id);





    /**
     * 根据id查询用户信息
     * @param id 用户id
     * @return 返回用户基本信息
     */
    TResult<UserDto> findUserFullById(UUID id);



    /**
     * 获取企业下所有用户的id，name
     * @return 返回查询结果
     */
    ListResult<BasicDto> getUserIdName();

    /**
     * 获取用户职位列表
     * @return 返回查询结果
     */
    ListResult<UserPositionDto> getPositionList();


    /**
     * 根据用户id获取用户的菜单权限
     * @param id 用户id
     * @return 返回菜单树形结构
     */
    TResult<UserMenuAuthDto> getUserAuthMenuList(UUID id);

    /**
     * 根据用户id获取用户的菜单权限
     * @param id 用户id
     * @return 返回扁平结构
     */
    ListResult<UserMenuDto> getUserMenuList(UUID id);


    /**
     * 获取用户功能列表
     * @param id 用户id
     * @return 返回功能列表
     */
    ListResult<MenuFunctionDto> getUserFuncList(UUID id);
}
