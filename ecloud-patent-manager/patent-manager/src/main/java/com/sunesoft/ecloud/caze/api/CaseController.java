package com.sunesoft.ecloud.caze.api;


import com.sunesoft.ecloud.auth.UserContext;
import com.sunesoft.ecloud.caseclient.criterias.CaseInfoQueryCriteria;
import com.sunesoft.ecloud.caseclient.dto.CaseCustomerRequestDto;
import com.sunesoft.ecloud.caseclient.dto.CaseInfoColumnConfigureDto;
import com.sunesoft.ecloud.caseclient.dto.CaseInfoDto;
import com.sunesoft.ecloud.caseclient.dto.CaseInfoListDto;
import com.sunesoft.ecloud.caze.query.CaseQueryService;
import com.sunesoft.ecloud.caze.service.CaseService;
import com.sunesoft.ecloud.common.cretiria.TCretiria;
import com.sunesoft.ecloud.common.result.PagedResult;
import com.sunesoft.ecloud.common.result.TResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.UUID;

/**
 * Created by wangguangyang on 2018/4/17.
 */
@RestController
@RequestMapping("/caseManager")
public class CaseController {
    @Autowired
    CaseQueryService caseQueryService;
    @Autowired
    CaseService caseService;
    UUID agID=UUID.fromString("01d134d6-3eef-4b60-9979-c6392554da25");
    UUID userID=UUID.fromString("fc98e1ca-92f0-4f2e-b68c-f0129978c1bf");

    /**
     * 查询案件列表
     * @param criteria
     * @return
     */
    @GetMapping("search")
    public PagedResult<CaseInfoListDto> search(CaseInfoQueryCriteria criteria){
        criteria.setAgId(agID);
        return caseQueryService.queryCaseInfoByPaged(criteria);
    }

    /**
     * 查询案件详情
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public TResult<CaseInfoListDto> getInfo(@PathVariable UUID id){
        return caseQueryService.queryCaseBasicInfoById(id);
    }

    /**
     * 查询案件对应客户要求
     * @param id
     * @param criteria
     * @return
     */
    @GetMapping("{id}/customerRequest")
    public PagedResult<CaseCustomerRequestDto> getCustomerRequest(@PathVariable UUID id,TCretiria criteria){
        return caseQueryService.queryCaseCustomerRequestByPaged(id,criteria);
    }

    /**
     * 查询用户配置项
     * @return
     */
    @GetMapping("config")
    public TResult<CaseInfoColumnConfigureDto> getConfig(){
        return caseQueryService.queryUserCaseInfoColumnConfigure(userID);
    }

    /**
     * 设置用户配置项
     * @param dto
     * @return
     */
    @PostMapping("config")
    public TResult setConfig(@RequestBody CaseInfoColumnConfigureDto dto){
        dto.setUserId(userID);
        return caseService.configureCaseQueryColumn(dto);
    }

    /**
     * 新增案件
     * @param dto
     * @return
     */
    @PostMapping("")
    public TResult addCase(@RequestBody CaseInfoDto dto){
        dto.setAgId(agID);
        dto.setCaseCreatorName("测试");
        return caseService.addOrUpdateCase(dto);
    }

    /**
     * 获取案件对应客户要求
     * @param cid
     * @param cretiria
     * @return
     */
    @GetMapping("{cid}/customerRequest")
    public PagedResult<CaseCustomerRequestDto> getCustomerRequestList(@PathVariable UUID cid,TCretiria cretiria){
        return caseQueryService.queryCaseCustomerRequestByPaged(cid,cretiria);
    }

}
