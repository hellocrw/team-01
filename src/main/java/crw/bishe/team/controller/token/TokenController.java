package crw.bishe.team.controller.token;

import crw.bishe.team.config.JwtConfig;
import crw.bishe.team.dto.UserDto;
import crw.bishe.team.dto.UserRolesDto;
import crw.bishe.team.security.JwtUserDto;
import crw.bishe.team.service.TokenService;
import crw.bishe.team.service.UserInfoService;
import crw.bishe.team.service.UserRolesService;
import crw.bishe.team.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description Description 用户登录，获取token
 * @Author crw
 * @Date Created in 2020/1/29 0029
 * @Time 21:18
 */
@RestController
@Api(tags = {"令牌管理"})
@RequestMapping(value = "/api/token")
public class TokenController {

    @Autowired
    private JwtConfig jwtConfig;

    @Autowired
    private UserRolesService userRolesService;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserInfoService userInfoService;

    private final AuthenticationManager authenticationManager;

    @Autowired
    public TokenController(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @ApiOperation("使用账号密码获取Token")
    @PostMapping("/getToken")
    public ResponseEntity<Result> getToken(@RequestBody @Validated UserRolesDto userRolesDto, HttpServletRequest request){
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
            UserDto userDto = userInfoService.getUserInfoByUserName(user.getUsername());
            res.put("userInfo", userDto);
            // 生成token
            String token = jwtConfig.getToken(userRolesDto.getUsername()+userRolesDto.getPassword());
            if (!StringUtils.isEmpty(token)){
                res.put("token", token);
                // 获取当前登录时间
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
                simpleDateFormat.applyPattern("yyyy-MM-dd HH:mm:ss");
                res.put("loginTime", simpleDateFormat.format(new Date()));
                // 获取用户权限
                System.out.println("userName:" + userRolesDto.getUsername());
                if ("admin".equals(userRolesDto.getUsername())){
                    System.out.println("测试admin");
                    res.put("auth", "ADMIN");
                }else{
                    System.out.println("测试user");
                    res.put("auth", "USER");
                }
//                if (userRolesDto.getUsername() == "crw"){
//                    res.put("auth", "USER");
//                }
//                else if (userRolesDto.getUsername() == "admin"){
//                    res.put("auth", "ADMIN");
//                }
            }
            return new ResponseEntity<>(new Result(200,"ok" , res), HttpStatus.OK);
        }catch (Exception e){
            System.out.println("空指针异常");
            return new ResponseEntity<>(new Result(403,"登录失败", "用户名或者密码错误"), HttpStatus.FORBIDDEN);
        }

    }

}
