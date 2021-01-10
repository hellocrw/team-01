package crw.bishe.team.controller.auth;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import crw.bishe.team.service.auth.IAuthRoleService;
import crw.bishe.team.entity.auth.AuthRole;
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
@Api(tags = {"角色控制器"})
@RestController
@RequestMapping("/auth-role")
public class AuthRoleController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IAuthRoleService authRoleService;


    @ApiOperation(value = "新增 ")
    @PostMapping()
    public int add(@RequestBody AuthRole authRole){
        return authRoleService.add(authRole);
    }

    @ApiOperation(value = "删除 ")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return authRoleService.delete(id);
    }

    @ApiOperation(value = "更新 ")
    @PutMapping()
    public int update(@RequestBody AuthRole authRole){
        return authRoleService.updateData(authRole);
    }

    @ApiOperation(value = "查询 分页数据")
    @GetMapping()
    public IPage<AuthRole> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return authRoleService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询 ")
    @GetMapping("{id}")
    public AuthRole findById(@PathVariable Long id){
        return authRoleService.findById(id);
    }

}
