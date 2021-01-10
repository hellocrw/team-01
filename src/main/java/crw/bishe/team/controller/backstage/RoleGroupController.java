package crw.bishe.team.controller.backstage;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import crw.bishe.team.service.auth.IRoleGroupService;
import crw.bishe.team.entity.auth.RoleGroup;
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
@Api(tags = {"角色组控制器"})
@RestController
@RequestMapping("/role-group")
public class RoleGroupController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IRoleGroupService roleGroupService;


    @ApiOperation(value = "新增 ")
    @PostMapping()
    public int add(@RequestBody RoleGroup roleGroup){
        return roleGroupService.add(roleGroup);
    }

    @ApiOperation(value = "删除 ")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return roleGroupService.delete(id);
    }

    @ApiOperation(value = "更新 ")
    @PutMapping()
    public int update(@RequestBody RoleGroup roleGroup){
        return roleGroupService.updateData(roleGroup);
    }

    @ApiOperation(value = "查询 分页数据")
    @GetMapping()
    public IPage<RoleGroup> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return roleGroupService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询 ")
    @GetMapping("{id}")
    public RoleGroup findById(@PathVariable Long id){
        return roleGroupService.findById(id);
    }

}
