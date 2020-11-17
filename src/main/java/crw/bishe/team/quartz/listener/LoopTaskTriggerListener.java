package crw.bishe.team.quartz.listener;

import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.Trigger;
import org.quartz.Trigger.CompletedExecutionInstruction;
import org.quartz.TriggerListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@Slf4j
public class LoopTaskTriggerListener implements TriggerListener {
    // 时间格式，例：2019-06-03 10:30:20
    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    // 监听器的名字，必须有个名字
    public static final String LISTENER_NAME = "LoopTaskTriggerListener";
    
    public LoopTaskTriggerListener() {

    }

    @Override
    public String getName() {
        return LISTENER_NAME;
    }

    @Override
    public void triggerFired(Trigger trigger, JobExecutionContext context) {

    }

    @Override
    public boolean vetoJobExecution(Trigger trigger, JobExecutionContext context) {
        return false;
    }

    @Override
    @Transactional
    public void triggerMisfired(Trigger trigger) {
        String rwbh = trigger.getJobKey().getName();
        Date fireTime = trigger.getNextFireTime();
        // 当有一次调度没有发生，就把这次调度存入调度提醒表，告知客户
        log.warn("循环任务" + rwbh + "触发失败，时间点：" + simpleDateFormat.format(fireTime));
    }

    @Override
    @Transactional
    public void triggerComplete(Trigger trigger, JobExecutionContext context, CompletedExecutionInstruction triggerInstructionCode) {
        String jobName = trigger.getJobKey().getName();
        log.info("调度任务" + jobName + "成功执行一次。");
    }

}