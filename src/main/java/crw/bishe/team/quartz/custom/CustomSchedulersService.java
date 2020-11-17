package crw.bishe.team.quartz.custom;

import org.quartz.SchedulerException;

import java.util.List;

public interface CustomSchedulersService {

	/**
	 * 
	 * Method Name:  startJob
	 * Description:  启动调度
	 * @param rwbh
	 * @param cronExpression 
	 * @return void
	 * @exception 	
	 * @author lizhenwei
	 * @mail lizhenwei@ly-sky.com
	 * @date: 2020年9月21日
	 */
	public Boolean startJob(String rwbh, String cronExpression, String name, String group, String xxjsr) throws SchedulerException;

	/**
	 * 
	 * Method Name:  pauseJob
	 * Description:  暂停任务
	 * @param name
	 * @param group
	 * @return
	 * @throws SchedulerException 
	 * @return Boolean
	 * @exception 	
	 * @author lizhenwei
	 * @mail lizhenwei@ly-sky.com
	 * @date: 2020年9月21日
	 */
	public Boolean pauseJob(String name, String group) throws SchedulerException;
	
	/**
	 * 
	 * Method Name:  resumeJob
	 * Description:  恢复任务
	 * @param name
	 * @param group
	 * @return
	 * @throws SchedulerException 
	 * @return Boolean
	 * @exception 	
	 * @author lizhenwei
	 * @mail lizhenwei@ly-sky.com
	 * @date: 2020年9月21日
	 */
	public Boolean resumeJob(String name, String group) throws SchedulerException;
	
	/**
	 * 
	 * Method Name:  deleteJob
	 * Description:  删除任务
	 * @param name
	 * @param group
	 * @return
	 * @throws SchedulerException 
	 * @return Boolean
	 * @exception 	
	 * @author lizhenwei
	 * @mail lizhenwei@ly-sky.com
	 * @date: 2020年9月21日
	 */
	public Boolean deleteJob(String name, String group) throws SchedulerException;
	
	/**
	 * 
	 * Method Name:  getJobInfo
	 * Description: 查询调度信息 
	 * @param name
	 * @param group
	 * @return
	 * @throws SchedulerException 
	 * @return String
	 * @exception 	
	 * @author lizhenwei
	 * @mail lizhenwei@ly-sky.com
	 * @date: 2020年9月21日
	 */
	public String getJobInfo(String name, String group) throws SchedulerException;

	/**
	 *
	 * Method Name:  getAllJobInfo
	 * Description: 查询所有调度信息
	 * @return
	 * @throws SchedulerException
	 * @return List<String>
	 * @exception
	 * @author zhangying
	 * @mail zhangying@ly-sky.com
	 * @date: 2020年9月29日
	 */
	public List<String> getAllJobInfo() throws SchedulerException;
}
