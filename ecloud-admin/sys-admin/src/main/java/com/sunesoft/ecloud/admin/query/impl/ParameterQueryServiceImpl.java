package com.sunesoft.ecloud.admin.query.impl;

import com.sunesoft.ecloud.admin.domain.params.Parameter;
import com.sunesoft.ecloud.admin.query.ParameterQueryService;
import com.sunesoft.ecloud.admin.repository.ParameterRepository;
import com.sunesoft.ecloud.adminclient.dtos.ParameterDto;
import com.sunesoft.ecloud.common.result.ListResult;
import com.sunesoft.ecloud.common.result.TResult;
import com.sunesoft.ecloud.common.sqlBuilderTool.SqlBuilder;
import com.sunesoft.ecloud.hibernate.sqlBuilder.HSqlBuilder;
import com.sunesoft.ecloud.hibernate.sqlExcute.GenericQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @author: jiangzhenjing
 * @date: 2018/4/17 下午3:34
 */
@Service
@SuppressWarnings("All")
public class ParameterQueryServiceImpl extends GenericQuery implements ParameterQueryService{

    @Autowired
    ParameterRepository parameterRepository;


    @Override
    public ListResult<ParameterDto> queryParaneterByTypeId(UUID uuid) {
        SqlBuilder sqlBuilder = HSqlBuilder.hFrom(Parameter.class, "p")
                .where("p.typeId", uuid);
        List<ParameterDto> list = this.queryList(sqlBuilder);
        return new ListResult(list);
    }

    @Override
    public TResult<ParameterDto> queryParaneterById(UUID uuid) {
        SqlBuilder sqlBuilder = HSqlBuilder.hFrom(Parameter.class, "p")
                .where("p.id", uuid);
        ParameterDto parameterDto = (ParameterDto)this.queryForObject(sqlBuilder);
        return new TResult<>(parameterDto);
    }

    @Override
    public ListResult<ParameterDto> queryAllParaneter() {
        SqlBuilder sqlBuilder = HSqlBuilder.hFrom(Parameter.class, "p");
        List<ParameterDto> list = this.queryList(sqlBuilder);
        return new ListResult(list);
    }
}