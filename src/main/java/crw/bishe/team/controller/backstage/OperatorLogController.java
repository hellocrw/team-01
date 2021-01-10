package crw.bishe.team.controller.backstage;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import crw.bishe.team.service.auth.IOperatorLogService;
import crw.bishe.team.entity.auth.OperatorLog;
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
@Api(tags = {"操作日志控制器"})
@RestController
@RequestMapping("/operator-log")
public class OperatorLogController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IOperatorLogService operatorLogService;


    @ApiOperation(value = "新增 ")
    @PostMapping()
    public int add(@RequestBody OperatorLog operatorLog){
        return operatorLogService.add(operatorLog);
    }

    @ApiOperation(value = "删除 ")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return operatorLogService.delete(id);
    }

    @ApiOperation(value = "更新 ")
    @PutMapping()
    public int update(@RequestBody OperatorLog operatorLog){
        return operatorLogService.updateData(operatorLog);
    }

    @ApiOperation(value = "查询 分页数据")
    @GetMapping()
    public IPage<OperatorLog> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return operatorLogService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询 ")
    @GetMapping("{id}")
    public OperatorLog findById(@PathVariable Long id){
        return operatorLogService.findById(id);
    }

}
