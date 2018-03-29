package com.sunesoft.ecloud.admin.repository;

import com.sunesoft.ecloud.admin.domain.agency.AgencyAuthorizedMenu;
import com.sunesoft.ecloud.hibernate.repository.BaseRepository;
import feign.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;
import java.util.UUID;

/**
 * @Author: niww
 * @Date: 2018/3/29
 */
@Repository
public interface AgencyAuthorizedMenuRepository extends BaseRepository<AgencyAuthorizedMenu,UUID>{

    @Query(value = "select * from sys_ag_authmenu am where am.menuId in ?1",nativeQuery = true)
    List<AgencyAuthorizedMenu> getMenuByMenuId(List<UUID> ids);
}
