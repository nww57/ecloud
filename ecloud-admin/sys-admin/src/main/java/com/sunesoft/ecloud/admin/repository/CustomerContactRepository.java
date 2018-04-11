package com.sunesoft.ecloud.admin.repository;

import com.sunesoft.ecloud.admin.domain.agency.CustomerContact;
import com.sunesoft.ecloud.hibernate.repository.BaseRepository;

import java.util.UUID;

/**
 * @Author: niww
 * @Date: 2018/4/11
 */
public interface CustomerContactRepository extends BaseRepository<CustomerContact,UUID>{

    void deleteByIdIn(UUID... id);
}
