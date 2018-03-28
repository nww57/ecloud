package com.sunesoft.ecloud.admin.service.impl;

import com.sunesoft.ecloud.admin.domain.agency.Agency;
import com.sunesoft.ecloud.admin.domain.agency.AgencyRole;
import com.sunesoft.ecloud.admin.repository.AgencyRepository;
import com.sunesoft.ecloud.admin.repository.AgencyRoleRepository;
import com.sunesoft.ecloud.admin.service.AgencyRoleService;
import com.sunesoft.ecloud.adminclient.dtos.AgencyRoleDto;
import com.sunesoft.ecloud.common.result.TResult;
import com.sunesoft.ecloud.common.result.resultFactory.ResultFactory;
import com.sunesoft.ecloud.common.utils.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

/**
 * @Auther: niww
 * @Date: 2018/3/28/028
 */
@Service
@Transactional
public class AgencyRoleServiceImpl implements AgencyRoleService {

    @Autowired
    AgencyRepository agencyRepository;
    @Autowired
    AgencyRoleRepository roleRepository;

    @Override
    public TResult addOrUpdateRole(AgencyRoleDto agencyRoleDto) {
        UUID agId = UUID.fromString("200e6946-70e3-4087-839a-0491c631caf1");
        if(null == agId){
            return new TResult<>("参数agId为null");
        }
        boolean exist = agencyRepository.exists(agId);
        if(!exist){
            return new TResult<>("企业id不存在");
        }
        UUID id  = agencyRoleDto.getId();
        AgencyRole role;
        if(null == id){
            role = new AgencyRole();
        }else{
            role = roleRepository.findOne(id);
        }
        BeanUtil.copyPropertiesIgnoreNull(agencyRoleDto,role);
        roleRepository.saveAndFlush(role);
        return new TResult<>(agencyRoleDto);
    }

    @Override
    @Transactional
    public TResult delete(UUID id) {
        roleRepository.delete(id);
        return (TResult) ResultFactory.success();
    }

    @Override
    public TResult deleteBatch(UUID... ids) {
        roleRepository.deleteBatch(ids);
        return (TResult) ResultFactory.success();
    }
}
