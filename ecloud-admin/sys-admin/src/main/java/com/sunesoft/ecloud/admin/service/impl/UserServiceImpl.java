package com.sunesoft.ecloud.admin.service.impl;

import com.sunesoft.ecloud.admin.domain.agency.Agency;
import com.sunesoft.ecloud.admin.domain.agency.AgencyOrganization;
import com.sunesoft.ecloud.admin.domain.agency.AgencyRole;
import com.sunesoft.ecloud.admin.domain.agency.User;
import com.sunesoft.ecloud.admin.repository.AgencyOrganizationRepository;
import com.sunesoft.ecloud.admin.repository.AgencyRepository;
import com.sunesoft.ecloud.admin.repository.AgencyRoleRepository;
import com.sunesoft.ecloud.admin.repository.UserRepository;
import com.sunesoft.ecloud.admin.service.UserService;
import com.sunesoft.ecloud.adminclient.LoginResultStatus;
import com.sunesoft.ecloud.adminclient.ServerStatusType;
import com.sunesoft.ecloud.adminclient.UserPositionType;
import com.sunesoft.ecloud.adminclient.UserType;
import com.sunesoft.ecloud.adminclient.dtos.LoginResultDto;
import com.sunesoft.ecloud.adminclient.dtos.UserBasicDto;
import com.sunesoft.ecloud.adminclient.dtos.UserDto;
import com.sunesoft.ecloud.adminclient.dtos.UserLoginDto;
import com.sunesoft.ecloud.common.result.TResult;
import com.sunesoft.ecloud.common.result.resultFactory.ResultFactory;
import com.sunesoft.ecloud.common.utils.BeanUtil;
import com.sunesoft.ecloud.common.utils.IPUtil;
import com.sunesoft.ecloud.common.utils.StringUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.persistence.criteria.Predicate;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.util.ArrayList;
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
    @Autowired
    AgencyRepository agencyRepository;


    /**
     * BCrypt加密
     */
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    /**
     * 新增修改密码
     *
     * @param userDto
     * @return
     */
    @Override
    public TResult addOrUpdateUser(UserDto userDto) {

        //检查参数
        TResult checkResult = checkParam(userDto);
        if(!checkResult.getIs_success()){
            return checkResult;
        }
        UUID id = userDto.getId();
        UUID agId = userDto.getAgId();
        UUID structureId = userDto.getOrganizationId();
        List<UUID> roleList = userDto.getRoleIdList();
        User user;
        if (null == id) {
            user = new User();
            if (Objects.equals(user.getUserType(), UserType.AGENCY_ADMIN)) {
                user.setAgId(userDto.getAgId());
                user.setPosition(UserPositionType.ADMIN.toString());
                user.setPassword(encoder.encode(userDto.getPassword()));
            } else {
                user.setAgId(agId);
                user.setPosition(UserPositionType.EMPLOYEE.toString());
                //设置默认密码
                user.setPassword(encoder.encode("888888"));
            }
        } else {
            user = userRepository.findById(id).get();
        }
        //设置组织机构
        if (null != structureId) {
            AgencyOrganization org = orgRepository.findById(structureId).get();
            if (null == org) {
                return new TResult("组织机构不存在");
            }
            user.setAgencyOrganization(org);
        }
        //设置角色
        if (null != roleList && roleList.size() > 0) {
            List<AgencyRole> roleListEntity = roleRepository.findAllById(roleList);
            user.getRoleList().clear();
            user.setRoleList(roleListEntity);
        }
        BeanUtil.copyPropertiesIgnoreNull(userDto, user);

        userRepository.saveAndFlush(user);
        return new TResult<>(user.getId());
    }



    @Override
    public TResult updateUserBasicInfo(UserBasicDto userBasicDto) {
        UUID id = userBasicDto.getId();
        User user = userRepository.findById(id).get();
        BeanUtil.copyPropertiesIgnoreNull(userBasicDto, user);
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
        //删除用户跟角色的关联关系
        User user = userRepository.findById(id).get();
        user.getRoleList().clear();
        userRepository.deleteById(id);
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


    @Override
    public TResult changePassword(UUID id, String oldPassword, String newPassword) {
        // 验证旧密码是否正确
        String password = userRepository.selectPassword(id);
        if (!encoder.matches(oldPassword,password)) {
            return new TResult("旧密码错误");
        }
        userRepository.updatePassword(id, encoder.encode(newPassword),false);
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
    public TResult setPassword(UUID id, String newPassword,Boolean need) {
        boolean exist = userRepository.existsById(id);
        if (!exist) {
            return new TResult<>("用户id不存在");
        }
        userRepository.updatePassword(id,encoder.encode(newPassword),need);
        return (TResult) ResultFactory.success();
    }





    @Override
    public TResult<LoginResultDto> userLogin(String userName, String password) {
        if(StringUtil.isEmpty(userName) || StringUtil.isEmpty(password)){
            return new TResult<>("参数错误");
        }
        User user = userRepository.findByUserNameEquals(userName);
        if (null == user) {
            return new TResult<>(new LoginResultDto(null, LoginResultStatus.ERROR_USERNAME));
        }
        if(!Objects.equals(user.getUserType(),UserType.SUPER_ADMIN)){
            UUID agId = user.getAgId();
            Agency agency = agencyRepository.findById(agId).get();
            if(!agency.getIs_active()){
                return new TResult<>(new LoginResultDto(null, LoginResultStatus.ERROR_USERNAME));
            }
            if(Objects.equals(agency.getServerStatus(), ServerStatusType.DISABLE)){
                return new TResult<>(new LoginResultDto(null, LoginResultStatus.SERVER_EXPIRED));
            }
        }
        if(!encoder.matches(password,user.getPassword())){
            return new TResult<>(new LoginResultDto(null,LoginResultStatus.ERROR_PASSWORD));
        }else{
            // 设置登录ip及最后一次登录时间
            HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
            String ip = IPUtil.getClientIp(request);
            userRepository.updateLoginIPAndLastLoginDatetime(user.getId(),ip);
            UserLoginDto dto = new UserLoginDto();
            BeanUtil.copyProperties(user,dto);
            return new TResult<>(new LoginResultDto(dto,LoginResultStatus.SUCCESS));
        }

    }

    @Override
    public TResult<Boolean> checkUserNameExist(UUID id,String userName) {
        if(StringUtil.isEmpty(userName)){
            return new TResult<>("参数错误");
        }
        Specification querySpecification = (Specification<User>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if(null != id){
                predicates.add(criteriaBuilder.notEqual(root.get("id"), id));
            }
            predicates.add(criteriaBuilder.equal(root.get("userName"), userName));
            return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
        };
        List<User> userList =  userRepository.findAll(querySpecification);
        if(null != userList && userList.size()>0){
            return new TResult<>(true);
        }
        return new TResult<>(false);
    }


    private TResult checkParam(UserDto userDto) {
        if(null == userDto.getAgId()){
            throw new IllegalArgumentException("企业id不能为null");
        }
        if(StringUtils.isEmpty(userDto.getUserName())){
            return new TResult("用户名不能为空");
        }
        TResult<Boolean> existResult = checkUserNameExist(userDto.getId(),userDto.getUserName());
        if(existResult.getIs_success()){
            if(existResult.getResult()) {
                return new TResult("用户名已经存在");
            }
        }
        return (TResult) ResultFactory.success();
    }




}
