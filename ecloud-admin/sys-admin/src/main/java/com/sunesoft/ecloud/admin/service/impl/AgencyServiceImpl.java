package com.sunesoft.ecloud.admin.service.impl;

import com.sunesoft.ecloud.admin.domain.agency.Agency;
import com.sunesoft.ecloud.admin.repository.AgencyRepository;
import com.sunesoft.ecloud.admin.service.AgencyService;
import com.sunesoft.ecloud.adminclient.dtos.AgencyDto;
import com.sunesoft.ecloud.common.result.TResult;
import com.sunesoft.ecloud.common.utils.BeanUtil;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    public TResult addOrUpdateAgency(AgencyDto agencyDto) {
        if(null == agencyDto){
            throw new IllegalArgumentException("无效的参数");
        }
        //todo :验证参数
        UUID id = agencyDto.getId();
        Agency agency ;
        if(null == id){//新增
            agency = new Agency();
        }else{//修改
            agency = agencyRepository.findOne(id);
        }
        BeanUtil.copyProperties(agencyDto,agency,new String[]{"agencyType","serverStatus"});
        try{
            agency.setServerEndDate(DateUtils.parseDate(agencyDto.getServerEndDate(),new String[]{"yyyy-MM-dd"}));
        }catch (Exception e){
            e.printStackTrace();
        }
        //todo 配置菜单
        agencyRepository.saveAndFlush(agency);
        return new TResult<>(agencyDto);
    }

    @Override
    public TResult delete(UUID id) {
        agencyRepository.delete(id);
        return new TResult<>(true);
    }

    @Override
    @Transactional
    public TResult deleteBatch(UUID... ids) {
        agencyRepository.deleteBatch(ids);
        return new TResult<>(true);
    }
}
