package crw.bishe.team.controller;

import crw.bishe.team.entity.UserInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description Description 记录网站被访问的次数
 * @Author crw
 * @Date Created in 2020/2/2 0002
 * @Time 23:23
 */
@RestController
public class VisitController {

    @GetMapping("/visit")
    public String visitMumber(HttpServletRequest request, HttpServletResponse response, UserInfo userInfo){
        Integer clientCount = (Integer) request.getServletContext().getAttribute("clientCount");
        request.getServletContext().setAttribute("clientCount", clientCount++);
        return "当前访问人数" + clientCount;
    }
}
