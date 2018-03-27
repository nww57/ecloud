package com.sunesoft.ecloud.admin.repository;

import com.sunesoft.ecloud.admin.domain.menu.Menu;
import com.sunesoft.ecloud.hibernate.repository.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.UUID;

/**
 * @author: jiangzhenjing
 * @date: 2018/3/27 上午9:55
 * -
 */
@Repository
public interface MenuRepository extends BaseRepository<Menu, UUID> {
    /**
     * 查询所有菜单
     *
     * @param pageable
     * @return
     */
//    Page<Menu> findAllBy(Pageable pageable);
}
