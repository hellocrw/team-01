package temp.code.fail.quartz;

import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.quartz.impl.triggers.CronTriggerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 *
 * Quartz任务调度工具类
 * @author: weiyongxuan
 * @mail: weiyongxuan@ly-sky.com
 * @date: 2019年5月30日
 * @version: 1.0
 *
 */
@Component
@Slf4j
public class QuartzUtils {

    // 任务调度
    @Autowired
    private Scheduler scheduler;
    
    /**
     * 开始执行所有任务
     * 
     * @throws SchedulerException
     */
    public void startAllJob() throws SchedulerException {
        scheduler.resumeAll();
        scheduler.start();
    }

    /**
     * 开始执行一个新的任务
     * @param name 任务编号
     * @param group 任务分组
     * @param jobDetail jobDetail
     * @param cronTrigger cron表达式
     * @return String
     * @throws SchedulerException
     */
    public Boolean startJob(String name, String group, JobDetail jobDetail, Trigger cronTrigger) throws SchedulerException {
        JobKey jobKey = new JobKey(name, group);
        JobDetail tryJobDetail = scheduler.getJobDetail(jobKey);
        if (tryJobDetail != null){
            log.info("该任务已存在，编号："+name);
            return false;            
        }
        scheduler.scheduleJob(jobDetail, cronTrigger);
        scheduler.start();
        log.info("已添加一个新任务，编号："+name);
        return true;
    }

    /**
     * 获取Job信息
     * 
     * @param name 任务编号
     * @param group 任务分组
     * @return String
     * @throws SchedulerException
     */
    public String getJobInfo(String name, String group) throws SchedulerException {
        TriggerKey triggerKey = new TriggerKey(name, group);
        CronTrigger cronTrigger = (CronTrigger) scheduler.getTrigger(triggerKey);
        if(cronTrigger!=null){
        	 return String.format("time:%s,state:%s", cronTrigger.getCronExpression(),
                     scheduler.getTriggerState(triggerKey).name());
        }else
        {
        	return "";
        }
       
    }

    /**
     * 获取所有的Job信息
     * @return
     */
    public List<String> getAllJobInfo() throws SchedulerException{
        List<String> TriggerGroupNamesList = scheduler.getTriggerGroupNames();
        if(TriggerGroupNamesList!=null){
            TriggerGroupNamesList.remove("ordinaryTask");
            TriggerGroupNamesList.remove("loopTask");
            return TriggerGroupNamesList;
        }else {
            return null;
        }
    }


    /**
     * 修改任务的执行时间
     * 
     * @param name 任务编号
     * @param group 任务分组
     * @param time 新的Cron表达式
     * @return String
     * @throws SchedulerException
     */
    public boolean modifyJob(String name, String group, String time) throws SchedulerException {
        Date date = null;
        TriggerKey triggerKey = new TriggerKey(name, group);
        CronTrigger cronTrigger = (CronTrigger) scheduler.getTrigger(triggerKey);
        String oldTime = cronTrigger.getCronExpression();
        if (!oldTime.equalsIgnoreCase(time)) {
            CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(time);
            CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(name, group)
                    .withSchedule(cronScheduleBuilder).build();
            date = scheduler.rescheduleJob(triggerKey, trigger);
        }
        return date != null;
    }

    /**
     * 暂停所有任务
     * 
     * @throws SchedulerException
     */
    public void pauseAllJob() throws SchedulerException {
        scheduler.pauseAll();
    }

    /**
     * 暂停某个任务
     * 
     * @param name 任务编号
     * @param group 任务分组
     * @throws SchedulerException
     */
    public Boolean pauseJob(String name, String group) throws SchedulerException {
        JobKey jobKey = new JobKey(name, group);
        JobDetail jobDetail = scheduler.getJobDetail(jobKey);
        if (jobDetail == null){
            log.info("不存在此任务，编号："+name);
            return false;            
        }
        scheduler.pauseJob(jobKey);
        log.info("该任务已经暂停，编号："+name);
        return true;
    }

    /**
     * 恢复所有任务
     * 
     * @throws SchedulerException
     */
    public void resumeAllJob() throws SchedulerException {
        scheduler.resumeAll();
    }

    /**
     * 恢复某个任务
     * 
     * @param name 任务编号
     * @param group 任务分组
     * @return Boolean
     * @throws SchedulerException
     */
    public Boolean resumeJob(String name, String group) throws SchedulerException {
        JobKey jobKey = new JobKey(name, group);
        JobDetail jobDetail = scheduler.getJobDetail(jobKey);
        if (jobDetail == null){
            log.info("该任务不存在，编号："+name);
            return false;            
        }
        scheduler.resumeJob(jobKey);
        log.info("该任务已经恢复，编号："+name);
        return true;
    }

    /**
     * 删除某个任务
     * 
     * @param name 任务编号
     * @param group 任务分组
     * @return Boolean
     * @throws SchedulerException
     */
    public Boolean deleteJob(String name, String group) throws SchedulerException {
        JobKey jobKey = new JobKey(name, group);
        JobDetail jobDetail = scheduler.getJobDetail(jobKey);
        if (jobDetail == null){
            log.info("该任务不存在，编号："+name);
            return false;
        }

        scheduler.deleteJob(jobKey);
        log.info("该任务已删除，编号："+name);
        return true;
    }
    
    /**
     * 
     * Method Name:  isValidExpression
     * Description:  校验cron表达式是否有效
     * @param cronExpression
     * @return 
     * @return boolean
     * @exception 	
     * @author lizhenwei
     * @mail lizhenwei@ly-sky.com
     * @date: 2020年9月21日
     */
    public Boolean isValidExpression(String cronExpression) {
        CronTriggerImpl trigger =new CronTriggerImpl();
        try {
            trigger.setCronExpression(cronExpression);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Date date =trigger.computeFirstFireTime(null);
        return date != null;
    }
}