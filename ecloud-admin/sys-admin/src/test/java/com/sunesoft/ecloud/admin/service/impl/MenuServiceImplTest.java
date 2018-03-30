package com.sunesoft.ecloud.admin.service.impl;

import com.sunesoft.ecloud.admin.domain.menu.Menu;
import com.sunesoft.ecloud.admin.repository.MenuRepository;
import com.sunesoft.ecloud.admin.service.MenuService;
import com.sunesoft.ecloud.adminclient.dtos.MenuDto;
import com.sunesoft.ecloud.adminclient.dtos.MenuSimpleDto;
import com.sunesoft.ecloud.common.result.TResult;
import com.sunesoft.ecloud.common.utils.BeanUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

import static org.junit.Assert.*;

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
        menuDto.setId(UUID.fromString("f28586a2-9e12-47e0-88a5-f9b14b98f0d7"));

        menuDto.setName("测试2修改");
        menuDto.setSort(1);
        menuDto.setDescription("测试啊");

        MenuSimpleDto menuSimpleDto=new MenuSimpleDto();
        menuSimpleDto.setId(UUID.fromString("d22222bf-c28f-4d00-8682-f445f64460ba"));
        menuDto.setParentSimpleMenu(menuSimpleDto);

        TResult tResult = menuService.addOrUpdateMenu(menuDto);
        System.out.println(tResult);
    }

    @Test
    public void delete() throws Exception {
        TResult delete = menuService.delete(UUID.fromString("f0045d9e-e2a0-4bad-afcc-240864e65a39"));
        System.out.println(delete);

    }

}