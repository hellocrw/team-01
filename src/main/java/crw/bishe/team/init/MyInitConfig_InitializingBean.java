package crw.bishe.team.init;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @Description 实现InitializingBean接口实现项目初始化操作
 * @Author crw
 * @Date Created in 2019/12/24 0024
 * @Time 17:35
 */
@Component
@Log4j2
public class MyInitConfig_InitializingBean implements InitializingBean {

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("实现InitializingBean接口实现项目初始化操作");

        // 获取所有的bean
        String[] beans = applicationContext.getBeanDefinitionNames();
        Arrays.sort(beans);
        for (String bean:beans) {
            System.out.println(bean + " =========tpye=========> " + applicationContext.getBean(bean).getClass());
        }
    }
}
