package crw.bishe.team.filter;

import crw.bishe.team.config.JwtConfig;
import crw.bishe.team.service.UserRolesService;
import io.jsonwebtoken.Claims;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description Description token过滤器，拦截请求
 * @Author crw
 * @Date Created in 2020/2/13 0013
 * @Time 21:07
 */
@Component
@Log4j2
public class TokenInterceptor extends HandlerInterceptorAdapter  {

    @Resource
    private JwtConfig jwtConfig;

    @Autowired
    private UserRolesService userRolesService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,  Object handler) throws Exception {

        // 地址过滤
        String uri = request.getRequestURI();
        if (uri.contains("/token") || uri.contains("/api")){
            return true;
        }
        // Token验证
        String token = request.getHeader(jwtConfig.getHeaderKey());
        System.out.println(jwtConfig.getHeaderKey());
        System.out.println("token:"+token);
        if (StringUtils.isEmpty(token)){
            token = request.getParameter(jwtConfig.getHeaderKey());
        }
        if (StringUtils.isEmpty(token)){
            log.info(jwtConfig.getHeaderKey()+"不能为空");
            throw new Exception(jwtConfig.getHeaderKey() + "不能为空");
        }
        Claims claims = jwtConfig.getTokenClaim(token);
        if (claims == null || jwtConfig.isTokenExpired(claims.getExpiration())){
            log.info(jwtConfig.getHeaderKey()+"失效，请重新登录");
            throw new Exception(jwtConfig.getHeaderKey() + "失效，请重新登录");
        }
        // 设置identityId用户身份ID
        request.setAttribute("identityId", claims.getSubject());
        return true;
    }
}
