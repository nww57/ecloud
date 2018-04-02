package com.sunesoft.ecloud.admin.service.impl;

import com.sunesoft.ecloud.admin.domain.agency.AgencyOrganization;
import com.sunesoft.ecloud.admin.domain.agency.AgencyRole;
import com.sunesoft.ecloud.admin.domain.agency.User;
import com.sunesoft.ecloud.admin.repository.AgencyOrganizationRepository;
import com.sunesoft.ecloud.admin.repository.AgencyRoleRepository;
import com.sunesoft.ecloud.admin.repository.UserRepository;
import com.sunesoft.ecloud.admin.service.UserService;
import com.sunesoft.ecloud.adminclient.UserPositionType;
import com.sunesoft.ecloud.adminclient.UserType;
import com.sunesoft.ecloud.adminclient.dtos.UserDto;
import com.sunesoft.ecloud.common.result.TResult;
import com.sunesoft.ecloud.common.result.resultFactory.ResultFactory;
import com.sunesoft.ecloud.common.utils.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * @author: Zhouzh
 * @Date: 2018/3/23
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    AgencyOrganizationRepository orgRepository;
    @Autowired
    AgencyRoleRepository roleRepository;

    @Value("${ecloud.agId}")
    private UUID agId;

    private static final UUID userId = UUID.fromString("42c569c0-7be3-42c6-9c07-6d9939d2739d");

    /**
     * 新增修改密码
     *
     * @param userDto
     * @return
     */
    @Override
    public TResult addOrUpdateUser(UserDto userDto) {

        UUID id = userDto.getId();
        //todo 检查用户名是否存在
        String userName = userDto.getUserName();
        UUID structureId = userDto.getOrganizationId();
        List<UUID> roleList = userDto.getRoleIdList();
        User user;
        if (null == id) {
            user = new User();
        } else {
            user = userRepository.findOne(id);
        }
        //设置组织机构
        if (null != structureId) {
            AgencyOrganization org = orgRepository.findOne(structureId);
            if (null == org) {
                return new TResult("组织机构不存在");
            }
            user.setAgencyOrganization(org);
        }
        //设置角色
        if (null != roleList && roleList.size() > 0) {
            List<AgencyRole> roleListEntity = roleRepository.findAll(roleList);
            user.setRoleList(roleListEntity);
        }
        BeanUtil.copyPropertiesIgnoreNull(userDto, user);
        if(Objects.equals(user.getUserType(), UserType.AGENCY_ADMIN)){
            user.setAgencyId(userDto.getAgId());
            user.setPosition(UserPositionType.ADMIN.toString());
        }else{
            user.setAgencyId(agId);
            user.setPosition(UserPositionType.EMPLOYEE.toString());
        }
        userRepository.saveAndFlush(user);
        return (TResult) ResultFactory.success();
    }

    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    @Override
    public TResult deleteUser(UUID id) {
        userRepository.delete(id);
        return (TResult) ResultFactory.success();
    }

    /**
     * 批量删除用户
     *
     * @param ids
     * @return
     */
    @Override
    public TResult deleteUserBatch(UUID... ids) {
        userRepository.deleteBatch(ids);
        return (TResult) ResultFactory.success();
    }

    /**
     * 修改密码
     *
     * @param id
     * @param oldPassword
     * @param newPassword
     * @return
     */
    @Override
    public TResult changePassword(UUID id, String oldPassword, String newPassword) {
        //todo :验证旧密码是否正确
        setPassword(id, newPassword);
        return (TResult) ResultFactory.success();
    }

    @Override
    public TResult changePassword(String oldPassword, String newPassword) {
        changePassword(userId,oldPassword,newPassword);
        return (TResult) ResultFactory.success();
    }

    /**
     * 设置密码
     *
     * @param id
     * @param newPassword
     * @return
     */
    @Override
    public TResult setPassword(UUID id, String newPassword) {
        boolean exist = userRepository.exists(id);
        if (!exist) {
            return new TResult<>("用户id不存在");
        }
        userRepository.updatePassword(id, newPassword);
        return (TResult) ResultFactory.success();
    }

    @Override
    public TResult setPassword(String newPassword) {
        setPassword(userId,newPassword);
        return (TResult) ResultFactory.success();
    }
}
