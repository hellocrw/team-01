package crw.bishe.team.utils;

import com.alibaba.fastjson.JSON;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class LoginUserUtil {

    public static String getUserId(){
        HttpServletRequest request = ((ServletRequestAttributes)(RequestContextHolder.currentRequestAttributes())).getRequest();
        String loginUserId = request.getHeader("loginUserId");
        System.out.println("request:" + JSON.toJSONString(request));
        return loginUserId;
    }
}
