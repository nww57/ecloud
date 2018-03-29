package com.sunesoft.ecloud.admin.service.impl;

import com.sunesoft.ecloud.admin.service.MenuService;
import com.sunesoft.ecloud.adminclient.dtos.MenuDto;
import com.sunesoft.ecloud.common.result.TResult;
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

    @Test
    public void addOrUpdateMenu() throws Exception {
        MenuDto menuDto=new MenuDto();
//        menuDto.setId(UUID.fromString("52996c7b-ba83-4af0-ad92-04084b4fac52"));
        menuDto.setName("bbbb");
        menuDto.setSort(2);
        menuDto.setDescription("bbbbbb");
        TResult tResult = menuService.addOrUpdateMenu(menuDto);
        System.out.println(tResult);
    }

    @Test
    public void delete() throws Exception {
        TResult delete = menuService.delete(UUID.fromString("f0045d9e-e2a0-4bad-afcc-240864e65a39"));
        System.out.println(delete);

    }

}