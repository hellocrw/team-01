package crw.bishe.team.controller.auth;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import crw.bishe.team.service.auth.IAuthUserService;
import crw.bishe.team.entity.auth.AuthUser;
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
@Api(tags = {"用户控制器"})
@RestController
@RequestMapping("/auth-user")
public class AuthUserController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IAuthUserService authUserService;


    @ApiOperation(value = "新增 ")
    @PostMapping()
    public int add(@RequestBody AuthUser authUser){
        return authUserService.add(authUser);
    }

    @ApiOperation(value = "删除 ")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return authUserService.delete(id);
    }

    @ApiOperation(value = "更新 ")
    @PutMapping()
    public int update(@RequestBody AuthUser authUser){
        return authUserService.updateData(authUser);
    }

    @ApiOperation(value = "查询 分页数据")
    @GetMapping()
    public IPage<AuthUser> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return authUserService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询 ")
    @GetMapping("{id}")
    public AuthUser findById(@PathVariable Long id){
        return authUserService.findById(id);
    }

}
