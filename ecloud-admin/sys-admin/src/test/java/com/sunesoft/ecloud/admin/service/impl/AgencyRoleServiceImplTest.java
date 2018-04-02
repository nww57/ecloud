package com.sunesoft.ecloud.admin.service.impl;

import com.sunesoft.ecloud.admin.repository.AgencyRoleAuthorizedMenuRepository;
import com.sunesoft.ecloud.admin.service.AgencyRoleService;
import com.sunesoft.ecloud.adminclient.dtos.AgencyRoleDto;
import com.sunesoft.ecloud.adminclient.dtos.AgencyRoleMenuDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sun.java2d.pipe.SpanIterator;


import java.util.*;


import static org.junit.Assert.*;

/**
 * @Auther: niww
 * @Date: 2018/3/28/028
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class AgencyRoleServiceImplTest {

    @Autowired
    AgencyRoleService roleService;
    @Autowired
    AgencyRoleAuthorizedMenuRepository repository;


    @Test
    public void addOrUpdateRole() throws Exception {
        AgencyRoleDto dto = new AgencyRoleDto();
//        dto.setId(UUID.fromString("454d71d1-a78e-471e-a5b5-ce18d57103b0"));
        dto.setName("测试看看能不能改");
        dto.setDescription("s2323这是个业务顾问XXx");

        Map<UUID,List<UUID>> map = new HashMap<>();
        List<UUID> func = new ArrayList<UUID>(){{
            add(UUID.fromString("254185e2-28d9-4400-bb16-9c5ef5a057f4"));
            add(UUID.fromString("9b866201-0a6b-4b7b-9eef-18492c1a5286"));
            add(UUID.fromString("d0a2bd50-473e-4776-9443-2bbfb5e76e0d"));
        }};
        map.put(UUID.fromString("56cfb947-2cda-4216-b1e8-92bd804d4a89"),func);
        dto.setAuthList(map);

        roleService.addOrUpdateRole(dto);
        System.out.println(23);
    }

    @Test
    public void delete() throws Exception {
    }

    @Test
    public void deleteBatch() throws Exception {
    }


    @Test
    public void deleteRepository(){
        repository.delete(UUID.fromString("98a218ce-75c0-405c-aca9-39f34af63d94"));
        System.out.println(23);
    }
}