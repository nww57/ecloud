package com.sunesoft.ecloud.admin.service.impl;

import com.sunesoft.ecloud.admin.domain.params.Parameter;
import com.sunesoft.ecloud.admin.domain.params.ParameterType;
import com.sunesoft.ecloud.admin.repository.ParameterRepository;
import com.sunesoft.ecloud.admin.repository.ParameterTypeRepository;
import com.sunesoft.ecloud.admin.service.ParameterService;
import com.sunesoft.ecloud.adminclient.dtos.ParameterDto;
import com.sunesoft.ecloud.common.result.TResult;
import com.sunesoft.ecloud.common.utils.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * @author: jiangzhenjing
 * @date: 2018/4/17 下午4:27
 * -
 */
@Service
@Transactional
public class ParameterServiceImpl implements ParameterService {

    @Autowired
    ParameterRepository parameterRepository;

    @Autowired
    ParameterTypeRepository parameterTypeRepository;


    @Override
    public TResult<ParameterDto> addOrUpdate(ParameterDto dto, UUID uuid) {
        if (uuid != null) {
            ParameterType parameterType = parameterTypeRepository.findOne(uuid);
            if (parameterType != null) {
                Parameter parameter;
                if (dto.getId() != null) {//修改
                    parameter = parameterRepository.findOne(dto.getId());
                } else {//新增
                    parameter = new Parameter();
                    parameterType.getParameterList().add(parameter);
                }
                parameter.setParameterType(parameterType);
                BeanUtil.copyPropertiesIgnoreNull(dto, parameter);
                Parameter result = parameterRepository.save(parameter);
                return new TResult(result);
            }
            return new TResult(false, "操作失败，没找到该参数类型！");
        }

        return new TResult(false, "操作失败，请选择参数类型！");
    }

    @Override
    public TResult<ParameterDto> delete(UUID uuid) {
        if (uuid != null) {
            parameterRepository.delete(uuid);
            return new TResult<>(true, "删除成功！");
        }
        return new TResult<>(false, "删除失败！");
    }
}
