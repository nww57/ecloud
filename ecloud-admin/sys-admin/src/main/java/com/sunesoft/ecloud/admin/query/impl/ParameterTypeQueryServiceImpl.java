package com.sunesoft.ecloud.admin.query.impl;

import com.sunesoft.ecloud.admin.domain.params.ParameterType;
import com.sunesoft.ecloud.admin.query.ParameterTypeQueryService;
import com.sunesoft.ecloud.adminclient.dtos.ParameterDto;
import com.sunesoft.ecloud.adminclient.dtos.ParameterTypeDto;
import com.sunesoft.ecloud.common.TreeUtils;
import com.sunesoft.ecloud.common.result.ListResult;
import com.sunesoft.ecloud.common.result.TResult;
import com.sunesoft.ecloud.common.sqlBuilderTool.SqlBuilder;
import com.sunesoft.ecloud.hibernate.sqlBuilder.HSqlBuilder;
import com.sunesoft.ecloud.hibernate.sqlExcute.GenericQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @author: jiangzhenjing
 * @date: 2018/4/17 下午3:33
 * -
 */
@Service
@SuppressWarnings("All")
public class ParameterTypeQueryServiceImpl extends GenericQuery implements ParameterTypeQueryService{
    @Override
    public TResult<ParameterTypeDto> queryParameterTypeById(UUID uuid) {
        SqlBuilder sqlBuilder = HSqlBuilder.hFrom(ParameterType.class, "p")
                .where("p.id", uuid)
                .select(ParameterTypeDto.class);
        ParameterTypeDto parameterTypeDto = (ParameterTypeDto)this.queryForObject(sqlBuilder);
        return new TResult<>(parameterTypeDto);
    }

    @Override
    public ListResult<ParameterTypeDto> queryAllParameterType() {
        SqlBuilder sqlBuilder = HSqlBuilder.hFrom(ParameterType.class, "p")
                .select(ParameterTypeDto.class);
        List<ParameterTypeDto> list = this.queryList(sqlBuilder);
        List<ParameterTypeDto> listResult = TreeUtils.transformationTree(list);
        return new ListResult(listResult);
    }
}
