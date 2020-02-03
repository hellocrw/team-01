package crw.bishe.team.listener;

import crw.bishe.team.mapper.ProjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @Description Description 客户端访问量统计功能
 * @Author crw
 * @Date Created in 2020/2/2 0002
 * @Time 21:30
 */
@WebListener
public class VisitorContextListener implements ServletContextListener {

    @Autowired
    private ProjectMapper projectMapper;

    /**
     * 项目初始化时调用该方法，获取数据库中的seeNum，用ServletContext保存起来
     * @param servletContextEvent
     */
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent){
        System.out.println("VisitorContextListener.contextInitialized()");
        // 获取ServletContext操作对象
        ServletContext application =servletContextEvent.getServletContext();
        // 从数据库中取得数据
        Integer clientCount = projectMapper.getSeeNum(1);
        application.setAttribute("clientCount", clientCount);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent){
        System.out.println("VisitorContextListener.contextDestroyed()");
        ServletContext application = servletContextEvent.getServletContext();
        // 在关闭服务器之前，将网站当前的访问量存入数据库
        Integer clientCount = (Integer) application.getAttribute("clientCount");
        projectMapper.updateSeeNum(clientCount, 1);
    }
}
