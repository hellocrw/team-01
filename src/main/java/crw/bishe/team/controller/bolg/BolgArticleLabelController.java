package crw.bishe.team.controller.bolg;

import org.springframework.web.bind.annotation.*;
import crw.bishe.team.service.bolg.IBolgArticleLabelService;
import crw.bishe.team.entity.bolg.BolgArticleLabel;
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
 * 博客标签关联表 前端控制器
 * </p>
 *
 * @author caorongwu
 * @since 2021-02-24
 */
@Api(tags = {"博客标签关联表"})
@RestController
@RequestMapping("/bolg/bolg-article-label")
public class BolgArticleLabelController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IBolgArticleLabelService bolgArticleLabelService;


    @ApiOperation(value = "新增博客标签关联表")
    @PostMapping()
    public ResponseEntity<Result> add(@RequestBody BolgArticleLabel bolgArticleLabel){
        return new ResponseEntity<>(new Result<>(200, "success", bolgArticleLabelService.add(bolgArticleLabel)), HttpStatus.OK);
    }

    @ApiOperation(value = "删除博客标签关联表")
    @DeleteMapping("{id}")
    public ResponseEntity<Result> delete(@PathVariable("id") Long id){
        return new ResponseEntity<>(new Result<>(200, "success", bolgArticleLabelService.delete(id)), HttpStatus.OK);
    }

    @ApiOperation(value = "更新博客标签关联表")
    @PutMapping()
    public ResponseEntity<Result> update(@RequestBody BolgArticleLabel bolgArticleLabel){
        return new ResponseEntity<>(new Result<>(200, "success", bolgArticleLabelService.updateData(bolgArticleLabel)), HttpStatus.OK);
    }

    @ApiOperation(value = "查询博客标签关联表分页数据")
    @GetMapping()
    public ResponseEntity<Result<IPage<BolgArticleLabel>>> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return new ResponseEntity<>(new Result<>(200, "success", bolgArticleLabelService.findListByPage(page, pageCount)), HttpStatus.OK);
    }

    @ApiOperation(value = "id查询博客标签关联表")
    @GetMapping("{id}")
    public ResponseEntity<Result<BolgArticleLabel>> findById(@PathVariable Long id){
        return new ResponseEntity<>(new Result<>(200, "success", bolgArticleLabelService.findById(id)), HttpStatus.OK);
    }

}
