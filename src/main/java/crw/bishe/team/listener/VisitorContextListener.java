package crw.bishe.team.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @Description Description
 * @Author crw
 * @Date Created in 2020/2/2 0002
 * @Time 21:30
 */
@WebListener
public class VisitorContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent){
        System.out.println("VisitorContextListener.contextDestroyed()");
        // 获取ServletContext操作对象
        ServletContext application =servletContextEvent.getServletContext();
    }
}
