package crw.bishe.team.controller.project;

import crw.bishe.team.dto.*;
import crw.bishe.team.entity.Team;
import crw.bishe.team.service.TeamService;
import crw.bishe.team.service.TeamTypeService;
import crw.bishe.team.vo.PageRequest;
import crw.bishe.team.vo.PageResult;
import crw.bishe.team.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Map;

/**
 * @Description Description 团队管理
 * @Author crw
 * @Date Created in 2020/1/19 0019
 * @Time 15:13
 */
@Api(tags = {"团队管理"})
@RequestMapping("/api/team")
@RestController
@Log4j2
public class TeamController {

    private final TeamService teamService;
    private final TeamTypeService teamTypeService;

    @Autowired
    public TeamController(TeamService teamService, TeamTypeService teamTypeService){
        this.teamTypeService = teamTypeService;
        this.teamService = teamService;
    }

    @ApiOperation(value = "通过管理员ID获取团队信息")
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/getTeamByAdmin/{adminId}")
    public ResponseEntity<Result> getTeamByAdminId(@PathVariable(name = "adminId") String adminId){
        List<TeamDto> res = teamService.getTeamByAdminId(adminId);
        return new ResponseEntity<>(new Result(200, "OK", res),HttpStatus.OK);
    }

    @ApiOperation(value = "查找所有团队信息")
    @GetMapping("/all")
    public ResponseEntity<Result<TeamDto>> findAll(){
        List<TeamDto> teamDtos = teamService.findAll();
        return new ResponseEntity<>(new Result(200, "处理成功", teamDtos), HttpStatus.OK);
    }

