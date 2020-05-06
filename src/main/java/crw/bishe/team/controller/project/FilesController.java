package crw.bishe.team.controller.project;

import crw.bishe.team.dto.FilesDto;
import crw.bishe.team.service.FilesService;
import crw.bishe.team.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Api(tags = {"文件管理"})
@RestController
@RequestMapping("/api/files")
public class FilesController {

    @Autowired
    private FilesService filesService;

    @ApiOperation(value = "文件上传")
    @PostMapping(value =  "/uploadFiles", produces = "application/json; charset=utf-8")
    public ResponseEntity<Result> uploadFiles(@RequestParam("file") MultipartFile files){
        String res = filesService.uploadFiles(files);
        return new ResponseEntity<>(new Result(200, "OK", res), HttpStatus.OK);
    }

    @ApiOperation(value = "文件下载")
    @GetMapping("/{fileName}")
    public ResponseEntity<Result> download(HttpServletResponse response,@PathVariable(name = "fileName") String fileName){
        try {
            String res = filesService.downloadFile(response, fileName);
            return new ResponseEntity<>(new Result(200,"OK",res),HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new Result(200,"下载失败"),HttpStatus.OK);
    }

    @ApiOperation(value = "通过项目ID获取文件信息")
    @GetMapping("/getFilesByProId/{proId}")
    public ResponseEntity<Result> getFilesByProId(@PathVariable(name = "proId") String proId){
        List<FilesDto> filesDtos = filesService.getFilesByProId(proId);
        return new ResponseEntity<>(new Result(200, "OK", filesDtos), HttpStatus.OK);
    }

    @ApiOperation(value = "保存文件信息")
    @PostMapping("/saveFile")
    public ResponseEntity<Result> saveFile(@RequestBody FilesDto filesDto){
        FilesDto res = filesService.saveFile(filesDto);
        return new ResponseEntity<>(new Result(200, "OK", res), HttpStatus.OK);
    }

    @DeleteMapping("/deleteByFileId/{fileId}")
    public ResponseEntity<Result> delectByFileId(@PathVariable(name = "fileId")String fileId){
        Integer res = filesService.delectByFileId(fileId);
        return new ResponseEntity<>(new Result(200,"OK",res), HttpStatus.OK);
    }
}
