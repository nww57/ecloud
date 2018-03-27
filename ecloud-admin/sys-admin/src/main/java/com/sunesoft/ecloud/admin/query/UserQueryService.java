package com.sunesoft.ecloud.admin.query;

import com.sunesoft.ecloud.adminclient.cretirias.UserCriteria;
import com.sunesoft.ecloud.adminclient.dtos.UserDto;
import com.sunesoft.ecloud.common.result.ListResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

/**
 * @author: Zhouzh
 * @Date: 2018/3/23
 */
public interface UserQueryService {

    /**
     * 分页查找用户信息
     * @param criteria
     * @return
     */
    Page<UserDto> findUserPaged(UserCriteria criteria);

    /**
     * 获取企业下所有用户信息
     * @param id 企业id
     * @return 返回查询结果
     */
    ListResult<UserDto> findAllUser(UUID id);
}
