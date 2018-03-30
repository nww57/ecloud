package com.sunesoft.ecloud.admin.service.impl;

import com.sunesoft.ecloud.admin.domain.menu.Menu;
import com.sunesoft.ecloud.admin.repository.MenuRepository;
import com.sunesoft.ecloud.admin.service.MenuService;
import com.sunesoft.ecloud.adminclient.dtos.MenuDto;
import com.sunesoft.ecloud.common.result.TResult;
import com.sunesoft.ecloud.common.result.resultFactory.ResultFactory;
import com.sunesoft.ecloud.common.utils.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.util.UUID;

/**
 * @author: jiangzhenjing
 * @date: 2018/3/26 下午7:41
 * -
 */
@Service
@Transactional

public class MenuServiceImpl implements MenuService {

    @Autowired
    MenuRepository menuRepository;

    @Override
    public TResult addOrUpdateMenu(MenuDto menuDto) {
        Menu menu;
        if(menuDto.getId()!=null){//修改
            menu=menuRepository.findOne(menuDto.getId());
            BeanUtil.copyPropertiesIgnoreNull(menuDto,menu);
        }else{//新增
            menu=new Menu();
            BeanUtil.copyPropertiesIgnoreNull(menuDto,menu);
        }
        Menu save = menuRepository.save(menu);
        if(menuDto.getParentSimpleMenu()!=null){
            Menu one = menuRepository.findOne(menuDto.getParentSimpleMenu().getId());//父级菜单
            if(one!=null){
                one.getChiledren().add(menu);
                menu.setParentMenu(one);
                menu.setMenuIndex(one.getMenuIndex()+"."+save.getId());
            }
        }else{
            menu.setMenuIndex(save.getId()+"");
        }
//        menu.setParentMenu(menuRepository.findOne(menuDto.getParentSimpleMenu().getId()));
        Menu result = menuRepository.save(menu);
        return (TResult) ResultFactory.success(result);
    }

    @Override
    public TResult delete(UUID uuid) {
        Menu menu = menuRepository.findOne(uuid);
        if(menu!=null){
            //这里应该先判断下该菜单下有没有功能吗？
            menuRepository.delete(menu);
            return (TResult) ResultFactory.success();
        }
        return (TResult) ResultFactory.error("删除失败！");

    }

}
