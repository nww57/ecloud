package com.sunesoft.ecloud.admin.service.impl;

import com.sunesoft.ecloud.admin.domain.agency.User;
import com.sunesoft.ecloud.admin.repository.UserRepository;
import com.sunesoft.ecloud.admin.service.UserService;
import com.sunesoft.ecloud.adminclient.dtos.UserDto;
import com.sunesoft.ecloud.common.result.TResult;
import com.sunesoft.ecloud.common.result.resultFactory.ResultFactory;
import com.sunesoft.ecloud.common.utils.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author: Zhouzh
 * @Date: 2018/3/23
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    /**
     * 新增修改密码
     *
     * @param userDto
     * @return
     */
    @Override
    public TResult addOrUpdateUser(UserDto userDto) {
        User user = new User();
        BeanUtil.copyPropertiesIgnoreNull(userDto,user);
        userRepository.save(user);
        return (TResult)ResultFactory.success();
    }

    /**
     * 删除用户
     *
     * @param uuid
     * @return
     */
    @Override
    public TResult deleteUser(UUID uuid) {
        return null;
    }

    /**
     * 批量删除用户
     *
     * @param ids
     * @return
     */
    @Override
    public TResult deleteUserBatch(UUID[] ids) {
        return null;
    }

    /**
     * 修改密码
     *
     * @param id
     * @param oldPassword
     * @param newPassword
     * @return
     */
    @Override
    public TResult changePassword(UUID id, String oldPassword, String newPassword) {
        return null;
    }

    /**
     * @param id
     * @param newPassword
     * @return
     */
    @Override
    public TResult setPassword(UUID id, String newPassword) {
        return null;
    }
}
