package crw.bishe.team.controller.bolg;

import com.baomidou.mybatisplus.core.metadata.IPage;
import crw.bishe.team.entity.bolg.BolgArticle;
import crw.bishe.team.service.bolg.IBolgArticleService;
import crw.bishe.team.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 博客表 前端控制器
 * </p>
 *
 * @author caorongwu
 * @since 2021-02-23
 */
@Api(tags = {"博客表"})
@RestController
@RequestMapping("//bolg-article")
public class BolgArticleController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IBolgArticleService bolgArticleService;


    @ApiOperation(value = "新增博客表")
    @PostMapping()
    public ResponseEntity<Result> add(@RequestBody BolgArticle bolgArticle){
        return new ResponseEntity<>(new Result<>(200, "success", bolgArticleService.add(bolgArticle)), HttpStatus.OK);
    }

    @ApiOperation(value = "删除博客表")
    @DeleteMapping("{id}")
    public ResponseEntity<Result> delete(@PathVariable("id") Long id){
        return new ResponseEntity<>(new Result<>(200, "success", bolgArticleService.delete(id)), HttpStatus.OK);
    }

    @ApiOperation(value = "更新博客表")
    @PutMapping()
    public ResponseEntity<Result> update(@RequestBody BolgArticle bolgArticle){
        return new ResponseEntity<>(new Result<>(200, "success", bolgArticleService.updateData(bolgArticle)), HttpStatus.OK);
    }

    @ApiOperation(value = "查询博客表分页数据")
    @GetMapping()
    public ResponseEntity<Result<IPage<BolgArticle>>> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return new ResponseEntity<>(new Result<>(200, "success", bolgArticleService.findListByPage(page, pageCount)), HttpStatus.OK);
    }

    @ApiOperation(value = "id查询博客表")
    @GetMapping("{id}")
    public ResponseEntity<Result<BolgArticle>> findById(@PathVariable Long id){
        return new ResponseEntity<>(new Result<>(200, "success", bolgArticleService.findById(id)), HttpStatus.OK);
    }

}
