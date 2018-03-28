package com.sunesoft.ecloud.admin.query.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sunesoft.ecloud.admin.query.UserQueryService;
import com.sunesoft.ecloud.admin.service.UserService;
import com.sunesoft.ecloud.adminclient.cretirias.UserCriteria;
import com.sunesoft.ecloud.adminclient.dtos.UserDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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

        Pageable pageable = new PageRequest(1,10,null);
        UserCriteria userCriteria = new UserCriteria();
        userCriteria.setUserName("zhouzh");
        Page<UserDto> userPaged = userQueryService.findUserPaged(userCriteria);

        System.out.println(userPaged);



    }



}