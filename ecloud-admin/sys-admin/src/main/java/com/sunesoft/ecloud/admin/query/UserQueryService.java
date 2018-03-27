package com.sunesoft.ecloud.admin.query;

import com.sunesoft.ecloud.adminclient.cretirias.UserCriteria;
import com.sunesoft.ecloud.adminclient.dtos.UserDto;
import com.sunesoft.ecloud.adminclient.dtos.UserViewDto;
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
     * 获取企业下所有用户信息
     * @param agId 企业id
     * @return 返回查询结果
     */
    ListResult<UserDto> findAllUser(UUID agId);

    /**
     * 根据id查询用户信息
     * @param id 用户id
     * @return 返回查询结果
     */
    TResult<UserDto> findUserBasicById(UUID id);


    /**
     * 根据id查询用户信息
     * @param id 用户id
     * @return 返回查询结果
     */
    TResult<UserViewDto> findUserFullById(UUID id);
}
