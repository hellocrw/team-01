package crw.bishe.team.controller.test;

import cn.hutool.core.date.DateUtil;
import crw.bishe.team.config.JwtConfig;
import crw.bishe.team.dto.ProjectDto;
import crw.bishe.team.entity.Project;
import crw.bishe.team.mapper.ProjectMapper;
import crw.bishe.team.service.TestService;
import crw.bishe.team.utils.ResponseUtils;
import crw.bishe.team.vo.Result;
import io.swagger.annotations.Api;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.Sqls;

import java.util.*;

import static jdk.nashorn.internal.objects.NativeDebug.map;

/**
 * @Description Description 测试类
 * @Author crw
 * @Date Created in 2019/12/20 0020
 * @Time 14:00
 */
@Api(tags = {"测试接口"})
@RequestMapping("/api/test")
@RestController
@ResponseBody
public class TestController {

    private final static String URL = "http://ORDER80";

    @Autowired
    private ProjectMapper projectMapper;

    @Autowired
    private JwtConfig jwtConfig;

    @Autowired
    private ResponseUtils responseUtils;

    @Autowired
    private TestService testService;

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 服务调用接口
     * @return
     */
    @GetMapping("/a")
    public String openFeign(){
        return testService.demo();
    }

    /**
     * 服务超时测试
     * @return
     */
    @GetMapping(value = "/feign/timeout")
    public String paymentFeignTimeout(){
        return testService.paymentFeignTimeout();
    }

    /**
     * RestTempate服务调用测试
     * @return
     */
    @GetMapping("/demo")
    public String demo(){
        return restTemplate.getForObject(URL+ "/optional", String.class);
    }

    @DeleteMapping("/delete/{teamId}")
    public String delectTest(@PathVariable(name = "teamId") String teamId){
        Long key = Long.parseLong(teamId);
//        Project project = new Project();
//        int res = projectMapper.deleteByExample(key);
        return "测试";
    }

    // 拦截器直接放行，返回Token
    @PostMapping("/login")
    public ResponseEntity<Result> login(@RequestParam("userName") String userName,
                                        @RequestParam("password") String passWord){
        Map<String,String> result = new HashMap<>() ;
        String token = jwtConfig.getToken(userName+passWord) ;
        if (!StringUtils.isEmpty(token)){
            result.put("token", token);
        }
        result.put("userName", userName);
        return new ResponseEntity<>(new Result(200, "OK", result), HttpStatus.OK);
    }
    // 需要 Token 验证的接口
    @GetMapping("/info/userId/{userId}/teamId/{teamId}")
    public String info (@PathVariable(required = false) String userId,
                        @PathVariable(required = false) String teamId){
        System.out.println("userId:" + userId);
        System.out.println("teamId" + teamId);
        return "info" ;
    }

    /**
     * 分页查询测试,需要USER权限才能访问
     * @return
     */
    @GetMapping(value = "/pages")
    @PreAuthorize("hasAuthority('User')")
    public List<Project> projectPages(){
        return projectMapper.selectByRowBounds(new Project(),new RowBounds(1,3));
    }

    /**
     * 测试方法，权限ADMIN
     * @return
     */
    @GetMapping(value = "/test")
    @PreAuthorize("hasAuthority('ADMIN')")  // 基于方法的权限控制，拥有ADMIN权限才可以访问
    public String logout(){
        return "测试方法,拥有ADMIN权限的用户才能访问";
    }

    /**
     * 需要登录，但不需要角色
     * @return
     */
    @GetMapping(value = "/")
    @PreAuthorize("isAuthenticated()")
    public String fail(){
        return "登录测试，需要登录才能访问";
    }

    @GetMapping(value = "/hutool")
    public ResponseEntity<Result> hutool(){
        Map<String ,Object> map = new HashMap<>();
        // 当前时间
        Date date = DateUtil.date();
        map("date", date);
        // 当前时间
        Date date2 = DateUtil.date(Calendar.getInstance());
        map("date2", date2);
        return responseUtils.success(map);
    }
}
