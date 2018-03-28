package com.sunesoft.ecloud.admin.repository;

import com.sunesoft.ecloud.admin.domain.menu.MenuFunction;
import com.sunesoft.ecloud.adminclient.dtos.MenuFunctionDto;
import com.sunesoft.ecloud.common.result.ListResult;
import com.sunesoft.ecloud.hibernate.repository.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

/**
 * @author: jiangzhenjing
 * @date: 2018/3/27 上午9:55
 * -
 */
@Repository
public interface MenuFunctionRepository extends BaseRepository<MenuFunction, UUID> {

    /**
     * 根据菜单ID查询相应操作功能
     */
    ListResult<MenuFunctionDto> findByMenu(UUID uuid);
}
