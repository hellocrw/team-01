package crw.bishe.team.controller.bolg;

import org.springframework.web.bind.annotation.*;
import crw.bishe.team.service.bolg.IBolgArticleSortService;
import crw.bishe.team.entity.bolg.BolgArticleSort;
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
 * 博客分类关联表 前端控制器
 * </p>
 *
 * @author caorongwu
 * @since 2021-02-24
 */
@Api(tags = {"博客分类关联表"})
@RestController
@RequestMapping("/bolg/bolg-article-sort")
public class BolgArticleSortController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IBolgArticleSortService bolgArticleSortService;


    @ApiOperation(value = "新增博客分类关联表")
    @PostMapping()
    public ResponseEntity<Result> add(@RequestBody BolgArticleSort bolgArticleSort){
        return new ResponseEntity<>(new Result<>(200, "success", bolgArticleSortService.add(bolgArticleSort)), HttpStatus.OK);
    }

    @ApiOperation(value = "删除博客分类关联表")
    @DeleteMapping("{id}")
    public ResponseEntity<Result> delete(@PathVariable("id") Long id){
        return new ResponseEntity<>(new Result<>(200, "success", bolgArticleSortService.delete(id)), HttpStatus.OK);
    }

    @ApiOperation(value = "更新博客分类关联表")
    @PutMapping()
    public ResponseEntity<Result> update(@RequestBody BolgArticleSort bolgArticleSort){
        return new ResponseEntity<>(new Result<>(200, "success", bolgArticleSortService.updateData(bolgArticleSort)), HttpStatus.OK);
    }

    @ApiOperation(value = "查询博客分类关联表分页数据")
    @GetMapping()
    public ResponseEntity<Result<IPage<BolgArticleSort>>> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return new ResponseEntity<>(new Result<>(200, "success", bolgArticleSortService.findListByPage(page, pageCount)), HttpStatus.OK);
    }

    @ApiOperation(value = "id查询博客分类关联表")
    @GetMapping("{id}")
    public ResponseEntity<Result<BolgArticleSort>> findById(@PathVariable Long id){
        return new ResponseEntity<>(new Result<>(200, "success", bolgArticleSortService.findById(id)), HttpStatus.OK);
    }

}
