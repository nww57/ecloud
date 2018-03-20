package com.sunesoft.ecloud.hibernate.repository;

import com.sunesoft.ecloud.hibernate.IEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author: Zhouzh
 * @Date: 2018/3/16
 */
public interface BaseRepository<T extends IEntity, ID extends Serializable> extends JpaRepository<T,ID>  {


}
