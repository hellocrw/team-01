package crw.bishe.team.controller.project;

import crw.bishe.team.dto.UserTeamDto;
import crw.bishe.team.service.UserTeamService;
import crw.bishe.team.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = {"用户-团队管理"})
@RequestMapping("/api/user_team")
@RestController
@Log4j2
public class UserTeamController {

    @Autowired
    private UserTeamService userTeamService;

    @ApiOperation(value = "通过团队ID获取用户信息")
    @GetMapping("/getUserByTeamId/{teamId}")
    public ResponseEntity<Result> getUserByTeamId(@PathVariable(name = "teamId") String teamId){
        List<UserTeamDto> userTeamDtos = userTeamService.getUserByTeamId(teamId);
        return new ResponseEntity<>(new Result(200, "OK", userTeamDtos), HttpStatus.OK);
    }

    @ApiOperation(value = "保存关联信息")
    @PostMapping("/save")
    public ResponseEntity<Result> save(@RequestBody @Validated UserTeamDto userTeamDto){
        userTeamService.create(userTeamDto);
        return new ResponseEntity<>(new Result(200, "OK"), HttpStatus.OK);
    }

    @ApiOperation( value = "踢出成员")
    @DeleteMapping("/{utId}")
    public ResponseEntity<Result> deleteByUtId(@PathVariable(name = "utId") String utId){
        userTeamService.deleteByUtId(utId);
        return new ResponseEntity<>(new Result(200, "OK"), HttpStatus.OK);
    }

    @GetMapping("/existInTeam/{userId}/{teamId}")
    public ResponseEntity<Result> existInTeam(@PathVariable(name = "userId")String userId,
                                              @PathVariable(name = "teamId") String teamId){
        Integer res = userTeamService.existInTeam(userId, teamId);
        if(res <= 0){
            return new ResponseEntity<>(new Result(200, "无法访问", res), HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity<>(new Result(200, "OK", res), HttpStatus.OK);
    }
}
