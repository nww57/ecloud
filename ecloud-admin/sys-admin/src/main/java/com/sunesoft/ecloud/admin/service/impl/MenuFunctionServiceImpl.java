package com.sunesoft.ecloud.admin.service.impl;

import com.sunesoft.ecloud.admin.domain.menu.Menu;
import com.sunesoft.ecloud.admin.domain.menu.MenuFunction;
import com.sunesoft.ecloud.admin.repository.MenuFunctionRepository;
import com.sunesoft.ecloud.admin.repository.MenuRepository;
import com.sunesoft.ecloud.admin.service.MenuFunctionService;
import com.sunesoft.ecloud.adminclient.dtos.MenuFunctionDto;
import com.sunesoft.ecloud.common.result.TResult;
import com.sunesoft.ecloud.common.result.resultFactory.ResultFactory;
import com.sunesoft.ecloud.common.utils.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

/**
 * @author: jiangzhenjing
 * @date: 2018/3/26 下午7:09
 * -
 */
@Service
@Transactional
public class MenuFunctionServiceImpl implements MenuFunctionService {

    @Autowired
    MenuFunctionRepository menuFunctionRepository;

    @Autowired
    MenuRepository menuRepository;

    @Override
    public TResult addOrUpdateFunction(MenuFunctionDto menuFunctionDto ,UUID uuid) {
        if(uuid!=null){
            Menu menu = menuRepository.findOne(uuid);
            if(menu==null){
                return (TResult) ResultFactory.error("操作失败，菜单无效！");
            }
            MenuFunction menuFunction;
            if(menuFunctionDto.getId()!=null){//修改
                menuFunction=menuFunctionRepository.findOne(menuFunctionDto.getId());
                BeanUtil.copyPropertiesIgnoreNull(menuFunctionDto,menuFunction);
            }else{//新增
                menuFunction=new MenuFunction();
                BeanUtil.copyPropertiesIgnoreNull(menuFunctionDto,menuFunction);
                menu.getMenuFunctions().add(menuFunction);
            }
            menuFunction.setMenu(menu);
//            Menu save = menuRepository.save(menu);
            MenuFunction save = menuFunctionRepository.save(menuFunction);
            return (TResult) ResultFactory.success();
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
