package crw.bishe.team.config;

import crw.bishe.team.entity.UserRoles;
import crw.bishe.team.security.SecurityUserDto;
import crw.bishe.team.service.UserRolesService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.rememberme.TokenBasedRememberMeServices;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description spring security 认证和授权 用于web登录和拦截请求等
 * @Author crw
 * @Date Created in 2019/12/18 0018
 * @Time 18:21
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) //开启security注解
@Log4j2
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserRolesService userRolesService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
//        http.csrf().ignoringAntMatchers("/druid/*");
        http.authorizeRequests()
                .antMatchers("/api/**").authenticated() //需要登录才能访问URL -> /api/** 资源
                .antMatchers("/api/admin/**").hasAnyAuthority("ADMIN")  // 有ADMIN权限才能访问URL -> localhost:8080/api/admin/** 资源
                .antMatchers("/static/**","/druid/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .csrf().disable()
                .formLogin()
//                .loginPage("http://localhost:4200/#/passport/login")
//                .successForwardUrl("/api/token/getToken")
                .permitAll()
                .and()
                .logout().permitAll();
    }

    //定义认证规则
    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userRolesService);
        auth.authenticationProvider(authenticationProvider());
       /*// 在内存中创建用户和密码，模拟数据库实现用户登录
        auth.inMemoryAuthentication().passwordEncoder(passwordEncoder())  //在Spring Security 5.0中新增了多种加密方式，也改变了密码的格式
                .withUser("admin").password(new BCryptPasswordEncoder().encode("123456")).roles("ADMIN")
                .and()
                .withUser("crw").password(new BCryptPasswordEncoder().encode("123456")).roles("USER")
                .and()
                .withUser("hzc").password(new BCryptPasswordEncoder().encode("123456")).roles("USER");*/
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userRolesService);
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
                SecurityUserDto user = (SecurityUserDto) authentication.getPrincipal();
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

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers(
                "/static/**",
                "/api/**"
//                "/swagger-ui.html"
        );
    }
}
