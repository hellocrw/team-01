package crw.bishe.team.controller.user;

import org.springframework.web.bind.annotation.*;
import crw.bishe.team.service.user.IBolgUserService;
import crw.bishe.team.entity.user.BolgUser;
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
 * 用户信息表 前端控制器
 * </p>
 *
 * @author caorongwu
 * @since 2021-02-27
 */
@Api(tags = {"用户信息表"})
@RestController
@RequestMapping("/user/bolg-user")
public class BolgUserController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IBolgUserService bolgUserService;


    @ApiOperation(value = "新增用户信息表")
    @PostMapping()
    public ResponseEntity<Result> add(@RequestBody BolgUser bolgUser){
        return new ResponseEntity<>(new Result<>(200, "success", bolgUserService.add(bolgUser)), HttpStatus.OK);
    }

    @ApiOperation(value = "删除用户信息表")
    @DeleteMapping("{id}")
    public ResponseEntity<Result> delete(@PathVariable("id") Long id){
        return new ResponseEntity<>(new Result<>(200, "success", bolgUserService.delete(id)), HttpStatus.OK);
    }

    @ApiOperation(value = "更新用户信息表")
    @PutMapping()
    public ResponseEntity<Result> update(@RequestBody BolgUser bolgUser){
        return new ResponseEntity<>(new Result<>(200, "success", bolgUserService.updateData(bolgUser)), HttpStatus.OK);
    }

    @ApiOperation(value = "查询用户信息表分页数据")
    @GetMapping()
    public ResponseEntity<Result<IPage<BolgUser>>> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return new ResponseEntity<>(new Result<>(200, "success", bolgUserService.findListByPage(page, pageCount)), HttpStatus.OK);
    }

    @ApiOperation(value = "id查询用户信息表")
    @GetMapping("{id}")
    public ResponseEntity<Result<BolgUser>> findById(@PathVariable Long id){
        return new ResponseEntity<>(new Result<>(200, "success", bolgUserService.findById(id)), HttpStatus.OK);
    }

}
