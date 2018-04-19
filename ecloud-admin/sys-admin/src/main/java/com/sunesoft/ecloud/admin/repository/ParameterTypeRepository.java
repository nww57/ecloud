package com.sunesoft.ecloud.admin.repository;

import com.sunesoft.ecloud.admin.domain.params.ParameterType;
import com.sunesoft.ecloud.hibernate.repository.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * @author: jiangzhenjing
 * @date: 2018/4/17 下午3:45
 * -
 */
@Repository
public interface ParameterTypeRepository extends BaseRepository<ParameterType,UUID>{
}
