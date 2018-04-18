package com.sunesoft.ecloud.caze.api;


import com.sunesoft.ecloud.adminclient.clientService.UserServiceClient;
import com.sunesoft.ecloud.adminclient.dtos.UserDto;
import com.sunesoft.ecloud.auth.UserContext;
import com.sunesoft.ecloud.caseclient.criterias.CaseInfoQueryCriteria;
import com.sunesoft.ecloud.caseclient.dto.*;
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
    @Autowired
    UserServiceClient userServiceClient;

    /**
     * 查询案件列表
     * @param criteria
     * @return
     */
    @GetMapping("search")
    public PagedResult<CaseInfoListDto> search(CaseInfoQueryCriteria criteria){
        UUID agId = UUID.fromString(UserContext.getAgencyId());
        criteria.setAgId(agId);
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
     * 删除案件
     * @param ids
     * @return
     */
    @DeleteMapping("")
    public TResult deleteCase(@RequestParam UUID... ids){
        return caseService.deleteCase(ids);
    }



    /**
     * 查询用户配置项
     * @return
     */
    @GetMapping("config")
    public TResult<CaseInfoColumnConfigureDto> getConfig(){
        UUID userID = UUID.fromString(UserContext.getUserID());
        return caseQueryService.queryUserCaseInfoColumnConfigure(userID);
    }

    /**
     * 设置用户配置项
     * @param dto
     * @return
     */
    @PostMapping("config")
    public TResult setConfig(@RequestBody CaseInfoColumnConfigureDto dto){
        UUID userID = UUID.fromString(UserContext.getUserID());
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
        UUID agId = UUID.fromString(UserContext.getAgencyId());
        dto.setAgId(agId);
        dto.setCaseCreatorName(UserContext.getRealName());
        return caseService.addOrUpdateCase(dto);
    }

    /**
     * 更新案件信息
     * @param cid
     * @return
     */
    @PutMapping("{cid}")
    public TResult updateCase(@PathVariable UUID cid,@RequestBody CaseInfoDto dto){
        return caseService.addOrUpdateCase(dto);
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
     * 新增客户要求
     * @param cid
     * @param dto
     * @return
     */
    @PostMapping("{cid}/customerRequest")
    public TResult addCustomerRequest(@PathVariable UUID cid,@RequestBody CaseCustomerRequestDto dto){
        dto.setCaseId(cid);
        return caseService.addOrUpdateCaseCustomerRequest(dto);
    }

    /**
     * 更新客户要求
     * @param cid
     * @param dto
     * @return
     */
    @PutMapping("{cid}/customerRequest/{id}")
    public TResult updateCustomerRequest(@PathVariable UUID cid,@PathVariable UUID id,@RequestBody CaseCustomerRequestDto dto){
        dto.setCaseId(cid);
        return caseService.addOrUpdateCaseCustomerRequest(dto);
    }

    /**
     * 删除客户要求
     * @param ids
     * @return
     */
    @DeleteMapping("customerRequest")
    public TResult deleteCustomerRequest(@RequestParam UUID... ids){
        return caseService.deleteCaseCustomerRequest(ids);
    }

    /**
     * 创建留言
     * @param dto
     * @return
     */
    @PostMapping("{cid}/caseMessage")
    public TResult createCaseMessage(@PathVariable UUID cid,CaseMessageDto dto){
        dto.setCaseId(cid);
        UUID userID = UUID.fromString(UserContext.getUserID());
        dto.setMessagerId(userID);
        TResult<UserDto> result = userServiceClient.getUserRealNameAndRoleName(userID);
        UserDto userDto=result.getResult();
        dto.setMessagerRoleName(userDto.getRoleName());
        dto.setMessagerRealName(userDto.getRealName());
        return caseService.addOrUpdateCaseMessage(dto);
    }

    /**
     * 查询案件留言列表
     * @param cid
     * @param criteria
     * @return
     */
    @GetMapping("{cid}/caseMessage")
    public PagedResult<CaseMessageListDto> getCaseMessage(@PathVariable UUID cid,TCretiria criteria){
        return caseQueryService.queryCaseMessageByPaged(cid,criteria);
    }




}
