package com.sunesoft.ecloud.admin.service.impl;

import com.sunesoft.ecloud.admin.domain.flow.FlowRoleUser;
import com.sunesoft.ecloud.admin.repository.FlowUserRoleRepository;
import com.sunesoft.ecloud.admin.service.FlowRoleService;
import com.sunesoft.ecloud.common.result.TResult;
import com.sunesoft.ecloud.common.result.resultFactory.ResultFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @auther: niww
 * @date: 2018/5/24/024
 */
@Service
public class FlowRoleServiceImpl implements FlowRoleService {

    @Autowired
    FlowUserRoleRepository flowUserRoleRepository;

    @Override
    public TResult editRoleUser(UUID roleId, List<UUID> userIdList) {
        if(null == roleId) {
            throw new IllegalArgumentException("角色id不能为null");
        }
        //先删除再新增
        flowUserRoleRepository.deleteByRoleIdEquals(roleId);
        if(null != userIdList && userIdList.size() >0){
            List<FlowRoleUser> roleUserList = new ArrayList<>();
            userIdList.forEach(u->{
                roleUserList.add(new FlowRoleUser(roleId,u));
            });
            flowUserRoleRepository.saveAll(roleUserList);
        }
        return ResultFactory.success();
    }
}
