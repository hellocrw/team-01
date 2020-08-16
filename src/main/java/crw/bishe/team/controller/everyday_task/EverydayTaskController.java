package crw.bishe.team.controller.everyday_task;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import crw.bishe.team.service.everyday_task.IEverydayTaskService;
import crw.bishe.team.entity.everyday_task.EverydayTask;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.core.metadata.IPage;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author caorongwu
 * @since 2020-08-17
 */
@Api(tags = {""})
@RestController
@RequestMapping("//everyday-task")
public class EverydayTaskController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IEverydayTaskService everydayTaskService;


    @ApiOperation(value = "新增")
    @PostMapping()
    public int add(@RequestBody EverydayTask everydayTask){
        return everydayTaskService.add(everydayTask);
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return everydayTaskService.delete(id);
    }

    @ApiOperation(value = "更新")
    @PutMapping()
    public int update(@RequestBody EverydayTask everydayTask){
        return everydayTaskService.updateData(everydayTask);
    }

    @ApiOperation(value = "查询分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<EverydayTask> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return everydayTaskService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询")
    @GetMapping("{id}")
    public EverydayTask findById(@PathVariable Long id){
        return everydayTaskService.findById(id);
    }

}
