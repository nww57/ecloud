package com.sunesoft.ecloud.caze.repository;

import com.sunesoft.ecloud.caze.domain.PatCustomerDemand;
import com.sunesoft.ecloud.hibernate.repository.BaseRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

/**
 * @Author: niww
 * @Date: 2018/5/6
 */
public interface PatCustomerDemandRepository extends BaseRepository<PatCustomerDemand,UUID>{

    @Query(value = "select PatCustomerDemand from PatCustomerDemand where patentInfo.id = :patentId")
    PatCustomerDemand findByPatent(UUID patentId);
}
