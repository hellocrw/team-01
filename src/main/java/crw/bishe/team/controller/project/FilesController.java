package crw.bishe.team.controller.project;

import crw.bishe.team.dto.FilesDto;
import crw.bishe.team.service.FilesService;
import crw.bishe.team.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = {"文件管理"})
@RestController
@RequestMapping("/api/files")
public class FilesController {

    @Autowired
    private FilesService filesService;

    @ApiOperation(value = "通过项目ID获取文件信息")
    @GetMapping("/getFilesByProId/{proId}")
    public ResponseEntity<Result> getFilesByProId(@PathVariable(name = "proId") String proId){
        List<FilesDto> filesDtos = filesService.getFilesByProId(proId);
        return new ResponseEntity<>(new Result(200, "OK", filesDtos), HttpStatus.OK);
    }
}
