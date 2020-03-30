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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = {"公告管理"})
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

}
