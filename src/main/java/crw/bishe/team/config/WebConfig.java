package crw.bishe.team.config;

import crw.bishe.team.filter.JWTAuthenticationFilter;
import crw.bishe.team.filter.TokenInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * @Description Description 拦截token，认证身份
 * @Author crw
 * @Date Created in 2020/2/13 0013
 * @Time 21:33
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Resource
    private TokenInterceptor tokenInterceptor;

    /**
     * 增加拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(tokenInterceptor).addPathPatterns("/api/**");
    }
}
