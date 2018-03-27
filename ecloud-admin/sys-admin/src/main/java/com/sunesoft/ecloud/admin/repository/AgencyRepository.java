package com.sunesoft.ecloud.admin.repository;

import com.sunesoft.ecloud.admin.domain.agency.Agency;
import com.sunesoft.ecloud.hibernate.repository.BaseRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * @Auther: niww
 * @Date: 2018/3/27/027
 */
@Repository
public interface AgencyRepository extends BaseRepository<Agency,UUID> {

    @Modifying
    @Query(value = "delete from Agency where id in :ids")
    void deleteBatch(@Param("ids") UUID... ids);

}
