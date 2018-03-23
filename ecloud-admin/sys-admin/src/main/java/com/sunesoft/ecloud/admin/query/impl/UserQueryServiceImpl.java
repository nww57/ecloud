package com.sunesoft.ecloud.admin.query.impl;

import com.sunesoft.ecloud.admin.domain.User;
import com.sunesoft.ecloud.admin.query.UserQueryService;
import com.sunesoft.ecloud.adminclient.cretirias.UserCretiria;
import com.sunesoft.ecloud.adminclient.dtos.UserDto;
import com.sunesoft.ecloud.common.sqlBuilderTool.SqlBuilder;
import com.sunesoft.ecloud.hibernate.sqlBuilder.HSqlBuilder;
import com.sunesoft.ecloud.hibernate.sqlExcute.GenericQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @author: Zhouzh
 * @Date: 2018/3/23
 */
@Service
@SuppressWarnings("All")
public class UserQueryServiceImpl extends GenericQuery implements UserQueryService {
    @Override
    public Page<UserDto> findUserPaged(Pageable pageable, UserCretiria cretiria) {
        SqlBuilder builder = HSqlBuilder.hFrom(User.class,"u")
                .where(cretiria.getParams())
                .pagging(pageable.getPageNumber(),pageable.getPageSize())
                .select(UserDto.class);
        return this.queryPaged(builder);
    }
}
