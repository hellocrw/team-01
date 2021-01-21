package crw.bishe.team.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringBeanUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext = null;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (SpringBeanUtil.applicationContext == null){
            SpringBeanUtil.applicationContext = applicationContext;
        }
    }

    // 获取applicationContext
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    // 通过name获取Bean
    public static Object getBean(String name){
        return getApplicationContext().getBean(name);
    }

    // 通过class获取Bean
    public static <T> T getBean(Class<T> tClass){
        return getApplicationContext().getBean(tClass);
    }

    // 通过name,以及clas返回指定的bean
    public static <T> T getBean(String name, Class<T> tClass){
        return getApplicationContext().getBean(name, tClass);
    }
}
