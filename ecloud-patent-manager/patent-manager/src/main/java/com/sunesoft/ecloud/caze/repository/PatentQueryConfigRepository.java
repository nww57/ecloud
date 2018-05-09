package com.sunesoft.ecloud.caze.repository;

import com.sunesoft.ecloud.caze.domain.PatentQueryConfig;
import com.sunesoft.ecloud.hibernate.repository.BaseRepository;

import java.util.UUID;

/**
 * @Auther: niww
 * @Date: 2018/5/8/008
 */
public interface PatentQueryConfigRepository extends BaseRepository<PatentQueryConfig,UUID>{

    PatentQueryConfig findByUserId(UUID userId);
}
