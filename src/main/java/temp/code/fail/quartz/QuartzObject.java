package temp.code.fail.quartz;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * quartz配置映射类
 *
 * @author weiyongxuan
 * @version 1.0
 * @email weiyongxuan@ly-sky.com
 * @date 2019-08-21 16:21
 */
@Configuration
@Data
public class QuartzObject {

    @Value("${org.quartz.scheduler.instanceName}")
    private String instanceName;

    @Value("${org.quartz.threadPool.class}")
    private String threadPoolClass;

    @Value("${org.quartz.threadPool.threadCount}")
    private String threadCount;

    @Value("${org.quartz.threadPool.threadPriority}")
    private String threadPriority;

    @Value("${org.quartz.jobStore.misfireThreshold}")
    private String misfireThreshold;

    @Value("${org.quartz.jobStore.class}")
    private String jobStoreClass;

    @Value("${org.quartz.jobStore.useProperties}")
    private String useProperties;

    @Value("${org.quartz.jobStore.driverDelegateClass}")
    private String driverDelegateClass;

    @Value("${org.quartz.jobStore.tablePrefix}")
    private String tablePrefix;

    @Value("${org.quartz.jobStore.dataSource}")
    private String dataSource;

    @Value("${spring.datasource.driver-class-name}")
    private String driver;

    @Value("${spring.datasource.url}")
    private String URL;

    @Value("${spring.datasource.username}")
    private String user;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${org.quartz.triggerListener.NAME.class}")
    private String triggerListenerClass;
}
