package com.sunesoft.ecloud.admin.query.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sunesoft.ecloud.admin.query.UserQueryService;
import com.sunesoft.ecloud.admin.service.UserService;
import com.sunesoft.ecloud.adminclient.cretirias.UserCriteria;
import com.sunesoft.ecloud.adminclient.dtos.*;
import com.sunesoft.ecloud.common.result.ListResult;
import com.sunesoft.ecloud.common.result.PagedResult;
import com.sunesoft.ecloud.common.result.TResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

/**
 * @author: Zhouzh
 * @Date: 2018/3/23
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class UserQueryServiceImplTest {

    @Autowired
    UserService userService;
    @Autowired
    UserQueryService userQueryService;

    Gson gson = new GsonBuilder().create();


    @Test
    public void findUserPagedTest()
    {


        UserCriteria userCriteria = new UserCriteria();
        userCriteria.setPageIndex(1);
        userCriteria.setPageSize(10);
        PagedResult<UserDto> userPaged = userQueryService.findUserPaged(userCriteria);

        System.out.println(userPaged);

    }

    @Test
    public void getUserIdName(){
        ListResult<BasicDto> result= userQueryService.getUserIdName(UUID.fromString("234"));
        System.out.println(23);
    }






    @Test
    public void getPositionList(){
        ListResult<UserPositionDto> basic = userQueryService.getPositionList();
        System.out.println(32);
    }


    @Test
    public void findUserFullById(){
        TResult<UserDto> dto=   userQueryService.findUserFullById(UUID.fromString("a7bf0d93-5ff2-4c6c-b417-a3a8648d08d0"));
        System.out.println(23);
    }


    @Test
    public void test5(){
        TResult<UserMenuAuthDto> result = userQueryService.getUserAuthMenuList(UUID.fromString("654eee33-ba5b-4e82-b519-04d2c05b69bd"));
        System.out.println(23);
    }

    @Test
    public void test6(){
        ListResult<UserMenuDto> result = userQueryService.getUserMenuList(UUID.fromString("fc98e1ca-92f0-4f2e-b68c-f0129978c1bf"));
        System.out.println(23);
    }
}