package com.sunesoft.ecloud.admin.service;

import com.sunesoft.ecloud.adminclient.dtos.UserDto;
import com.sunesoft.ecloud.common.result.TResult;
import java.util.UUID;
/**
 * @author: Zhouzh
 * @Date: 2018/3/23
 */
public interface UserService {

    /**
     * 新增修改密码
     * @param userDto
     * @return
     */
    TResult addOrUpdateUser(UserDto userDto);

    /**
     * 删除用户
     * @param uuid
     * @return
     */
    TResult deleteUser(UUID uuid);


    /**
     * 批量删除用户
     * @param ids
     * @return
     */
    TResult deleteUserBatch(UUID[] ids);


    /**
     * 修改密码
     * @param id
     * @param oldPassword
     * @param newPassword
     * @return
     */
    TResult changePassword(UUID id,String oldPassword,String newPassword);

    /**
     *
     * @param id
     * @param newPassword
     * @return
     */
    TResult setPassword(UUID id,String newPassword);







}
