package crw.bishe.team.myTest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Servlet
 */
@WebServlet(name = "myServlet", urlPatterns = "/api/test/test", description = "自定义的servlet")
public class MyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("myServlet doGet方法调用");
        resp.getWriter().append("myServlet");
        HttpSession session = req.getSession(true);
        System.out.println("sessionId:" + session.getId());
//        super.doGet(req, resp);
        return ;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("myServlet doPost方法调用");
//        super.doPost(req, resp);
    }
}
