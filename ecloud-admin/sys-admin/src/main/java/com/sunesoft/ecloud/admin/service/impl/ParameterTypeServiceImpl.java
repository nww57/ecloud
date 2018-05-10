package com.sunesoft.ecloud.admin.service.impl;

import com.sunesoft.ecloud.admin.domain.params.ParameterType;
import com.sunesoft.ecloud.admin.repository.ParameterTypeRepository;
import com.sunesoft.ecloud.admin.service.ParameterTypeService;
import com.sunesoft.ecloud.adminclient.dtos.ParameterTypeDto;
import com.sunesoft.ecloud.common.result.TResult;
import com.sunesoft.ecloud.common.result.resultFactory.ResultFactory;
import com.sunesoft.ecloud.common.utils.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * @author: jiangzhenjing
 * @date: 2018/4/17 下午4:28
 * -
 */
@Service
@Transactional
public class ParameterTypeServiceImpl implements ParameterTypeService {

    @Autowired
    ParameterTypeRepository parameterTypeRepository;


    @Override
    public TResult addOrUpdate(ParameterTypeDto dto) {
        ParameterType parameterType;
        if (dto.getId() != null) {//修改
            parameterType = parameterTypeRepository.findById(dto.getId()).get();
        } else {//新增
            parameterType = new ParameterType();
        }
        BeanUtil.copyPropertiesIgnoreNull(dto, parameterType);
        ParameterType result =parameterTypeRepository.save(parameterType);
        if (dto.getPid() != null && dto.getId()==null) {//有父节点，并且是新增菜单
            ParameterType one = parameterTypeRepository.findById(dto.getPid()).get();//父级菜单
            if (one != null) {
                one.getChildren().add(parameterType);
                parameterType.setParentParamType(one);
            }
            result = parameterTypeRepository.save(parameterType);
        }
        return (TResult) ResultFactory.success(result.getId());
    }

    @Override
    public TResult delete(UUID uuid) {
        if (uuid != null) {
            parameterTypeRepository.deleteById(uuid);
            return new TResult<>(true, "删除成功！");
        }
        return new TResult<>(false, "删除失败！");
    }
}
