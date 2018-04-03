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
        dto.setId(UUID.fromString("f59208b0-fb1f-4976-8a77-8d012988933d"));
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
        roleService.delete(UUID.fromString("3e4c832c-46bc-4601-9808-de55d4aa3d4a"));
        System.out.println(23);
    }

    @Test
    public void deleteBatch() throws Exception {
    }


    @Test
    public void deleteRepository(){
        repository.delete(UUID.fromString("29bdac6e-97b9-446e-89c5-4a76f84e2a31"));
        System.out.println(23);
    }
}