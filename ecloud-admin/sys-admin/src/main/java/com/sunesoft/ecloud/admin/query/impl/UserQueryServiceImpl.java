package com.sunesoft.ecloud.admin.query.impl;

import com.sunesoft.ecloud.admin.domain.agency.AgencyOrganization;
import com.sunesoft.ecloud.admin.domain.agency.AgencyRole;
import com.sunesoft.ecloud.admin.domain.agency.User;
import com.sunesoft.ecloud.admin.query.UserQueryService;
import com.sunesoft.ecloud.admin.repository.UserRepository;
import com.sunesoft.ecloud.adminclient.UserPositionType;
import com.sunesoft.ecloud.adminclient.cretirias.UserCriteria;
import com.sunesoft.ecloud.adminclient.dtos.BasicDto;
import com.sunesoft.ecloud.adminclient.dtos.UserBasicDto;
import com.sunesoft.ecloud.adminclient.dtos.UserDto;
import com.sunesoft.ecloud.adminclient.dtos.UserPositionDto;
import com.sunesoft.ecloud.common.result.ListResult;
import com.sunesoft.ecloud.common.result.TResult;
import com.sunesoft.ecloud.common.sqlBuilderTool.SqlBuilder;
import com.sunesoft.ecloud.common.utils.BeanUtil;
import com.sunesoft.ecloud.hibernate.sqlBuilder.HSqlBuilder;
import com.sunesoft.ecloud.hibernate.sqlExcute.GenericListExtractor;
import com.sunesoft.ecloud.hibernate.sqlExcute.GenericQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.*;

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
    public TResult<UserBasicDto> getUserBasicInfo() {
        //todo 先获取用户id
        UUID id = UUID.fromString("42c569c0-7be3-42c6-9c07-6d9939d2739d");
        return getUserBasicInfoById(id);
    }

    @Override
    public TResult<UserBasicDto> getUserBasicInfoById(UUID id) {
        SqlBuilder<UserBasicDto> builder = HSqlBuilder.hFrom(User.class,"user")
                .where("id",id)
                .select(UserBasicDto.class);
        UserBasicDto user =  queryForObject(builder);
        user.setPosition(UserPositionType.valueOf(user.getPosition()).getName());
        return new TResult<>(user);
    }

    @Override
    public TResult<UserDto> getUserFullInfo() {
        //todo 先获取用户id
        UUID id = UUID.fromString("42c569c0-7be3-42c6-9c07-6d9939d2739d");
        return findUserFullById(id);
    }

    @Override
    public TResult<UserDto> findUserFullById(UUID id) {
        SqlBuilder<UserDto> builder = HSqlBuilder.hFrom(User.class, "user")
                .leftJoin(AgencyOrganization.class,"org")
                .on("user.structureId = org.id")
                .where("id",id)
                .setFieldValue("org.id","organizationId")
                .setFieldValue("org.name","organizationName")
                .select(UserDto.class);
        UserDto userInfo = queryForObject(builder);
        String sql = "select  r.id ,r.name  from sys_user u left join sys_ag_user_role ur on u.id = ur.userId left join sys_ag_role r on ur.roleId = r.id where u.id = :id";
        Map params = new HashMap();
        params.put("id",id);
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
            position.setName(position.getName());
            positionDtos.add(positionDto);
        }
        return new ListResult<>(positionDtos);
    }


}
