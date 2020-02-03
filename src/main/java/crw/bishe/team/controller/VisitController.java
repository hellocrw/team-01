package crw.bishe.team.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description Description 记录网站被访问的次数
 * @Author crw
 * @Date Created in 2020/2/2 0002
 * @Time 23:23
 */
@Api(tags = {"网站访问次数"})
@RestController
public class VisitController {

    @GetMapping("/visit")
    public String visitMumber(HttpServletRequest request){
        Integer clientCount = (Integer) request.getServletContext().getAttribute("clientCount");
        request.getServletContext().setAttribute("clientCount", clientCount++);
        return "当前访问人数" + clientCount;
    }
}
