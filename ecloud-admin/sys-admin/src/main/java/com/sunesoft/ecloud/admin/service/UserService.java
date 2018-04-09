package com.sunesoft.ecloud.admin.service;

import com.sunesoft.ecloud.adminclient.dtos.LoginResultDto;
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
     * @param userDto 参数
     * @return 返回操作结果
     */
    TResult addOrUpdateUser(UserDto userDto);

    /**
     * 修改用户基础信息
     * @param userBasicDto 参数
     * @return 返回操作结果
     */
    TResult updateUserBasicInfo(UserBasicDto userBasicDto);

    /**
     * 删除用户
     * @param id 用户id
     * @return 返回操作结果
     */
    TResult deleteUser(UUID id);


    /**
     * 批量删除用户
     * @param ids ids
     * @return 返回操作结果
     */
    TResult deleteUserBatch(UUID... ids);


    /**
     * 修改密码
     * @param id id
     * @param oldPassword 旧密码
     * @param newPassword 新密码
     * @return 返回操作结果
     */
    TResult changePassword(UUID id,String oldPassword,String newPassword);



    /**
     *设置密码
     * @param id id
     * @param newPassword 新密码
     * @param need 下次登录是否需要修改密码
     * @return 返回操作结果
     */
    TResult setPassword(UUID id,String newPassword,Boolean need);





    /**
     * 用户登录
     * @param userName 用户名
     * @param password 密码
     * @return 返回操作结果
     */
    TResult<LoginResultDto> userLogin(String userName, String password);


    /**
     * 检查用户名是否存在
     * @param userName 用户名
     * @return true:已存在 false:不存在
     */
    TResult<Boolean> checkUserNameExist(String userName);


}
