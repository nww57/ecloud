package com.sunesoft.ecloud.admin.query.impl;

import com.sunesoft.ecloud.admin.domain.agency.User;
import com.sunesoft.ecloud.admin.query.UserQueryService;
import com.sunesoft.ecloud.admin.repository.UserRepository;
import com.sunesoft.ecloud.adminclient.cretirias.UserCriteria;
import com.sunesoft.ecloud.adminclient.dtos.UserDto;
import com.sunesoft.ecloud.adminclient.dtos.UserViewDto;
import com.sunesoft.ecloud.common.result.ListResult;
import com.sunesoft.ecloud.common.result.TResult;
import com.sunesoft.ecloud.common.sqlBuilderTool.SqlBuilder;
import com.sunesoft.ecloud.hibernate.sqlBuilder.HSqlBuilder;
import com.sunesoft.ecloud.hibernate.sqlExcute.GenericQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.UUID;

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
        SqlBuilder builder = HSqlBuilder.hFrom(User.class, "u")
                .where(cretiria.getParams())
                .pagging(1, 2)
                .select(UserDto.class);
        return this.queryPaged(builder);

    }

    @Override
    public ListResult<UserDto> findAllUser(UUID id) {
        return null;
    }

    @Override
    public TResult<UserDto> findUserBasicById(UUID id) {
        return null;
    }

    @Override
    public TResult<UserViewDto> findUserFullById(UUID id) {
        return null;
    }



}
