package com.sunesoft.ecloud.hibernate.repository;

import com.sunesoft.ecloud.hibernate.IEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;


/**
 * @author: Zhouzh
 * @Date: 2018/3/16
 */
@NoRepositoryBean
public interface BaseRepository<T extends IEntity, ID extends Serializable> extends JpaRepository<T,ID>  {


}
