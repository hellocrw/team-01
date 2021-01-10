package crw.bishe.team.controller.auth;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import crw.bishe.team.service.auth.IRolePermissionService;
import crw.bishe.team.entity.auth.RolePermission;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.core.metadata.IPage;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *   前端控制器
 * </p>
 *
 * @author caorongwu
 * @since 2021-01-10
 */
@Api(tags = {"角色权限控制器"})
@RestController
@RequestMapping("/role-permission")
public class RolePermissionController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IRolePermissionService rolePermissionService;


    @ApiOperation(value = "新增 ")
    @PostMapping()
    public int add(@RequestBody RolePermission rolePermission){
        return rolePermissionService.add(rolePermission);
    }

    @ApiOperation(value = "删除 ")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return rolePermissionService.delete(id);
    }

    @ApiOperation(value = "更新 ")
    @PutMapping()
    public int update(@RequestBody RolePermission rolePermission){
        return rolePermissionService.updateData(rolePermission);
    }

    @ApiOperation(value = "查询 分页数据")
    @GetMapping()
    public IPage<RolePermission> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return rolePermissionService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询 ")
    @GetMapping("{id}")
    public RolePermission findById(@PathVariable Long id){
        return rolePermissionService.findById(id);
    }

}
