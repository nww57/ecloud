package com.sunesoft.ecloud.admin.service;

import com.sunesoft.ecloud.admin.domain.agency.User;
import com.sunesoft.ecloud.adminclient.dtos.UserBasicDto;
import com.sunesoft.ecloud.adminclient.dtos.UserDto;
import com.sunesoft.ecloud.common.result.TResult;

import java.util.UUID;
/**
 * @author: Zhouzh
 * @Date: 2018/3/23
 */
public interface UserService {

    /**
     * 新增/修改 用户信息
     * @param userDto
     * @return
     */
    TResult addOrUpdateUser(UserDto userDto);

    /**
     * 修改用户基础信息
     * @param userBasicDto
     * @return
     */
    TResult updateUserBasicInfo(UserBasicDto userBasicDto);

    /**
     * 删除用户
     * @param id
     * @return
     */
    TResult deleteUser(UUID id);


    /**
     * 批量删除用户
     * @param ids
     * @return
     */
    TResult deleteUserBatch(UUID... ids);


    /**
     * 修改密码
     * @param id
     * @param oldPassword
     * @param newPassword
     * @return
     */
    TResult changePassword(UUID id,String oldPassword,String newPassword);

    /**
     * 修改密码
     * @param oldPassword
     * @param newPassword
     * @return
     */
    TResult changePassword(String oldPassword,String newPassword);

    /**
     *设置密码
     * @param id
     * @param newPassword
     * @return
     */
    TResult setPassword(UUID id,String newPassword);



    /**
     * 重置密码后，下次登录时是否需要修改密码
     * @param need
     * @return
     */
    TResult setNeedChangePassword(UUID id,Boolean need);


    /**
     *设置密码
     * @param newPassword
     * @return
     */
    TResult setPassword(String newPassword);


    /**
     * 用户登录
     * @param userName 用户名
     * @param password 密码
     * @return 返回登录状态
     */
    TResult<UUID> userLogin(String userName, String password);




}
