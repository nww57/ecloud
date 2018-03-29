package com.sunesoft.ecloud.admin.repository;

import com.sunesoft.ecloud.admin.domain.agency.User;
import com.sunesoft.ecloud.hibernate.repository.BaseRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.UUID;

/**
 * @author: Zhouzh
 * @Date: 2018/3/23
 */
@Repository
public interface UserRepository extends BaseRepository<User,UUID> {

    @Modifying
    @Query(value = "delete from User  where id in :ids")
    void deleteBatch(@Param("ids") UUID... ids);


    @Modifying
    @Query(value = "update  User set password = :password where id = :id")
    void updatePassword(@Param("id") UUID id, @Param("password") String newPassword);

}
