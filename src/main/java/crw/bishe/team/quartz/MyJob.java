package crw.bishe.team.quartz;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

public class MyJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        JobDataMap jobDataMap = jobExecutionContext.getJobDetail().getJobDataMap();

        System.out.println(jobExecutionContext.getJobDetail().getKey().getGroup());

        System.out.println(new Date());

        System.out.println("MyJob execute...");

        System.out.println(jobDataMap.getString("job_key1") + "===and===" + jobDataMap.getString("job_key2"));

    }
}
