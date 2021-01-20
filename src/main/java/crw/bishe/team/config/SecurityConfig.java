package crw.bishe.team.config;

import crw.bishe.team.entity.UserRoles;
import crw.bishe.team.filter.CustomLogoutHandler;
import crw.bishe.team.filter.CustomLogoutSuccessHandler;
import crw.bishe.team.security.JwtUserDto;
import crw.bishe.team.service.auth.TokenService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.rememberme.TokenBasedRememberMeServices;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description spring security 认证和授权 用于web登录和拦截请求等
 * quesion:加了configure(WebSercurity web)导致spring security默认的权限控制失效的问题
 * @Author crw
 * @Date Created in 2019/12/18 0018
 * @Time 18:21
 */
@Configuration
@EnableWebSecurity // 开启spring security
@EnableAutoConfiguration
@EnableGlobalMethodSecurity(prePostEnabled = true) //spring security默认是关闭注解的，要开启security注解
@Log4j2
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private TokenService tokenService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable();
//        http.csrf().ignoringAntMatchers("/druid/*");
        http.authorizeRequests()
                // 设置权限访问时，先设置具体指定的路径，在设置范围的
                .antMatchers("/api/token/getToken","/static/**","/druid/**", "/test/**").permitAll()// 都可以访问的资源
                .antMatchers("/api/admin/**").hasAnyAuthority("ADMIN","SUPERADMIN")  // 需要ADMIN权限才能访问
                .antMatchers("/api/**").authenticated()  //需要登录才能访问URL -> /api/** 资源
                .anyRequest().authenticated()
                .and()
                .csrf().requireCsrfProtectionMatcher(new RequestMatcher() {
            @Override
            public boolean matches(HttpServletRequest request) {
                String servletPath  = request.getServletPath();
                if (servletPath.contains("/druid")){
                    return false;
                }
                return false;
            }
        }).and()
//                 禁用session  (bug: 禁用session后无法登录的问题)
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
                .formLogin()
                // 指定登录页的路径
//                .loginPage("http://localhost:4200/#/passport/login")
                // 指定自定义form表单请求的路径
//                .successForwardUrl("/api/token/getToken")
                .permitAll()
                .and()
                // .logout().permitAll();
                .logout().addLogoutHandler(new CustomLogoutHandler())
                .logoutSuccessHandler(new CustomLogoutSuccessHandler());
//        http.addFilterBefore(authenticationProvider, UsernamePasswordAuthenticationFilter.class);
    }

    //定义认证规则
    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(tokenService).passwordEncoder(passwordEncoder());
        auth.authenticationProvider(authenticationProvider());
       // 在内存中创建用户和密码，模拟数据库实现用户登录
        /*auth.inMemoryAuthentication().passwordEncoder(passwordEncoder())  //在Spring Security 5.0中新增了多种加密方式，也改变了密码的格式
                .withUser("admin").password(new BCryptPasswordEncoder().encode("123456")).roles("ADMIN")
                .and()
                .withUser("crw").password(new BCryptPasswordEncoder().encode("123456")).roles("USER")
                .and()
                .withUser("hzc").password(new BCryptPasswordEncoder().encode("123456")).roles("USER");*/
    }

    /**
     * 解决 tokenController 中的 authenticationManager 无法注入的问题
     */
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(tokenService);
        authProvider.setPasswordEncoder(passwordEncoder());  // 设置密码加密方式
        return authProvider;
    }

    /**
     * 使用BCrypt密码加密
     * @return
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(4);
    }

    @Bean
    public TokenBasedRememberMeServices tokenBasedRememberMeServices(){
        return new TokenBasedRememberMeServices("springRocks", userDetailsService());
    }

    @Bean
    public SavedRequestAwareAuthenticationSuccessHandler loginSuccessHandler() { //登入处理
        return new SavedRequestAwareAuthenticationSuccessHandler() {
            @Override
            public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                UserRoles userDetails = (UserRoles) authentication.getPrincipal();
                log.info("USER : {} LOGIN SUCCESS !  ", userDetails.getUsername());
                super.onAuthenticationSuccess(request, response, authentication);
            }
        };
    }

    @Bean
    public LogoutSuccessHandler logoutSuccessHandler() { //登出处理
        return (httpServletRequest, httpServletResponse, authentication) -> {
            try {
                JwtUserDto user = (JwtUserDto) authentication.getPrincipal();
                log.info("USER : {} LOGOUT SUCCESS ! ", user.getUsername());
            } catch (Exception e) {
                log.error("printStackTrace", e);
            }
            httpServletResponse.sendRedirect("/login");
        };
    }

    /*@Bean
    @Override
    public UserDetailsService userDetailsService() {    //用户登录实现
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("admin").password("123456").authorities("ADMIN").build());
        manager.createUser(User.withUsername("crw").password("123456").authorities("USER").build());
        return manager;
    }*/

    /**
     * 加了configure(WebSercurity web)导致spring security默认的权限控制失效的问题
     */
//    @Override
//    public void configure(WebSecurity web) {
//        web.ignoring().antMatchers(
//                "/static/**",
//                "/api/**"
////              "/swagger-ui.html"
//        );
//    }

}
