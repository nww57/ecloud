package com.sunesoft.ecloud.hibernate.repository;

import com.sunesoft.ecloud.hibernate.IEntity;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import java.io.Serializable;

public class BaseRepositoryImpl<T extends IEntity, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements BaseRepository<T, ID> {

    public final EntityManager entityManager;

    public BaseRepositoryImpl(JpaEntityInformation<T, ID> jpaEntityInformation, EntityManager entityManager) {
        super(jpaEntityInformation, entityManager);
        this.entityManager = entityManager;
    }

}