package com.sunesoft.ecloud.admin.query.impl;

import com.sunesoft.ecloud.admin.query.FlowRoleQueryService;
import com.sunesoft.ecloud.adminclient.cretirias.FlowRoleCriteria;
import com.sunesoft.ecloud.adminclient.dtos.BasicDto;
import com.sunesoft.ecloud.adminclient.dtos.FlowRoleUserDto;
import com.sunesoft.ecloud.common.result.PagedResult;
import com.sunesoft.ecloud.common.result.TResult;
import com.sunesoft.ecloud.hibernate.sqlExcute.GenericQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @auther: niww
 * @date: 2018/5/24/024
 */
@Service
public class FlowRoleQueryServiceImpl extends GenericQuery implements FlowRoleQueryService {

    @Override
    public PagedResult<FlowRoleUserDto> findFlowRoleInfoByPaged(FlowRoleCriteria criteria) {
        String sql = "select * from sys_flow_role ";
        return queryPaged(criteria.getPageIndex(),criteria.getPageSize(),sql,null,FlowRoleUserDto.class);
    }

    @Override
    public TResult<FlowRoleUserDto> getFlowRoleUserInfoById(UUID roleId) {
        String sql = "select fr.id,fr.name,fr.description from sys_flow_role where fr.id = '"+roleId+"'";
        FlowRoleUserDto dto = queryForObject(sql,null,FlowRoleUserDto.class);
        String uesrSql = "select * from sys_flow_role_user_rel fu left join sys_user su on su.id = fu.userId where fu.roleId = '"+roleId+"'";
        List<BasicDto> userInfoList = queryList(uesrSql,null,BasicDto.class);
        dto.setUserList(userInfoList);
        return new TResult<>(dto);
    }
}
