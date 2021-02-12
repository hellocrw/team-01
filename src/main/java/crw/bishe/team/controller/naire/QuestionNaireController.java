package crw.bishe.team.controller.naire;

import com.baomidou.mybatisplus.core.metadata.IPage;
import crw.bishe.team.entity.naire.QuestionNaire;
import crw.bishe.team.service.naire.IQuestionNaireService;
import crw.bishe.team.vo.Result;
import crw.bishe.team.vo.StatisticsVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author caorongwu
 * @since 2021-02-10
 */
@Api(tags = {"聚会统计"})
@RestController
@RequestMapping("/api/question-naire")
public class QuestionNaireController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IQuestionNaireService questionNaireService;


    @ApiOperation(value = "新增")
    @PostMapping()
    public ResponseEntity<Result<Integer>> add(@RequestBody QuestionNaire questionNaire){
        return new ResponseEntity<>(new Result<>(200, "success", questionNaireService.add(questionNaire)), HttpStatus.OK);
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("{id}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<Result<Integer>> delete(@PathVariable("id") Long id){
        return new ResponseEntity<>(new Result<>(200, "success", questionNaireService.delete(id)), HttpStatus.OK);
    }

    @ApiOperation(value = "更新")
    @PutMapping()
    public ResponseEntity<Result<Integer>> update(@RequestBody QuestionNaire questionNaire){
        return new ResponseEntity<>(new Result<>(200, "success", questionNaireService.updateData(questionNaire)), HttpStatus.OK);
    }

    @ApiOperation(value = "查询分页数据")
    @GetMapping()
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<Result<IPage<QuestionNaire>>> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return new ResponseEntity<>(new Result<>(200, "success", questionNaireService.findListByPage(page, pageCount)), HttpStatus.OK);
    }

    @ApiOperation(value = "id查询")
    @GetMapping("{id}")
    public ResponseEntity<Result<QuestionNaire>> findById(@PathVariable Long id){
        return new ResponseEntity<>(new Result<>(200, "success", questionNaireService.findById(id)), HttpStatus.OK);
    }

    @ApiOperation(value = "统计")
    @GetMapping("/statistics")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<Result<StatisticsVo>> statistics(){
        return new ResponseEntity<>(new Result<>(200, "success", questionNaireService.statistics()), HttpStatus.OK);
    }

}
