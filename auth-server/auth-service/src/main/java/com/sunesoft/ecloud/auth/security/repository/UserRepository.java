package com.sunesoft.ecloud.auth.security.repository;

import com.sunesoft.ecloud.adminclient.dtos.UserLoginDto;
import com.sunesoft.ecloud.hibernate.sqlExcute.GenericQuery;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by stephan on 20.03.16.
 */
@Repository
public class UserRepository extends GenericQuery {

    public UserLoginDto findByUsername(String userName){


        String sql = "select * from sys_user where userName =:userName";
        Map<String,Object> map = new HashMap<>();
        map.put("userName",userName);

        UserLoginDto user =  queryForObject(sql,map,UserLoginDto.class);

        return user;

    }



}
