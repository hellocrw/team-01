package crw.bishe.team.quartz;

import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;

import javax.annotation.Resource;

/**
 * 项目启动后再启动初始化时恢复时间调度器中的任务
 */
@Configuration
@Log4j2
public class ApplicationStartQuartzJobListener implements ApplicationListener<ContextRefreshedEvent> {

    @Resource
    private Scheduler scheduler;

    @SneakyThrows
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        System.out.println("调用了ApplicationStartQuartzJobListener #onApplicationEvent");
        resumeJob("工作名称", "工作组");
    }

    private Boolean resumeJob(String name, String group) throws SchedulerException {
        JobKey jobKey = new JobKey(name, group);
        JobDetail jobDetail = scheduler.getJobDetail(jobKey);
        if (jobDetail == null){
            System.out.println("没有任务");
            return false;
        }
        scheduler.resumeJob(jobKey);
        log.info("任务已恢复");
        return true;
    }
}
