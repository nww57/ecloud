package com.sunesoft.ecloud.auth.security.repository;

import com.sunesoft.ecloud.auth.model.security.User;
import com.sunesoft.ecloud.hibernate.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by stephan on 20.03.16.
 */
@Repository
public interface UserRepository extends BaseRepository<User, Long> {
    User findByUsername(String username);
}
