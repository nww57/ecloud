package com.sunesoft.ecloud.admin.query;

import com.sunesoft.ecloud.adminclient.cretirias.UserCriteria;
import com.sunesoft.ecloud.adminclient.dtos.BasicDto;
import com.sunesoft.ecloud.adminclient.dtos.UserDto;
import com.sunesoft.ecloud.common.result.ListResult;
import com.sunesoft.ecloud.common.result.TResult;
import org.springframework.data.domain.Page;

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
     * 根据id查询用户信息
     * @param id 用户id
     * @return 返回用户基本信息
     */
    TResult<UserDto> findUserBasicById(UUID id);



    /**
     * 获取企业下所有用户的id，name
     * @param agId 企业id
     * @return 返回查询结果
     */
    ListResult<BasicDto> getUserIdName(UUID agId);
}
