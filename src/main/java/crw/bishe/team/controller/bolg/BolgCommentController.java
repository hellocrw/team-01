package crw.bishe.team.controller.bolg;

import org.springframework.web.bind.annotation.*;
import crw.bishe.team.service.bolg.IBolgCommentService;
import crw.bishe.team.entity.bolg.BolgComment;
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
 * 评论表 前端控制器
 * </p>
 *
 * @author caorongwu
 * @since 2021-02-24
 */
@Api(tags = {"评论表"})
@RestController
@RequestMapping("/bolg/bolg-comment")
public class BolgCommentController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IBolgCommentService bolgCommentService;


    @ApiOperation(value = "新增评论表")
    @PostMapping()
    public ResponseEntity<Result> add(@RequestBody BolgComment bolgComment){
        return new ResponseEntity<>(new Result<>(200, "success", bolgCommentService.add(bolgComment)), HttpStatus.OK);
    }

    @ApiOperation(value = "删除评论表")
    @DeleteMapping("{id}")
    public ResponseEntity<Result> delete(@PathVariable("id") Long id){
        return new ResponseEntity<>(new Result<>(200, "success", bolgCommentService.delete(id)), HttpStatus.OK);
    }

    @ApiOperation(value = "更新评论表")
    @PutMapping()
    public ResponseEntity<Result> update(@RequestBody BolgComment bolgComment){
        return new ResponseEntity<>(new Result<>(200, "success", bolgCommentService.updateData(bolgComment)), HttpStatus.OK);
    }

    @ApiOperation(value = "查询评论表分页数据")
    @GetMapping()
    public ResponseEntity<Result<IPage<BolgComment>>> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return new ResponseEntity<>(new Result<>(200, "success", bolgCommentService.findListByPage(page, pageCount)), HttpStatus.OK);
    }

    @ApiOperation(value = "id查询评论表")
    @GetMapping("{id}")
    public ResponseEntity<Result<BolgComment>> findById(@PathVariable Long id){
        return new ResponseEntity<>(new Result<>(200, "success", bolgCommentService.findById(id)), HttpStatus.OK);
    }

}
