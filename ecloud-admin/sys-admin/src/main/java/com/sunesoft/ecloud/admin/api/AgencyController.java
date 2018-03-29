package com.sunesoft.ecloud.admin.api;

import com.sunesoft.ecloud.admin.query.AgencyQueryService;
import com.sunesoft.ecloud.admin.service.AgencyService;
import com.sunesoft.ecloud.adminclient.cretirias.AgencyCriteria;
import com.sunesoft.ecloud.adminclient.dtos.AgencyBasicDto;
import com.sunesoft.ecloud.adminclient.dtos.AgencyDto;
import com.sunesoft.ecloud.common.result.TResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController("/agency")
public class AgencyController {
    @Autowired
    AgencyService agencyService;

    @Autowired
    AgencyQueryService agencyQueryService;

    /**
     * 企业查询
     * @param agencyCriteria
     */
    @GetMapping("search")
    @ResponseBody
    public Page<AgencyDto> search (@RequestBody AgencyCriteria agencyCriteria) {
        return agencyQueryService.findAgencyPaged(agencyCriteria);
    }

    /**
     * 企业信息获取(企业管理)
     * @param id
     * @return
     */
    @GetMapping("basic/{id}")
    @ResponseBody
    public TResult<AgencyBasicDto> getBasicInfo (@PathVariable UUID id) {
        return agencyQueryService.findAgencyBasicInfoById(id);
    }

    /**
     * 修改企业信息（企业管理）
     * @param agencyBasicDto
     * @param id
     * @return
     */
    @PutMapping("basic/{id}")
    @ResponseBody
    public TResult updateBasicInfo (@RequestBody AgencyBasicDto agencyBasicDto, @PathVariable UUID id) {
        agencyBasicDto.setId(id);
        return agencyService.updateAgencyBasicInfo(agencyBasicDto);
    }

    /**
     * 获取企业信息
     * @param id
     * @return
     */
    @GetMapping("{id}")
    @ResponseBody
    public TResult getInfo (@PathVariable UUID id) {
        return agencyQueryService.findAgencyDetailInfoById(id);
    }

    /**
     * 新增企业信息
     * @param agencyDto
     * @return
     */
    @PostMapping("")
    @ResponseBody
    public TResult addInfo (@RequestBody AgencyDto agencyDto) {
        return agencyService.addOrUpdateAgency(agencyDto);
    }

    /**
     * 修改企业信息
     * @param agencyDto
     * @param id
     * @return
     */
    @PutMapping("{id}")
    @ResponseBody
    public TResult updateInfo (@RequestBody AgencyDto agencyDto, @PathVariable UUID id) {
        agencyDto.setId(id);
        return agencyService.addOrUpdateAgency(agencyDto);
    }


    /**
     * 删除企业
     * @param ids
     * @return
     */
    @DeleteMapping()
    @ResponseBody
    public TResult delete (@RequestParam UUID... ids) {
        return agencyService.deleteBatch(ids);
    }

}
