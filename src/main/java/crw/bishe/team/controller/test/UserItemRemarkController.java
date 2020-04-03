package crw.bishe.team.controller.test;

import crw.bishe.team.service.UserItemRemarkService;
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

@Api(tags = "测试接口")
@RequestMapping("/api/test")
@RestController
public class UserItemRemarkController {

    @Autowired
    private UserItemRemarkService userItemRemarkService;

    @GetMapping("/getTeamTypeNum/{userId}")
    public ResponseEntity<Result> getTeamTypeNum(@PathVariable(name = "userId") String userId){
        List<Map<String ,Object>> map = userItemRemarkService.getTeamTypeNum(userId);
        return new ResponseEntity<>(new Result(200,"OK", map), HttpStatus.OK);
    }
}
