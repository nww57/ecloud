package com.sunesoft.ecloud.admin.query.impl;

import com.sunesoft.ecloud.admin.query.MenuQueryService;
import com.sunesoft.ecloud.adminclient.dtos.MenuDto;
import com.sunesoft.ecloud.adminclient.dtos.MenuSimpleDto;
import com.sunesoft.ecloud.common.result.ListResult;
import com.sunesoft.ecloud.common.result.TResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.JsonExpectationsHelper;

import java.util.UUID;

import static org.junit.Assert.*;

/**
 * @author: jiangzhenjing
 * @date: 2018/3/28 上午10:30
 * -
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class MenuQueryServiceImplTest {

    @Autowired
    MenuQueryService menuQueryService;

    @Test
    public void findAllMenu() throws Exception {
        ListResult<MenuDto> allMenu = menuQueryService.findAllMenu();
        System.out.println(allMenu.getResult().get(0));
    }

    @Test
    public void findAllSimpleMenu() throws Exception {
        ListResult<MenuSimpleDto> allSimpleMenu = menuQueryService.findAllSimpleMenu();
        System.out.println(allSimpleMenu.getResult().get(0));
    }

    @Test
    public void findMenuByID() throws Exception {
        UUID uuid=UUID.fromString("8c831c8f-9ffc-42af-b40d-46dce4218fec");
        TResult<MenuDto> menuByID = menuQueryService.findMenuByID(uuid);
        System.out.println(menuByID.getResult().getName());
    }

}