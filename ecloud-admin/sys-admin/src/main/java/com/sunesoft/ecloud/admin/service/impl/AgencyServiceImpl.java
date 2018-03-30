package com.sunesoft.ecloud.admin.service.impl;

import com.sunesoft.ecloud.admin.domain.agency.Agency;
import com.sunesoft.ecloud.admin.domain.agency.AgencyAuthorizedMenu;
import com.sunesoft.ecloud.admin.domain.menu.Menu;
import com.sunesoft.ecloud.admin.repository.AgencyAuthorizedMenuRepository;
import com.sunesoft.ecloud.admin.repository.AgencyRepository;
import com.sunesoft.ecloud.admin.repository.MenuRepository;
import com.sunesoft.ecloud.admin.service.AgencyService;
import com.sunesoft.ecloud.adminclient.dtos.AgencyBasicDto;
import com.sunesoft.ecloud.adminclient.dtos.AgencyDto;
import com.sunesoft.ecloud.common.result.TResult;
import com.sunesoft.ecloud.common.utils.BeanUtil;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @Auther: niww
 * @Date: 2018/3/27/
 * 企业接口实现
 */
@Service
@Transactional
public class AgencyServiceImpl implements AgencyService{

    @Autowired
    AgencyRepository agencyRepository;
    @Autowired
    AgencyAuthorizedMenuRepository agMenuRepository;

    @Autowired
    MenuRepository  menuRepository;

    @Autowired
    AgencyAuthorizedMenuRepository authMenuRepository;

    @Override
    public TResult addOrUpdateAgency(AgencyDto agencyDto) {
        if(null == agencyDto){
            throw new IllegalArgumentException("无效的参数");
        }
        //todo :验证参数
        UUID id = agencyDto.getId();
        Agency agency ;
        List<AgencyAuthorizedMenu> agencyMenu;
        if(null == id){//新增
            agency = new Agency();
        }else{//修改
            agency = agencyRepository.findOne(id);
        }
        BeanUtil.copyProperties(agencyDto,agency,new String[]{"agencyType","serverStatus"});
        try{
            agency.setServerEndDate(DateUtils.parseDate(agencyDto.getServerEndDate(),new String[]{"yyyy-MM-dd HH:mm:ss"}));
        }catch (Exception e){
            e.printStackTrace();
        }

        // 配置菜单
        agency = agencyRepository.saveAndFlush(agency);
        List<UUID> menuIds = agencyDto.getMenuIds();
        if(null!=menuIds && menuIds.size()>0){
            UUID agId = agency.getId();
            //先删除原有的配置，再重新添加
//            agMenuRepository.deleteByAgencyId(agId);
            List<Menu> menus = menuRepository.findAll(menuIds);
            List<AgencyAuthorizedMenu> authMenuList = new ArrayList<>();
            AgencyAuthorizedMenu authMenu;
            for (Menu menu : menus) {
                authMenu = new AgencyAuthorizedMenu();
                authMenu.setAgencyId(agId);
                authMenu.setMenu(menu);
                authMenuList.add(authMenu);
            }
            authMenuRepository.save(authMenuList);
        }

        return new TResult<>(agencyDto);
    }

    @Override
    public TResult updateAgencyBasicInfo(AgencyBasicDto AgencyBasicDto) {
        UUID id = AgencyBasicDto.getId();
        Agency agency = agencyRepository.findOne(id);
        BeanUtil.copyProperties(AgencyBasicDto,agency,new String[]{"serverStatus"});
        agencyRepository.saveAndFlush(agency);
        return new TResult<>(AgencyBasicDto);
    }


    @Override
    public TResult delete(UUID id) {
        agencyRepository.delete(id);
        return new TResult<>(true);
    }

    @Override
    @Transactional
    public TResult deleteBatch(UUID... ids) {
        for (UUID id : ids) {
            agencyRepository.delete(id);
        }
        return new TResult<>(true);
    }
}
