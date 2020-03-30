package crw.bishe.team.controller.project;

import crw.bishe.team.dto.NoticeDto;
import crw.bishe.team.service.NoticeService;
import crw.bishe.team.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
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
@RequestMapping("/api/notice")
@RestController
@Log4j2
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    @ApiOperation(value = "通过项目ID获取公告信息")
    @GetMapping("/getNoticesByProId/{proId}")
    public ResponseEntity<Result> getNoticesByProId(@PathVariable(name = "proId") String proId){
        List<NoticeDto> noticeDtos = noticeService.getNoticesByProId(proId);
        return new ResponseEntity<>(new Result(200, "OK", noticeDtos), HttpStatus.OK);
    }
}
