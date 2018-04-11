package com.sunesoft.ecloud.admin.repository;

import com.sunesoft.ecloud.admin.domain.agency.CustomerInventor;
import com.sunesoft.ecloud.hibernate.repository.BaseRepository;

import java.util.UUID;

/**
 * @Author: niww
 * @Date: 2018/4/11
 */
public interface CustomerInventorRepository extends BaseRepository<CustomerInventor,UUID>{
    void deleteByIdIn(UUID... id);
}
