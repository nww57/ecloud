package com.sunesoft.ecloud.admin.repository;

import com.sunesoft.ecloud.admin.domain.agency.AgencyAuthorizedMenu;
import com.sunesoft.ecloud.hibernate.repository.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

/**
 * @Auther: niww
 * @Date: 2018/3/29/029
 */
@Repository
public interface AgencyAuthorizedMenuRepository extends BaseRepository<AgencyAuthorizedMenu,UUID>{

    @Query(value = "select * from sys_ag_authmenu am where  am.menuId in :ids",nativeQuery = true)
    List<AgencyAuthorizedMenu> findByMenuIn(@Param("ids") List<UUID> ids);
}
