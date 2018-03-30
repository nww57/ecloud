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
        dto.setName("业务顾问2");
        dto.setDescription("s2323这是个业务顾问XXx");

        Map<UUID,List<UUID>> map = new HashMap<>();
        List<UUID> func = new ArrayList<UUID>(){{
            add(UUID.fromString("55997ad9-2645-492e-b811-e96d3e3d7ccc"));
        }};
        map.put(UUID.fromString("1d4597c4-fa81-41a9-ae98-0af2cb20d261"),func);
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