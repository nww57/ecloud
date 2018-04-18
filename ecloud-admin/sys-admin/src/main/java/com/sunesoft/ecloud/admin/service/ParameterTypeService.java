package com.sunesoft.ecloud.admin.query;

import com.sunesoft.ecloud.adminclient.dtos.ParameterTypeDto;
import com.sunesoft.ecloud.common.result.TResult;
import java.util.UUID;

/**
 * @author: jiangzhenjing
 * @date: 2018/4/17 下午3:30
 * -参数类型查询接口
 */
public interface ParameterTypeQueryService {

    /**
     * 根据id查询参数类型
     */
    TResult<ParameterTypeDto> queryParaneterTypeById(UUID uuid);


    /**
     * 查询所有参数类型
     */
    TResult<ParameterTypeDto> queryAllParaneterType();

}
