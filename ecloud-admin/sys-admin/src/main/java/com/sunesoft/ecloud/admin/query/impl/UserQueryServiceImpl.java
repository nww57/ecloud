package com.sunesoft.ecloud.admin.query.impl;

import com.sunesoft.ecloud.admin.domain.agency.AgencyOrganization;
import com.sunesoft.ecloud.admin.domain.agency.AgencyRole;
import com.sunesoft.ecloud.admin.domain.agency.User;
import com.sunesoft.ecloud.admin.query.UserQueryService;
import com.sunesoft.ecloud.admin.repository.UserRepository;
import com.sunesoft.ecloud.adminclient.cretirias.UserCriteria;
import com.sunesoft.ecloud.adminclient.dtos.BasicDto;
import com.sunesoft.ecloud.adminclient.dtos.UserDto;
import com.sunesoft.ecloud.common.result.ListResult;
import com.sunesoft.ecloud.common.result.TResult;
import com.sunesoft.ecloud.common.sqlBuilderTool.SqlBuilder;
import com.sunesoft.ecloud.common.utils.BeanUtil;
import com.sunesoft.ecloud.hibernate.sqlBuilder.HSqlBuilder;
import com.sunesoft.ecloud.hibernate.sqlExcute.GenericQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
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
                .leftJoin(AgencyOrganization.class,"org")
                .on("u.structureId=org.id")
                .where(cretiria.getParams())
                .pagging(cretiria.getPageIndex(),cretiria.getPageSize())
                .select(UserDto.class)
                .setFieldValue("organizationId","org.Id")
                .setFieldValue("organizationName","org.Name");
        return this.queryPaged(builder);
    }

    @Override
    public TResult<UserDto> getUserInfo() {
        //todo 先获取用户id
        UUID id = UUID.fromString("26ff304d-d8b1-47f6-bd29-15a92ad590a4");
        return findUserBasicById(id);
    }

    @Override
    public TResult<UserDto> findUserBasicById(UUID id) {
        SqlBuilder<UserDto> builder = HSqlBuilder.hFrom(User.class, "user")
                .leftJoin(AgencyOrganization.class,"org")
                .on("user.structureId = org.id")
                .where("id",id)
                .setFieldValue("org.id","organizationId")
                .setFieldValue("org.name","organizationName")
                .select(UserDto.class);
        return new TResult<>(queryForObject(builder));
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


}
