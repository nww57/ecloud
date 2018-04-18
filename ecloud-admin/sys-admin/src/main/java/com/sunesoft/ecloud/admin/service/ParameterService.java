package com.sunesoft.ecloud.admin.query;

import com.sunesoft.ecloud.adminclient.dtos.ParameterDto;
import com.sunesoft.ecloud.common.result.TResult;
import java.util.UUID;

/**
 * @author: jiangzhenjing
 * @date: 2018/4/17 下午3:23
 * 参数查询接口
 */

public interface ParameterQueryService {

    /**
     * 根据参数类型查询参数
     */
    TResult<ParameterDto> queryParaneterByTypeId(UUID uuid);


    /**
     * 根据参数id查询参数
     */
    TResult<ParameterDto> queryParaneterById(UUID uuid);


    /**
     * 查询所有参数
     */
    TResult<ParameterDto> queryAllParaneter();

}
