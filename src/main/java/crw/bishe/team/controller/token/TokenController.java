package crw.bishe.team.controller.token;

import crw.bishe.team.config.JwtConfig;
import crw.bishe.team.dto.UserRolesDto;
import crw.bishe.team.entity.auth.AuthUser;
import crw.bishe.team.service.auth.IAuthUserService;
import crw.bishe.team.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Description Description 用户登录，获取token
 * @Author crw
 * @Date Created in 2020/1/29 0029
 * @Time 21:18
 */
@RestController
@Api(tags = {"令牌管理控制器"})
@RequestMapping(value = "/api/token")
public class TokenController {

    @Autowired
    private JwtConfig jwtConfig;

    @Autowired
    private IAuthUserService authUserService;

    private final AuthenticationManager authenticationManager;

    private RedisTemplate redisTemplate;

    @Autowired
    public TokenController(AuthenticationManager authenticationManager,
                           RedisTemplate redisTemplate) {
        this.authenticationManager = authenticationManager;
        this.redisTemplate = redisTemplate;
    }

    @ApiOperation("使用账号密码获取Token")
    @PostMapping("/getToken")
    public ResponseEntity<Result> getToken(@RequestBody @Validated UserRolesDto userRolesDto,
                                           HttpServletRequest request,
                                           HttpServletResponse response){
        System.out.println("调用了getToken方法");
        Map<String, Object> res = new HashMap<>();
        try{
            // 用户登录，验证用户名和密码
            UsernamePasswordAuthenticationToken principal = new UsernamePasswordAuthenticationToken(
                    userRolesDto.getUsername(),
                    userRolesDto.getPassword());
            principal.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            Authentication authentication = authenticationManager.authenticate(principal);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            System.out.println("getPrincipal：" + SecurityContextHolder.getContext().getAuthentication().getPrincipal());
            UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            System.out.println(user.getUsername());
            // 通过用户名获取用户的基本信息
            AuthUser authUser = authUserService.selectByUsername(userRolesDto.getUsername());
            res.put("userInfo", authUser);
            // 生成token
            String token = jwtConfig.getToken(userRolesDto.getUsername()+userRolesDto.getPassword());
            if (!StringUtils.isEmpty(token)){
                res.put("token", token);
                // 获取当前登录时间
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
                simpleDateFormat.applyPattern("yyyy-MM-dd HH:mm:ss");
                res.put("loginTime", simpleDateFormat.format(new Date()));
                // 获取用户权限
                System.out.println("权限:" + authentication.getAuthorities());
                res.put("auth", authentication.getAuthorities());
                response.setHeader("username", user.getUsername());
                response.setHeader("role", authentication.getAuthorities().toString());
                response.setHeader("Access-Control-Expose-Headers","username ");
                response.setHeader("Access-Control-Expose-Headers","role");
            }
            // 将当前登录的用户存储到redis缓存中
            SetOperations setOperations = redisTemplate.opsForSet();
            setOperations.add("onlineUser", userRolesDto.getUsername());
            Set onlineUser = setOperations.members("onlineUser");
            System.out.println("onlineUser:"+ onlineUser);
            return new ResponseEntity<>(new Result(200,"ok" , res), HttpStatus.OK);
        }catch (Exception e){
            System.out.println("空指针异常");
            return new ResponseEntity<>(new Result(403,"登录失败", "用户名或者密码错误"), HttpStatus.FORBIDDEN);
        }
    }

}
