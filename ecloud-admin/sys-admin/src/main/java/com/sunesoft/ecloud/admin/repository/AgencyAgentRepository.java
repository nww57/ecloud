package com.sunesoft.ecloud.admin.repository;

import com.sunesoft.ecloud.admin.domain.agency.AgencyAgent;
import com.sunesoft.ecloud.hibernate.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;

/**
 * Created by jzj on 2018/4/11.
 */
public interface AgencyAgentRepository extends BaseRepository<AgencyAgent,UUID> ,JpaSpecificationExecutor {

    void deleteByIdIn(UUID... id);
}
