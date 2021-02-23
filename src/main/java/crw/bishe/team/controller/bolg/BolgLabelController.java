package crw.bishe.team.controller.bolg;

import org.springframework.web.bind.annotation.*;
import crw.bishe.team.service.bolg.IBolgLabelService;
import crw.bishe.team.entity.bolg.BolgLabel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.http.ResponseEntity;
import crw.bishe.team.vo.Result;
import org.springframework.http.HttpStatus;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 标签表 前端控制器
 * </p>
 *
 * @author caorongwu
 * @since 2021-02-23
 */
@Api(tags = {"标签表"})
@RestController
@RequestMapping("//bolg-label")
public class BolgLabelController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IBolgLabelService bolgLabelService;


    @ApiOperation(value = "新增标签表")
    @PostMapping()
    public ResponseEntity<Result> add(@RequestBody BolgLabel bolgLabel){
        return new ResponseEntity<>(new Result<>(200, "success", bolgLabelService.add(bolgLabel)), HttpStatus.OK);
    }

    @ApiOperation(value = "删除标签表")
    @DeleteMapping("{id}")
    public ResponseEntity<Result> delete(@PathVariable("id") Long id){
        return new ResponseEntity<>(new Result<>(200, "success", bolgLabelService.delete(id)), HttpStatus.OK);
    }

    @ApiOperation(value = "更新标签表")
    @PutMapping()
    public ResponseEntity<Result> update(@RequestBody BolgLabel bolgLabel){
        return new ResponseEntity<>(new Result<>(200, "success", bolgLabelService.updateData(bolgLabel)), HttpStatus.OK);
    }

    @ApiOperation(value = "查询标签表分页数据")
    @GetMapping()
    public ResponseEntity<Result<IPage<BolgLabel>>> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return new ResponseEntity<>(new Result<>(200, "success", bolgLabelService.findListByPage(page, pageCount)), HttpStatus.OK);
    }

    @ApiOperation(value = "id查询标签表")
    @GetMapping("{id}")
    public ResponseEntity<Result<BolgLabel>> findById(@PathVariable Long id){
        return new ResponseEntity<>(new Result<>(200, "success", bolgLabelService.findById(id)), HttpStatus.OK);
    }

}
