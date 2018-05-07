package com.sunesoft.ecloud.caze.repository;

import com.sunesoft.ecloud.caze.domain.PatCustomerDemand;
import com.sunesoft.ecloud.hibernate.repository.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

/**
 * @Author: niww
 * @Date: 2018/5/6
 */
public interface PatCustomerDemandRepository extends BaseRepository<PatCustomerDemand,UUID>{

    @Query(value = "select demand from PatCustomerDemand demand where demand.patentInfo.id = :patentId")
    PatCustomerDemand findByPatent(@Param("patentId") UUID patentId);
}
