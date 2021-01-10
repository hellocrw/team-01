package crw.bishe.team.controller.backstage;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import crw.bishe.team.service.auth.IUserGroupService;
import crw.bishe.team.entity.auth.UserGroup;
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
@Api(tags = {"用户组控制器"})
@RestController
@RequestMapping("/user-group")
public class UserGroupController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IUserGroupService userGroupService;


    @ApiOperation(value = "新增 ")
    @PostMapping()
    public int add(@RequestBody UserGroup userGroup){
        return userGroupService.add(userGroup);
    }

    @ApiOperation(value = "删除 ")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return userGroupService.delete(id);
    }

    @ApiOperation(value = "更新 ")
    @PutMapping()
    public int update(@RequestBody UserGroup userGroup){
        return userGroupService.updateData(userGroup);
    }

    @ApiOperation(value = "查询 分页数据")
    @GetMapping()
    public IPage<UserGroup> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return userGroupService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询 ")
    @GetMapping("{id}")
    public UserGroup findById(@PathVariable Long id){
        return userGroupService.findById(id);
    }

}
