package crw.bishe.team.filter;

import com.alibaba.fastjson.JSON;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomLogoutHandler implements LogoutHandler {
    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        UserDetails authUser = (UserDetails)authentication.getPrincipal();
        String userName = authUser.getUsername();
        System.out.println("当前用户：" + JSON.toJSON(userName));
    }
}
