package com.sunesoft.ecloud.admin.repository;

import com.sunesoft.ecloud.admin.domain.agency.AgencyRoleAuthorizedMenu;
import com.sunesoft.ecloud.hibernate.repository.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * @Author: niww
 * @Date: 2018/3/29
 */
@Repository
public interface AgencyRoleAuthorizedMenuRepository extends BaseRepository<AgencyRoleAuthorizedMenu,UUID>{
}