    @ApiOperation(value = "新增团队信息")
    @PostMapping("")
    public ResponseEntity<Result> create(@ApiParam(value = "团队信息") @RequestBody @Validated TeamDto teamDto){
        int res = teamService.create(teamDto);
        if(res > 0){
            return new ResponseEntity<>(new Result(200, "处理成功"), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(new Result("处理失败"), HttpStatus.BAD_REQUEST);
        }
    }

    @ApiOperation(value = "修改团队信息")
    @PutMapping("/{id}")
    public ResponseEntity<Result> update(@ApiParam(value = "团队ID") @PathVariable(name = "id") String id ,
                                         @ApiParam(value = "团队信息") @RequestBody @Validated TeamDto teamDto){
        int res = teamService.update(teamDto, id);
        if(res > 0){
            return new ResponseEntity<>(new Result(200, "处理成功"), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(new Result("处理失败"), HttpStatus.BAD_REQUEST);
        }
    }

    @ApiOperation(value = "删除团队信息")
    @DeleteMapping("/{teamId}")
    public ResponseEntity<Result> delete(@ApiParam(value = "团队ID") @PathVariable(name = "teamId") String teamId){
        int res = teamService.delete(teamId);
        if(res > 0){
            return new ResponseEntity<>(new Result(200, "处理成功"), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(new Result("处理失败"), HttpStatus.BAD_REQUEST);
        }
    }

    @ApiOperation(value = "通过用户ID获取团队列表")
    @GetMapping("/getMyTeamList/{id}")
    public ResponseEntity<Result<List<MyTeamDto>>> getMyTeamList(@PathVariable(name = "id") String id){
        List<MyTeamDto> res = teamService.getMyTeamList(id);
        return new ResponseEntity<>(new Result<>(200,"处理成功",res), HttpStatus.OK);
    }

    @ApiOperation(value = "通过团队ID获取团队成员")
    @GetMapping("/getMemberList/{teamId}")
    public ResponseEntity<Result> getMemberList(@PathVariable("teamId") String teamId){
        List<MemberDto> res = teamService.getMemberList(teamId);
        return new ResponseEntity<>(new Result(200, "获取团队成员", res),HttpStatus.OK);
    }

    @ApiOperation(value = "获取团队以及团队所对应所有项目信息")
//    @PreAuthorize("hasAnyRole('USER')")
    @GetMapping("/getTeams")
    public ResponseEntity<Result> getTeamList(){
        List<TeamDto> teamDtos = teamService.getTeams();
        return new ResponseEntity<>(new Result(200,"OK", teamDtos),HttpStatus.OK);
    }

    @ApiOperation(value = "通过teamId获取团队以及项目信息")
    @GetMapping("/getTeamProByTeamId/{teamId}")
    public ResponseEntity<Result> getTeamProByTeamId(@PathVariable(name = "teamId") String teamId){
        TeamDto teamDtos = teamService.getTeamProByTeamId(teamId);
        return new ResponseEntity<>(new Result<>(200,"OK", teamDtos),HttpStatus.OK);
    }

    @ApiOperation(value = "通过用户ID获取团队以及项目信息")
    @GetMapping("/getTeamProByUserId/{userId}")
    public ResponseEntity<Result> getTeamProByUserId(@PathVariable(name = "userId") String userId){
        List<TeamDto> teamDtos = teamService.getTeamProByUserId(userId);
        return new ResponseEntity<>(new Result(200,"OK",teamDtos),HttpStatus.OK);
    }

    @ApiOperation(value = "获取我的团队以及项目信息")
    @GetMapping("/getMyTeamProByUserId/{userId}")
    public ResponseEntity<Result> getMyTeamProByUserId(@PathVariable(name = "userId") String userId){
        List<TeamDto> teamDtos = teamService.getMyTeamProByUserId(userId);
        return new ResponseEntity<>(new Result(200,"OK",teamDtos),HttpStatus.OK);
    }

    @ApiOperation(value = "获取我的团队以及项目信息")
    @GetMapping("/getJoinTeamProByUserId/{userId}")
    public ResponseEntity<Result> getJoinTeamProByUserId(@PathVariable(name = "userId") String userId){
        List<TeamDto> teamDtos = teamService.getJoinTeamProByUserId(userId);
        return new ResponseEntity<>(new Result(200,"OK",teamDtos),HttpStatus.OK);
    }

    @ApiOperation(value = "模糊查询团队信息")
    @GetMapping("/getTeamByTeamName/{teamName}")
    public ResponseEntity<Result> getTeamByTeamName(@PathVariable(name = "teamName") String teamName){
        List<TeamDto> teamDtos = teamService.getTeamByTeamName(teamName);
        return new ResponseEntity<>(new Result(200, "OK", teamDtos), HttpStatus.OK);
    }

    @ApiOperation(value = "新增团队")
    @PostMapping("/saveTeam")
    public ResponseEntity<Result> saveTeam(@RequestBody TeamDto teamDto){
        System.out.println("teamDto:" + teamDto.toString());
        int res = teamService.saveTeam(teamDto);
        if (res > 0){
            return new ResponseEntity<>(new Result(200, "保存成功", res), HttpStatus.OK);
        }else if(res == -1){
            return new ResponseEntity<>(new Result(404, "管理员ID不存在", res), HttpStatus.OK);
        }
        return new ResponseEntity<>(new Result(404, "保存失败", res), HttpStatus.OK);
    }

    @ApiOperation(value = "通过团队范围查询团队信息")
    @GetMapping("/getTeamByteamScope/{teamScope}")
    public ResponseEntity<Result> getTeamByteamScope(@PathVariable(name = "teamScope") String teamScope){
        List<TeamDto> teamDtos = teamService.getTeamByteamScope(teamScope);
        return new ResponseEntity<>(new Result(200, "OK", teamDtos), HttpStatus.OK);
    }

    @ApiOperation(value = "通过团队类型查找团队信息")
    @GetMapping("/getTeamByTeamType/{key}")
    public ResponseEntity<Result> getTeamByTeamType(@PathVariable(name = "key") String key){
//        String value = this.teamTypeService.getValueByKey(key);
        List<TeamDto> teamDtos = teamService.getTeamByTeamType(key);
        return new ResponseEntity<>(new Result(200, "OK", teamDtos), HttpStatus.OK);
    }

    @ApiOperation(value = "分页查询团队信息")
    @PostMapping("/getPageInfo")
    public ResponseEntity<Result> getPageInfo(@RequestBody PageRequest pageRequest){
        PageResult pageResult = teamService.pageTeams(pageRequest);
        return new ResponseEntity<>(new Result(200,"OK", pageResult), HttpStatus.OK);
    }

    @ApiOperation(value = "完成组队")
    @GetMapping("/TeamStatusFinish/{teamId}")
    public ResponseEntity<Result> TeamStatusFinish(@PathVariable(name = "teamId") String teamId){
        Integer res = teamService.TeamStatusFinish(teamId);
        return new ResponseEntity<>(new Result(200,"OK", res), HttpStatus.OK);
    }

    @ApiOperation(value = "继续组队")
    @GetMapping("/TeamStatusContinue/{teamId}")
    public ResponseEntity<Result> TeamStatusContinue(@PathVariable(name = "teamId") String teamId){
        Integer res = teamService.TeamStatusContinue(teamId);
        return new ResponseEntity<>(new Result(200,"OK", res), HttpStatus.OK);
    }

    @ApiOperation(value = "同意组队")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @PutMapping("/agree")
    public ResponseEntity<Result> agree(@RequestParam(value = "teamId") String teamId){
        Integer res = teamService.agree(teamId);
        return new ResponseEntity<>(new Result(200,"OK", res), HttpStatus.OK);
    }

    @ApiOperation(value = "不同意组队")
    @PutMapping("/disagree")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ResponseEntity<Result> disagree(@RequestParam(name = "teamId") String teamId){
        Integer res = teamService.disagree(teamId);
        return new ResponseEntity<>(new Result(200,"OK", res), HttpStatus.OK);
    }

}
