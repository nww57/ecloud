package com.sunesoft.ecloud.admin.service;

import com.sunesoft.ecloud.adminclient.dtos.ParameterTypeDto;
import com.sunesoft.ecloud.common.result.TResult;

import java.util.UUID;

/**
 * @author: jiangzhenjing
 * @date: 2018/4/17 下午3:30
 * -参数类型操作接口
 */
public interface ParameterTypeService {

    /**
     * 新增修改接口
     */
    TResult addOrUpdate(ParameterTypeDto dto);


    /**
     * 删除接口
     */
    TResult delete(UUID uuid);

}
