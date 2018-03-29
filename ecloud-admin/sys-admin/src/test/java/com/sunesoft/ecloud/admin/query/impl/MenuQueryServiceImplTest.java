package com.sunesoft.ecloud.admin.query.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
        ObjectMapper mapper = new ObjectMapper();
        String json = null;
        try {
            json = mapper.writeValueAsString(allMenu);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(json);
    }

    @Test
    public void findAllSimpleMenu() throws Exception {
        ListResult<MenuSimpleDto> allSimpleMenu = menuQueryService.findAllSimpleMenu();
        ObjectMapper mapper = new ObjectMapper();
        String json = null;
        try {
            json = mapper.writeValueAsString(allSimpleMenu);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(json);
    }

    @Test
    public void findMenuByID() throws Exception {
        UUID uuid=UUID.fromString("f0045d9e-e2a0-4bad-afcc-240864e65a39");
        TResult<MenuDto> menuByID = menuQueryService.findMenuByID(uuid);
        System.out.println(menuByID.getResult().getName());
    }

}