package com.sunesoft.ecloud.admin.api;

import com.sunesoft.ecloud.admin.query.MenuFunctionQueryService;
import com.sunesoft.ecloud.admin.query.MenuQueryService;
import com.sunesoft.ecloud.admin.service.MenuFunctionService;
import com.sunesoft.ecloud.admin.service.MenuService;
import com.sunesoft.ecloud.adminclient.dtos.MenuDto;
import com.sunesoft.ecloud.adminclient.dtos.MenuFunctionDto;
import com.sunesoft.ecloud.adminclient.dtos.MenuSimpleDto;
import com.sunesoft.ecloud.common.result.ListResult;
import com.sunesoft.ecloud.common.result.TResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    MenuQueryService menuQueryService;

    @Autowired
    MenuService menuService;

    @Autowired
    MenuFunctionQueryService functionQueryService;

    @Autowired
    MenuFunctionService menuFunctionService;

    /**
     * 菜单查询
     * @return
     */
    @GetMapping("search")
    public ListResult<MenuSimpleDto> search () {
        return menuQueryService.findAllSimpleMenu();
    }

    /**
     * 菜单详情
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public TResult<MenuDto> getInfo (@PathVariable UUID id) {
        return menuQueryService.findMenuByID(id);
    }

    /**
     * 新增菜单信息
     * @param menuDto
     * @return
     */
    @PostMapping("")
    public TResult addInfo (@RequestBody MenuDto menuDto) {
       return menuService.addOrUpdateMenu(menuDto);
    }

    /**
     * 修改菜单信息
     * @param id
     * @param menuDto
     * @return
     */
    @PutMapping("{id}")
    public TResult updateInfo (@PathVariable UUID id, @RequestBody MenuDto menuDto) {
        menuDto.setId(id);
        return menuService.addOrUpdateMenu(menuDto);
    }

    /**
     * 删除菜单
     * @param id
     * @return
     */
    @DeleteMapping("{id}")
    public TResult delete (@PathVariable UUID id) {
        return menuService.delete(id);
    }

    /**
     * 获取菜单操作功能
     * @param id
     */
    @GetMapping("{id}/function")
    public ListResult<MenuFunctionDto> searchFunction (@PathVariable UUID id) {
        return functionQueryService.queryMenuFunction(id);
    }

    /**
     * 新增菜单功能
     * @param menuFunctionDto
     * @param mid
     * @return
     */
    @PostMapping("{mid}/function")
    public TResult addFunction (@RequestBody MenuFunctionDto menuFunctionDto, @PathVariable UUID mid) {
        return menuFunctionService.addOrUpdateFunction(menuFunctionDto, mid);
    }

    /**
     * 修改菜单功能
     * @param menuFunctionDto
     * @param mid
     * @param fid
     * @return
     */
    @PutMapping("{mid}/function/{fid}")
    public TResult updateFunction (@RequestBody MenuFunctionDto menuFunctionDto,
                                   @PathVariable UUID mid,
                                   @PathVariable UUID fid) {
        menuFunctionDto.setId(fid);
        return menuFunctionService.addOrUpdateFunction(menuFunctionDto, mid);
    }

    /**
     * 删除菜单功能
     * @param ids
     * @return
     */
    @DeleteMapping("{id}/function")
    public TResult delFunction (@PathVariable UUID id, @RequestParam List<UUID> ids) {
        return menuFunctionService.delete(ids);
    }
}
