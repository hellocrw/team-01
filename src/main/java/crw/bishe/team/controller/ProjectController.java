package crw.bishe.team.controller;

import crw.bishe.team.dto.ProjectDto;
import crw.bishe.team.dto.TeamDto;
import crw.bishe.team.entity.Project;
import crw.bishe.team.service.ProjectService;
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
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @Description Description 项目管理
 * @Author crw
 * @Date Created in 2020/1/19 0019
 * @Time 17:21
 */
@Api(tags = {"项目管理"})
@RestController
@RequestMapping("/api/project")
@Log4j2
public class ProjectController {

    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService){
        this.projectService = projectService;
    }

    @ApiOperation(value = "查找所有项目信息")
    @GetMapping("/All")
    public ResponseEntity<Result<List<ProjectDto>>> findAll(){
        List<ProjectDto> projectDtos = projectService.findAll();
        return new ResponseEntity<>(new Result(200, "处理成功", projectDtos), HttpStatus.OK);
    }

    @ApiOperation(value = "新增项目信息")
    @PostMapping("")
    public ResponseEntity<Result> create(@ApiParam(value = "项目信息") @RequestBody @Validated ProjectDto projectDto){
        int res = projectService.create(projectDto);
        if(res > 0){
            return new ResponseEntity<>(new Result(200, "处理成功"), HttpStatus.OK);
        }
        return new ResponseEntity<>(new Result("处理失败"), HttpStatus.BAD_REQUEST);
    }

    @ApiOperation(value = "修改项目信息")
    @PutMapping("/{id}")
    public ResponseEntity<Result> update(@ApiParam(value = "项目ID") @PathVariable(name = "id") String id ,
                                         @ApiParam(value = "项目信息") @RequestBody @Validated ProjectDto projectDto){
        int res = projectService.update(projectDto, id);
        if(res > 0){
            return new ResponseEntity<>(new Result(200, "处理成功"), HttpStatus.OK);
        }
        return new ResponseEntity<>(new Result("处理失败"), HttpStatus.BAD_REQUEST);
    }

    @ApiOperation(value = "删除项目信息")
    @DeleteMapping("/{id}")
    public ResponseEntity<Result> delete(@ApiParam(value = "项目ID") @PathVariable(name = "id") String id){
        int res = projectService.delete(id);
        if(res > 0){
            return new ResponseEntity<>(new Result(200, "处理成功"), HttpStatus.OK);
        }
        return new ResponseEntity<>(new Result("处理失败"), HttpStatus.BAD_REQUEST);
    }

    @ApiOperation(value = "通过团队ID->获取我的项目信息")
    @GetMapping("/getMyProList/{team_id}")
    public ResponseEntity<Result> getMyProList(@ApiParam(value = "团队ID号") @PathVariable(name = "team_id") String id){
        List<Map> myProList = projectService.getMyProList(id);
        return new ResponseEntity<>(new Result(200, "获取我的项目信息成功", myProList), HttpStatus.OK);
    }

    @ApiOperation(value = "分页查询项目信息")
    @PostMapping("/getVisit")
    public ResponseEntity<Result> getVisitNum(@RequestBody PageRequest pageRequest){
        PageResult pageResult =  projectService.proPages(pageRequest);
        return new ResponseEntity<>(new Result(200,"分页查询项目信息", pageResult), HttpStatus.OK);
    }
}
