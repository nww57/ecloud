package com.sunesoft.ecloud.caze.repository;

import com.sunesoft.ecloud.caze.domain.CaseCustomerRequest;
import com.sunesoft.ecloud.hibernate.repository.BaseRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

/**
 * @Auther: niww
 * @Date: 2018/4/13/013
 */
public interface CaseCustomerRequestRepository extends BaseRepository<CaseCustomerRequest,UUID>{
    @Modifying
    @Query(value = "delete from CaseCustomerRequest where id in :ids")
    void deleteBatch(@Param("ids") UUID... ids);
}