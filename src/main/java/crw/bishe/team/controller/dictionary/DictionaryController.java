package crw.bishe.team.controller.dictionary;

import crw.bishe.team.dto.TeamTypeDto;
import crw.bishe.team.dto.UniversityDto;
import crw.bishe.team.entity.TeamType;
import crw.bishe.team.service.DictionaryService;
import crw.bishe.team.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description Description
 * @Author crw
 * @Date Created in 2020/2/2 0002
 * @Time 15:38
 */
@Api(tags = {"字典管理"})
@RestController
@RequestMapping("/api/dictionaries")
public class DictionaryController {

    @Autowired
    private DictionaryService dictionaryService;

    @ApiOperation("获取团队类型")
    @GetMapping("/getTeamType")
    public ResponseEntity<Result> getProType(){
        List<TeamTypeDto> teamTypes = dictionaryService.getTeamType();
        return new ResponseEntity<>(new Result(200,"OK",teamTypes), HttpStatus.OK);
    }

    @ApiOperation("获取学校")
    @GetMapping("/getUniversity")
    public ResponseEntity<Result> getUniversity(){
        List<UniversityDto> universities = dictionaryService.getUniversity();
        return new ResponseEntity<>(new Result(200,"获取学校", universities),HttpStatus.OK);
    }
}
