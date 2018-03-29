package com.sunesoft.ecloud.admin.service.impl;

import com.sunesoft.ecloud.admin.service.AgencyRoleService;
import com.sunesoft.ecloud.adminclient.dtos.AgencyRoleDto;
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

    @Test
    public void addOrUpdateRole() throws Exception {
        AgencyRoleDto dto = new AgencyRoleDto();
        dto.setName("业务顾问");
        dto.setDescription("这是个业务顾问XXx");
        Map<UUID,List<UUID>> map = new HashMap<>();
        List<UUID> func = new ArrayList<UUID>(){{
            add(UUID.fromString("6529eb3a-ce3a-4412-8430-263b3713c0ae"));
        }};
        map.put(UUID.fromString("0bd1dacb-18a6-46ca-a2ea-bf95d3f974ee"),func);
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

}