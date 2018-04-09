package com.sunesoft.ecloud.admin.service.impl;

import com.sunesoft.ecloud.admin.repository.MenuRepository;
import com.sunesoft.ecloud.admin.service.MenuService;
import com.sunesoft.ecloud.adminclient.MenuType;
import com.sunesoft.ecloud.adminclient.dtos.MenuDto;
import com.sunesoft.ecloud.common.result.TResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

/**
 * @author: jiangzhenjing
 * @date: 2018/3/28 上午10:20
 * -
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class MenuServiceImplTest {

    @Autowired
    MenuService menuService;

    @Autowired
    MenuRepository menuRepository;

    @Test
    public void addOrUpdateMenu() throws Exception {
        MenuDto menuDto=new MenuDto();
//        menuDto.setId(UUID.fromString("5612c844-5d55-4a26-916d-51ce17efc0c7"));

        menuDto.setName("HHHHHHHH");
        menuDto.setSort(4);
        menuDto.setDescription("HHHHHHHHHHHHHHH");
        menuDto.setType(MenuType.LINK);
        menuDto.setPid(UUID.fromString("f7f3b5cf-3f6e-4a95-affe-5c6b49d3bbc9"));

//        MenuSimpleDto menuSimpleDto=new MenuSimpleDto();
//        menuSimpleDto.setId(UUID.fromString("d22222bf-c28f-4d00-8682-f445f64460ba"));
//        menuDto.setParentSimpleMenu(menuSimpleDto);

        TResult tResult = menuService.addOrUpdateMenu(menuDto);
        System.out.println(tResult);
    }

    @Test
    public void delete() throws Exception {
        TResult delete = menuService.delete(UUID.fromString("00be6a3c-03d8-45ca-b04e-5ae98de231ec"));
        System.out.println(delete);

    }

}