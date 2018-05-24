package com.sunesoft.ecloud.admin.repository;

import com.sunesoft.ecloud.admin.domain.flow.FlowRoleUser;
import com.sunesoft.ecloud.hibernate.repository.BaseRepository;
import org.springframework.data.jpa.repository.Modifying;

import java.util.UUID;

/**
 * @auther: niww
 * @date: 2018/5/24/024
 */
public interface FlowUserRoleRepository extends BaseRepository<FlowRoleUser,UUID> {

    @Modifying
    void deleteByRoleIdEquals(UUID roleId);
}
