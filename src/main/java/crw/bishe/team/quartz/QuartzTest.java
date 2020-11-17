package crw.bishe.team.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

/**
 * 时间调度器测试类
 */

public class QuartzTest {
    public static void main(String[] args) throws SchedulerException {
        // 创建工作
        JobDetail jobDetail = JobBuilder.newJob(MyJob.class)
                .withDescription("工作描述")
                .withIdentity("工作名称", "工作组")
                .usingJobData("job_key1", "jobvalue1")
                .usingJobData("job_key2", "jobvalue2")
                .build();

        // 创建触发器
        Trigger trigger = TriggerBuilder.newTrigger()
                .withDescription("触发器描述")
                .withIdentity("触发器名称", "触发器的组")
                .usingJobData("trigger1", "value1")
                .usingJobData("trigger2", "value2")
                // "0/5 11 * ? * *"表达式
                // SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(60).repeatForever() 每60秒触发一次
                .withSchedule(CronScheduleBuilder.cronSchedule(("0/5 * * ? * *")))
                // 不设置，默认为当前时间
                .startAt(new Date())
                .build();

        // 创建调度器
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.scheduleJob(jobDetail, trigger);

        // 启动调度器
        scheduler.start();
    }
}
