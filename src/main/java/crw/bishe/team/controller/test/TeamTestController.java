package crw.bishe.team.controller.test;

import crw.bishe.team.algorithm.RecommendAlgorithm;
import crw.bishe.team.dto.TeamDto;
import crw.bishe.team.dto.TeamProDto;
import crw.bishe.team.mapper.TeamMapper;
import crw.bishe.team.vo.Result;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @Description Description
 * @Author crw
 * @Date Created in 2020/2/26 0026
 * @Time 23:50
 */
@Api(tags = {"团队测试接口"})
@RestController
@RequestMapping("/api/team-test")
public class TeamTestController {
    @Autowired
    private TeamMapper teamMapper;

    @Autowired
    private RecommendAlgorithm recommendAlgorithm;

    @GetMapping("/getTeams")
    public ResponseEntity<Result<List<TeamDto>>> getTeams(){
        List<TeamDto> teamDtos = teamMapper.getTeams();
        return new ResponseEntity<>(new Result(200,"OK", teamDtos), HttpStatus.OK);
    }

    @GetMapping("/getRecommand/{userId}/{university}")
    public ResponseEntity<Result> getRecommand(@PathVariable(name = "userId") String userId,
                                               @PathVariable(name = "university") String university){
        String teamType = recommendAlgorithm.preProcess(userId);
        List<TeamDto> res = recommendAlgorithm.remcommendTeam(userId, university, teamType);
        return new ResponseEntity<>(new Result(200, "OK", res), HttpStatus.OK);
    }
}
