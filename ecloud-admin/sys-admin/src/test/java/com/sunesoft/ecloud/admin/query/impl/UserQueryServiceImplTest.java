package com.sunesoft.ecloud.admin.query.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sunesoft.ecloud.admin.query.UserQueryService;
import com.sunesoft.ecloud.admin.service.UserService;
import com.sunesoft.ecloud.adminclient.cretirias.UserCriteria;
import com.sunesoft.ecloud.adminclient.dtos.BasicDto;
import com.sunesoft.ecloud.adminclient.dtos.UserBasicDto;
import com.sunesoft.ecloud.adminclient.dtos.UserDto;
import com.sunesoft.ecloud.common.result.ListResult;
import com.sunesoft.ecloud.common.result.TResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;

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
        userCriteria.setPageIndex(0);
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
        TResult<UserDto> s = userQueryService.getUserInfo();
        System.out.println(23);
    }

    @Test
    public void getUserBasicInfo(){
        TResult<UserBasicDto> basic = userQueryService.getUserBasicInfo();
        System.out.println(32);
    }



}