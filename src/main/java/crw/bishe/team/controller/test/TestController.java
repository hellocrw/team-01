package crw.bishe.team.controller.test;

import crw.bishe.team.config.JwtConfig;
import crw.bishe.team.dto.ProjectDto;
import crw.bishe.team.entity.Project;
import crw.bishe.team.mapper.ProjectMapper;
import io.swagger.annotations.Api;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Autowired
    private ProjectMapper projectMapper;

    @Autowired
    private JwtConfig jwtConfig;

    // 拦截器直接放行，返回Token
    @PostMapping("/login")
    public Map<String, String> login(@RequestParam("userName") String userName,
                                     @RequestParam("passWord") String passWord){
        Map<String,String> result = new HashMap<>() ;
        String token = jwtConfig.getToken(userName+passWord) ;
        if (!StringUtils.isEmpty(token)){
            result.put("token", token);
        }
        result.put("userName", userName);
        return result;
    }
    // 需要 Token 验证的接口
    @PostMapping("/info")
    public String info (){
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
}
