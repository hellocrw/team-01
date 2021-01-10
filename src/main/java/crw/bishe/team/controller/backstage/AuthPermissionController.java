package crw.bishe.team.controller.backstage;

import com.baomidou.mybatisplus.core.metadata.IPage;
import crw.bishe.team.entity.auth.AuthPermission;
import crw.bishe.team.service.auth.IAuthPermissionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 *   前端控制器
 * </p>
 *
 * @author caorongwu
 * @since 2021-01-10
 */
@Api(tags = {"权限控制器"})
@RestController
@RequestMapping("/auth-permission")
public class AuthPermissionController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IAuthPermissionService authPermissionService;


    @ApiOperation(value = "新增 ")
    @PostMapping()
    public int add(@RequestBody AuthPermission authPermission){
        return authPermissionService.add(authPermission);
    }

    @ApiOperation(value = "删除 ")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return authPermissionService.delete(id);
    }

    @ApiOperation(value = "更新 ")
    @PutMapping()
    public int update(@RequestBody AuthPermission authPermission){
        return authPermissionService.updateData(authPermission);
    }

    @ApiOperation(value = "查询 分页数据")
    @GetMapping()
    public IPage<AuthPermission> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return authPermissionService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询 ")
    @GetMapping("{id}")
    public AuthPermission findById(@PathVariable Long id){
        return authPermissionService.findById(id);
    }

}
