package com.sunesoft.ecloud.admin.repository;

import com.sunesoft.ecloud.admin.domain.agency.User;
import com.sunesoft.ecloud.hibernate.repository.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * @author: Zhouzh
 * @Date: 2018/3/23
 */
@Repository
public interface UserRepository extends BaseRepository<User,UUID> {
}
