package com.sunesoft.ecloud.admin.query;

import com.sunesoft.ecloud.adminclient.cretirias.UserCriteria;
import com.sunesoft.ecloud.adminclient.dtos.BasicDto;
import com.sunesoft.ecloud.adminclient.dtos.TreeDto;
import com.sunesoft.ecloud.adminclient.dtos.UserBasicDto;
import com.sunesoft.ecloud.adminclient.dtos.UserDto;
import com.sunesoft.ecloud.common.result.ListResult;
import com.sunesoft.ecloud.common.result.TResult;
import org.springframework.data.domain.Page;

import java.util.Map;
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
     * 根据id查询用户基本信息
     * @return 返回用户基本信息
     */
    TResult<UserBasicDto> getUserBasicInfo();

    /**
     * 根据id查询用户基本信息
     * @param id 用户id
     * @return 返回用户基本信息
     */
    TResult<UserBasicDto> getUserBasicInfoById(UUID id);


    /**
     * 根据id查询用户信息
     * @return 返回用户基本信息
     */
    TResult<UserDto> getUserFullInfo();



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
    TResult<Map<String,String>> getPositionList();
}
