package crw.bishe.team.controller.project;

import crw.bishe.team.dto.ApplyDto;
import crw.bishe.team.service.ApplyService;
import crw.bishe.team.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description Description 申请表管理
 * @Author crw
 * @Date Created in 2020/2/4 0004
 * @Time 0:49
 */
@Api(tags = {"申请表管理"})
@RestController
@RequestMapping("/api/apply")
public class ApplyController {

    @Autowired
    private ApplyService applyService;

    @PostMapping("/create")
    public ResponseEntity<Result> create(@ApiParam(value = "申请表信息") @RequestBody ApplyDto applyDto){
        Integer res = applyService.create(applyDto);
        return new ResponseEntity<>(new Result(200, "增加申请表成功"), HttpStatus.OK);
    }

    @GetMapping("/getApplyByUserId/{userId}")
    public ResponseEntity<Result> getApplyByUserId( @PathVariable(name = "userId") String userId){
        List<ApplyDto> applyDtos = applyService.getApplyByUserId(userId);
        return new ResponseEntity<>(new Result(200, "OK", applyDtos), HttpStatus.OK);
    }

    @GetMapping("/getEnqueueApply/{userId}")
    public ResponseEntity<Result> getEnqueueApply(@PathVariable(name = "userId") String userId){
        List<ApplyDto> applyDtos = applyService.getEnqueueApply(userId);
        return new ResponseEntity<>(new Result(200, "OK", applyDtos), HttpStatus.OK);
    }
}
