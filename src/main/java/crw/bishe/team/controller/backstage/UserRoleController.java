package crw.bishe.team.controller.backstage;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import crw.bishe.team.service.auth.IUserRoleService;
import crw.bishe.team.entity.auth.UserRole;
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
@Api(tags = {"用户角色控制器"})
@RestController
@RequestMapping("/user-role")
public class UserRoleController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IUserRoleService userRoleService;


    @ApiOperation(value = "新增 ")
    @PostMapping()
    public int add(@RequestBody UserRole userRole){
        return userRoleService.add(userRole);
    }

    @ApiOperation(value = "删除 ")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return userRoleService.delete(id);
    }

    @ApiOperation(value = "更新 ")
    @PutMapping()
    public int update(@RequestBody UserRole userRole){
        return userRoleService.updateData(userRole);
    }

    @ApiOperation(value = "查询 分页数据")
    @GetMapping()
    public IPage<UserRole> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return userRoleService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询 ")
    @GetMapping("{id}")
    public UserRole findById(@PathVariable Long id){
        return userRoleService.findById(id);
    }

}
