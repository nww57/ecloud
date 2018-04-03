package com.sunesoft.ecloud.admin.query.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sunesoft.ecloud.admin.query.UserQueryService;
import com.sunesoft.ecloud.admin.service.UserService;
import com.sunesoft.ecloud.adminclient.cretirias.UserCriteria;
import com.sunesoft.ecloud.adminclient.dtos.*;
import com.sunesoft.ecloud.common.result.ListResult;
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
        Page<UserDto> userPaged = userQueryService.findUserPaged(userCriteria);

        System.out.println(userPaged);

    }

    @Test
    public void getUserIdName(){
        ListResult<BasicDto> result= userQueryService.getUserIdName();
        System.out.println(23);
    }

    @Test
    public void getBasicInfo(){
        TResult<UserDto> s = userQueryService.getUserFullInfo();
        System.out.println(23);
    }

    @Test
    public void getUserBasicInfo(){
        TResult<UserBasicDto> basic = userQueryService.getUserBasicInfo();
        System.out.println(32);
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
        TResult<UserMenuAuthDto> result = userQueryService.getUserAuthMenuList(UUID.fromString("0f35220d-718e-4e53-b260-cb329d7fb407"));
        System.out.println(23);
    }
}