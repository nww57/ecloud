package com.sunesoft.ecloud.caze.repository;

import com.sunesoft.ecloud.caze.domain.ContractInfo;
import com.sunesoft.ecloud.hibernate.repository.BaseRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

/**
 * @Auther: niww
 * @Date: 2018/5/4/004
 */
public interface ContractInfoRepository extends BaseRepository<ContractInfo,UUID> {

    @Procedure(procedureName = "generate_contractNo")
    String generateContractNo(@Param("agId") String agId);

    @Modifying
    @Query(value = "update ContractInfo set is_active = false where id in :ids")
    void deleteBatch(@Param("ids") UUID... ids);
}
