package com.sunesoft.ecloud.admin.service.impl;

import com.sunesoft.ecloud.admin.domain.menu.MenuFunction;
import com.sunesoft.ecloud.admin.repository.MenuFunctionRepository;
import com.sunesoft.ecloud.admin.service.MenuFunctionService;
import com.sunesoft.ecloud.adminclient.dtos.MenuFunctionDto;
import com.sunesoft.ecloud.common.result.TResult;
import com.sunesoft.ecloud.common.result.resultFactory.ResultFactory;
import com.sunesoft.ecloud.common.utils.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

/**
 * @author: jiangzhenjing
 * @date: 2018/3/26 下午7:09
 * -
 */
public class MenuFunctionServiceImpl implements MenuFunctionService {

    @Autowired
    MenuFunctionRepository menuFunctionRepository;

    @Override
    public TResult addOrUpdateFunction(MenuFunctionDto menuFunctionDto ,UUID uuid) {
        if(uuid!=null){
            MenuFunction menuFunction;
            if(menuFunctionDto.getUuid()!=null){//修改
                menuFunction=menuFunctionRepository.getOne(menuFunctionDto.getUuid());
                BeanUtil.copyPropertiesIgnoreNull(menuFunctionDto,menuFunction);
            }else{//新增
                menuFunction=new MenuFunction();
                BeanUtil.copyPropertiesIgnoreNull(menuFunctionDto,menuFunction);
            }
            MenuFunction save = menuFunctionRepository.save(menuFunction);
            return (TResult) ResultFactory.success(save);
        }
        return (TResult) ResultFactory.error("操作失败，请选择菜单！");
    }

    @Override
    public TResult delete(List<UUID> ids) {
        for (UUID id : ids) {
            menuFunctionRepository.delete(id);
        }
        return (TResult) ResultFactory.success();
    }

}
