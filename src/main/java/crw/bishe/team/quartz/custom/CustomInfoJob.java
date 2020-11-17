package crw.bishe.team.quartz.custom;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class CustomInfoJob implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        JobDataMap dataMap = context.getJobDetail().getJobDataMap();

        String xhrwbh = dataMap.getString("rwbh");
        String xxjsr = dataMap.getString("xxjsr");

        // TODO　调度业务处理
    }
}
