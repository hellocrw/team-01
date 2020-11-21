package temp.code.fail.quartz;

import lombok.extern.slf4j.Slf4j;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import java.util.Properties;

@Configuration
@Slf4j
public class ApplicationStartQuartzJobListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private QuartzObject quartzObject;

    /**
     * 初始启动quartz
     */
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.info("开始启动调度任务。");
    }

    /**
     * 初始注入scheduler
     *
     * @return
     * @throws SchedulerException
     */
    @Bean
    public Scheduler scheduler(SchedulerFactoryBean schedulerFactoryBean){
        return schedulerFactoryBean.getScheduler();
    }

    @Bean
    public MyJobFactory jobFactory() {
        return new MyJobFactory();
    }

    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(MyJobFactory jobFactory){
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        schedulerFactoryBean.setJobFactory(jobFactory);
        schedulerFactoryBean.setQuartzProperties(quartzProperties());
        return schedulerFactoryBean;
    }

    @Bean
    public Properties quartzProperties(){
        //PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
        Properties properties = new Properties();
        properties.put("org.quartz.scheduler.instanceName",quartzObject.getInstanceName());
        properties.put("org.quartz.threadPool.class",quartzObject.getThreadPoolClass());
        properties.put("org.quartz.threadPool.threadCount",quartzObject.getThreadCount());
        properties.put("org.quartz.threadPool.threadPriority",quartzObject.getThreadPriority());
        properties.put("org.quartz.jobStore.misfireThreshold",quartzObject.getMisfireThreshold());
        properties.put("org.quartz.jobStore.class",quartzObject.getJobStoreClass());
        properties.put("org.quartz.jobStore.useProperties",quartzObject.getUseProperties());
        properties.put("org.quartz.jobStore.driverDelegateClass",quartzObject.getDriverDelegateClass());
        properties.put("org.quartz.jobStore.tablePrefix",quartzObject.getTablePrefix());
        properties.put("org.quartz.jobStore.dataSource",quartzObject.getDataSource());
        properties.put("org.quartz.dataSource.qzDS.driver",quartzObject.getDriver());
        properties.put("org.quartz.dataSource.qzDS.URL",quartzObject.getURL());
        properties.put("org.quartz.dataSource.qzDS.user",quartzObject.getUser());
        properties.put("org.quartz.dataSource.qzDS.password",quartzObject.getPassword());
        properties.put("org.quartz.triggerListener.NAME.class",quartzObject.getTriggerListenerClass());
        //propertiesFactoryBean.setProperties(properties);
        //propertiesFactoryBean.setLocation(new ClassPathResource("/quartz.properties"));
        // 在quartz.properties中的属性被读取并注入后再初始化对象
        //propertiesFactoryBean.afterPropertiesSet();
        //return propertiesFactoryBean.getObject();
        return properties;
    }
}