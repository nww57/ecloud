package com.sunesoft.ecloud.admin.api;

import com.sunesoft.ecloud.admin.query.ParameterQueryService;
import com.sunesoft.ecloud.admin.query.ParameterTypeQueryService;
import com.sunesoft.ecloud.admin.service.ParameterService;
import com.sunesoft.ecloud.admin.service.ParameterTypeService;
import com.sunesoft.ecloud.adminclient.dtos.MenuDto;
import com.sunesoft.ecloud.adminclient.dtos.ParameterDto;
import com.sunesoft.ecloud.adminclient.dtos.ParameterTypeDto;
import com.sunesoft.ecloud.common.result.ListResult;
import com.sunesoft.ecloud.common.result.TResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * Created by wangguangyang on 2018/4/23.
 */
@RestController
@RequestMapping("/parameter")
public class ParameterController {

    @Autowired
    ParameterQueryService parameterQueryService;
    @Autowired
    ParameterTypeQueryService parameterTypeQueryService;
    @Autowired
    ParameterService parameterService;
    @Autowired
    ParameterTypeService parameterTypeService;

    /**
     * 获取所有字典
     * @return
     */
    @GetMapping("search")
    public ListResult<ParameterTypeDto> search () {
        return parameterTypeQueryService.queryAllParameterType();
    }

    /**
     * 获取字典详情
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public TResult<ParameterTypeDto> getInfo(@PathVariable UUID id){
        return parameterTypeQueryService.queryParameterTypeById(id);
    }

    /**
     * 新增数据字典
     * @param parameterTypeDto
     * @return
     */
    @PostMapping("")
    public TResult<ParameterTypeDto> addInfo(@RequestBody ParameterTypeDto parameterTypeDto){
        return parameterTypeService.addOrUpdate(parameterTypeDto);
    }

    /**
     * 更新数据字典
     * @param id
     * @param parameterTypeDto
     * @return
     */
    @PutMapping("{id}")
    TResult<ParameterTypeDto> updateInfo(@PathVariable UUID id,ParameterTypeDto parameterTypeDto){
        parameterTypeDto.setId(id);
        return parameterTypeService.addOrUpdate(parameterTypeDto);
    }

    /**
     * 删除数据字典
     * @param id
     * @return
     */
    @DeleteMapping("{id}")
    public TResult delete (@PathVariable UUID id) {
        return parameterTypeService.delete(id);
    }


    /**
     * 查询所选字典对应字典值
     * @param id
     * @return
     */
    @GetMapping("{id}/parameter")
    public ListResult<ParameterDto> searchParameter (@PathVariable UUID id) {
        return parameterQueryService.queryParameterByTypeId(id);
    }

    /**
     * 新增字典值
     * @param parameterDto
     * @param tid
     * @return
     */
    @PostMapping("{tid}/parameter")
    public TResult addParameter (@RequestBody ParameterDto parameterDto, @PathVariable UUID tid) {
        return parameterService.addOrUpdate(parameterDto, tid);
    }

    /**
     * 修改字典值
     * @param parameterDto
     * @param pid
     * @param tid
     * @return
     */
    @PutMapping("{tid}/parameter/{pid}")
    public TResult updateFunction (@RequestBody ParameterDto parameterDto,
                                   @PathVariable UUID tid,
                                   @PathVariable UUID pid) {
        parameterDto.setId(pid);
        return parameterService.addOrUpdate(parameterDto, tid);
    }

    /**
     * 删除字典值
     * @param id
     * @param ids
     * @return
     */
    @DeleteMapping("{id}/parameter")
    public TResult delFunction (@PathVariable UUID id, @RequestParam List<UUID> ids) {
        return parameterService.delete(ids);
    }


}
