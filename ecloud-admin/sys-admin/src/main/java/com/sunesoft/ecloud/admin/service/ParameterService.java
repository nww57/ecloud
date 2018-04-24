package com.sunesoft.ecloud.admin.service;

import com.sunesoft.ecloud.adminclient.dtos.ParameterDto;
import com.sunesoft.ecloud.common.result.TResult;

import java.util.List;
import java.util.UUID;

/**
 * @author: jiangzhenjing
 * @date: 2018/4/17 下午3:23
 * 参数操作接口
 */

public interface ParameterService {

    /**
     * 新增修改接口
     */
    TResult<ParameterDto> addOrUpdate(ParameterDto dto, UUID uuid);


    /**
     * 删除接口
     */
    TResult<ParameterDto> delete(List<UUID> ids);


}
