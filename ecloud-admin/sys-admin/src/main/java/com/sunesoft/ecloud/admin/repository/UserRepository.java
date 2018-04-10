package com.sunesoft.ecloud.admin.repository;

import com.sunesoft.ecloud.admin.domain.agency.User;
import com.sunesoft.ecloud.hibernate.repository.BaseRepository;
import com.sunesoft.ecloud.hibernate.repository.BaseRepositoryImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

/**
 * @author: Zhouzh
 * @Date: 2018/3/23
 */
@Repository
public interface UserRepository extends BaseRepository<User,UUID>,JpaSpecificationExecutor {


    @Modifying
    @Query(value = "delete from User  where id in :ids")
    void deleteBatch(@Param("ids") UUID... ids);

    @Modifying
    @Query(value = "update  User set password = :password ,needChangePassword = :need where id = :id")
    void updatePassword(@Param("id") UUID id, @Param("password") String newPassword ,@Param("need") Boolean need);


    @Modifying
    @Query(value = "update User set position = :position where id = :id")
    void updatePosition(@Param("id") UUID id,@Param("position") String position);

    @Query(value = "select u.password from User u where u.id = :id")
    String selectPassword(@Param("id") UUID id);

    void deleteByAgencyId(UUID agId);

    /**
     * 根据用户名密码查找用户
     * @param userName 用户名
     * @param password 密码
     * @return 返回用户信息
     */
    User findUserByUserNameAndPassword(String userName,String password);

    /**
     * 根据用户名查找用户
     * @param userName
     * @return
     */
    User findByUserNameEquals(String userName);

    @Modifying
    @Query(value = "update User u set u.agencyOrganization = null where u.agencyOrganization.id = :orgId")
    void updateOrganizationNull(@Param("orgId") UUID orgId);



}
