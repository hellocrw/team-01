package crw.bishe.team.init;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @Description 使用@PostConstruct注解实现项目启动的初始化工作
 * @Author crw
 * @Date Created in 2019/12/24 0024
 * @Time 17:40
 */
@Slf4j
@Component
public class MyInitConfig_PostConstruct {
    @PostConstruct
    public void init(){
        log.info("使用@PostConstruct注解实现项目启动的初始化工作");
    }
}
