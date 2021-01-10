package crw.bishe.team.controller.backstage;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import crw.bishe.team.service.auth.IPermissionGroupService;
import crw.bishe.team.entity.auth.PermissionGroup;
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
@Api(tags = {"权限组控制器"})
@RestController
@RequestMapping("/permission-group")
public class PermissionGroupController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IPermissionGroupService permissionGroupService;


    @ApiOperation(value = "新增 ")
    @PostMapping()
    public int add(@RequestBody PermissionGroup permissionGroup){
        return permissionGroupService.add(permissionGroup);
    }

    @ApiOperation(value = "删除 ")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return permissionGroupService.delete(id);
    }

    @ApiOperation(value = "更新 ")
    @PutMapping()
    public int update(@RequestBody PermissionGroup permissionGroup){
        return permissionGroupService.updateData(permissionGroup);
    }

    @ApiOperation(value = "查询 分页数据")
    @GetMapping()
    public IPage<PermissionGroup> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return permissionGroupService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询 ")
    @GetMapping("{id}")
    public PermissionGroup findById(@PathVariable Long id){
        return permissionGroupService.findById(id);
    }

}
