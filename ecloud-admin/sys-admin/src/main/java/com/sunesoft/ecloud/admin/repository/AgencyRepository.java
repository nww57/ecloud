package com.sunesoft.ecloud.admin.repository;

import com.sunesoft.ecloud.admin.domain.agency.Agency;
import com.sunesoft.ecloud.adminclient.AgencyType;
import com.sunesoft.ecloud.hibernate.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

/**
 * @Auther: niww
 * @Date: 2018/3/27/027
 */
public interface AgencyRepository extends BaseRepository<Agency,UUID>,JpaSpecificationExecutor {

    /**
     * 根据机构编码查找
     * @param code 编码
     * @return 返回信息
     */
    Agency findByCodeEquals(String code);

    @Modifying
    @Query(value = "update Agency set is_active = false where id in :ids")
    void deleteLogical(@Param("ids") UUID... ids);


    Agency findAgencyByNameEqualsAndAgencyTypeEquals(String name, AgencyType type);
}
