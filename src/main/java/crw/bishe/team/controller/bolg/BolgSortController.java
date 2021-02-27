package crw.bishe.team.controller.bolg;

import crw.bishe.team.vo.bolg.SortActicleVo;
import org.springframework.web.bind.annotation.*;
import crw.bishe.team.service.bolg.IBolgSortService;
import crw.bishe.team.entity.bolg.BolgSort;
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

import java.util.List;

/**
 * <p>
 * 分类表 前端控制器
 * </p>
 *
 * @author caorongwu
 * @since 2021-02-24
 */
@Api(tags = {"分类表"})
@RestController
@RequestMapping("/bolg/bolg-sort")
public class BolgSortController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IBolgSortService bolgSortService;


    @ApiOperation(value = "新增分类表")
    @PostMapping()
    public ResponseEntity<Result> add(@RequestBody BolgSort bolgSort){
        return new ResponseEntity<>(new Result<>(200, "success", bolgSortService.add(bolgSort)), HttpStatus.OK);
    }

    @ApiOperation(value = "删除分类表")
    @DeleteMapping("{id}")
    public ResponseEntity<Result> delete(@PathVariable("id") Long id){
        return new ResponseEntity<>(new Result<>(200, "success", bolgSortService.delete(id)), HttpStatus.OK);
    }

    @ApiOperation(value = "更新分类表")
    @PutMapping()
    public ResponseEntity<Result> update(@RequestBody BolgSort bolgSort){
        return new ResponseEntity<>(new Result<>(200, "success", bolgSortService.updateData(bolgSort)), HttpStatus.OK);
    }

    @ApiOperation(value = "查询分类表分页数据")
    @GetMapping()
    public ResponseEntity<Result<IPage<BolgSort>>> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return new ResponseEntity<>(new Result<>(200, "success", bolgSortService.findListByPage(page, pageCount)), HttpStatus.OK);
    }

    @ApiOperation(value = "id查询分类表")
    @GetMapping("{id}")
    public ResponseEntity<Result<BolgSort>> findById(@PathVariable Long id){
        return new ResponseEntity<>(new Result<>(200, "success", bolgSortService.findById(id)), HttpStatus.OK);
    }

    @ApiOperation(value = "查看分类名称及分类下的文章")
    @GetMapping("/querySortActicle")
    public ResponseEntity<Result<List<SortActicleVo>>> querySortActicle(){
        return new ResponseEntity<>(new Result(200, "success", bolgSortService.querySortActicle()), HttpStatus.OK);
    }

    @ApiOperation(value = "查询分类根目录")
    @GetMapping("/queryRootSort")
    public ResponseEntity<Result<List<BolgSort>>> queryRootSort(){
        return new ResponseEntity<>(new Result<>(20, "success", bolgSortService.queryRootSort()), HttpStatus.OK);
    }

}
