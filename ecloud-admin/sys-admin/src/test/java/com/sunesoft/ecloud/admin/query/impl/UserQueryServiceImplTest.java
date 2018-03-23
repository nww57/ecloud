package com.sunesoft.ecloud.admin.query.impl;

import com.alibaba.druid.support.json.JSONUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sunesoft.ecloud.admin.query.UserQueryService;
import com.sunesoft.ecloud.admin.service.UserService;
import com.sunesoft.ecloud.adminclient.cretirias.UserCretiria;
import com.sunesoft.ecloud.adminclient.dtos.UserDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

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
    public void addUserTest(){
        UserDto userDto = new UserDto();
        userDto.setUserName("zhouzh");
        userDto.setPassword("12345678");
        userDto.setEmail("ss@qq.com");
        userDto.setPhoneNo("123222222222");
        userDto.setRealName("zhouzh");
        userService.addOrUpdateUser(userDto);
    }

    @Test
    public void findUserPagedTest()
    {

        Pageable pageable = new PageRequest(1,10,null);
        UserCretiria userCretiria = new UserCretiria();
        userCretiria.setUserName("zhouzh");
        Page<UserDto> userPaged = userQueryService.findUserPaged(pageable, userCretiria);

        System.out.println(userPaged);



    }



}