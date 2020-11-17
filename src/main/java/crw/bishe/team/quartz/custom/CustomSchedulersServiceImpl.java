package crw.bishe.team.quartz.custom;

import crw.bishe.team.quartz.QuartzUtils;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.SchedulerException;
import org.quartz.TriggerKey;
import org.quartz.impl.triggers.CronTriggerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

@Service
public class CustomSchedulersServiceImpl implements CustomSchedulersService{

	
	@Autowired
    private QuartzUtils quartzUtils;
	
	@Override
	public Boolean startJob(String rwbh, String cronExpression,String name,String group,String xxjsr) throws SchedulerException {

		if(quartzUtils.isValidExpression(cronExpression)){

            //把之后要存入普通任务表的数据存入
            JobDetail jobDetail = JobBuilder
                    .newJob(CustomInfoJob.class)
                    .withIdentity(name, group)
                    .usingJobData("rwbh", rwbh)
					.usingJobData("xxjsr", xxjsr)
                    .build();

            //作业触发器
            //CronTrigger
            CronTriggerImpl trigger=new CronTriggerImpl();
            try {
                trigger.setCronExpression(cronExpression);
            } catch (ParseException e1) {
                e1.printStackTrace();
            }

            TriggerKey triggerKey = new TriggerKey(name,group);
            trigger.setKey(triggerKey);
            
            return quartzUtils.startJob(name, group, jobDetail, trigger);


		}else{
			return false;
		}
		
		
	}

	@Override
	public Boolean pauseJob(String name, String group) throws SchedulerException {
		return quartzUtils.pauseJob(name, group);
	}

	@Override
	public Boolean resumeJob(String name, String group) throws SchedulerException {
		return quartzUtils.resumeJob(name, group);
	}

	@Override
	public Boolean deleteJob(String name, String group) throws SchedulerException {
		return quartzUtils.deleteJob(name, group);
	}
	
	@Override
	public String getJobInfo(String name, String group) throws SchedulerException {
		return quartzUtils.getJobInfo(name, group);
	}

	@Override
	public List<String> getAllJobInfo() throws SchedulerException {
		return quartzUtils.getAllJobInfo();
	}
}
