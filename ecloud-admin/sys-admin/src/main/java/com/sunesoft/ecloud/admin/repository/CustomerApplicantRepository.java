package com.sunesoft.ecloud.admin.repository;

import com.sunesoft.ecloud.admin.domain.agency.CustomerApplicant;
import com.sunesoft.ecloud.hibernate.repository.BaseRepository;

import java.util.UUID;

/**
 * @Author: niww
 * @Date: 2018/4/11
 */
public interface CustomerApplicantRepository extends BaseRepository<CustomerApplicant,UUID>{

    void deleteByIdIn(UUID... id);
}
