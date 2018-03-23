package com.sunesoft.ecloud.admin.query;

import com.sunesoft.ecloud.adminclient.cretirias.UserCretiria;
import com.sunesoft.ecloud.adminclient.dtos.UserDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author: Zhouzh
 * @Date: 2018/3/23
 */
public interface UserQueryService {

    Page<UserDto> findUserPaged(Pageable pageable, UserCretiria cretiria);


}
