package com.sunesoft.ecloud.caze.api;

import com.sunesoft.ecloud.auth.UserContext;
import com.sunesoft.ecloud.caseclient.criterias.PatentQueryCriteria;
import com.sunesoft.ecloud.caseclient.dto.*;
import com.sunesoft.ecloud.caseclient.enums.PatentNode;
import com.sunesoft.ecloud.caze.query.PatentQueryService;
import com.sunesoft.ecloud.caze.service.PatentService;
import com.sunesoft.ecloud.common.result.PagedResult;
import com.sunesoft.ecloud.common.result.TResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

/**
 * Created by wangguangyang on 2018/5/7.
 */
@RestController
@RequestMapping("/patentManager")
public class PatentController {

    @Autowired
    PatentQueryService patentQueryService;
    @Autowired
    PatentService patentService;

    /**
     * 查询专利列表
     * @param criteria
     * @return
     */
    @GetMapping("search")
    public PagedResult<PatentListDto> search(PatentQueryCriteria criteria){
        UUID agId = UUID.fromString(UserContext.getAgencyId());
        UUID userId=UUID.fromString(UserContext.getUserID());
        criteria.setAgId(agId);
        criteria.setUserId(userId);
        return patentQueryService.queryPatentPaged(criteria);
    }

    /**
     * 查询各节点对应专利数量
     * @return
     */
    @GetMapping("nodes")
    public TResult<Map<PatentNode,Integer>> getNodes(){
        UUID agId = UUID.fromString(UserContext.getAgencyId());
        return patentQueryService.getPatentNodeCount(agId);
    }

    /**
     * 获取专利详情
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public TResult<PatentDetailDto> getDetail(@PathVariable UUID id){
        return patentQueryService.getPatentInfoById(id);
    }

    /**
     * 完善专利信息
     * @param id
     * @param dto
     * @return
     */
    @PutMapping("{id}")
    public TResult updatePatent(@PathVariable UUID id,@RequestBody UpdatePatentDto dto){
        dto.setPatentId(id);
        return patentService.updatePatent(dto);
    }

    /**
     * 获取用户设置后的查询条件
     * @return
     */
    @GetMapping("setting")
    public TResult<PatentQueryConfigDto> getSetting(){
        UUID userId=UUID.fromString(UserContext.getUserID());
        return patentQueryService.getUserPatentQueryConfig(userId);
    }

    /**
     * 保存配置项
     * @param dto
     * @return
     */
    @PostMapping("setting")
    public TResult saveSetting(@RequestBody PatentQueryConfigDto dto){
        UUID userId=UUID.fromString(UserContext.getUserID());
        dto.setUserId(userId);
        return patentService.configPatentQueryCondition(dto);
    }

    /**
     * 分配工程师及撰写截止日期
     * @param id
     * @param dto
     * @return
     */
    @PutMapping("{id}/allotEngineer")
    public TResult allotEngineer(@PathVariable UUID id, @RequestBody AllotEngineerDto dto){
        dto.setPatentId(id);
        return patentService.allotEngineer(dto);
    }






}
