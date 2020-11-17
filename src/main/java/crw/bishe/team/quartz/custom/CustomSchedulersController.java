package crw.bishe.team.quartz.custom;

import crw.bishe.team.utils.WebResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 
 * Class Name: CustomSchedulers  
 * Description: 
 * @author: lizhenwei
 * @mail: lizhenwei@ly-sky.com 
 * @date: 2020年9月21日
 * @version: 1.0
 *
 */
@Api(value = "自定义调度控制器", tags = {"自定义调度控制器"})
@RestController
@RequestMapping("/customSchedulers")
public class CustomSchedulersController {
	
	@Autowired
    private CustomSchedulersService customSchedulersService;
	
	@ApiOperation(value = "启动任务")
	@PostMapping("/startTask")
	public WebResponse<Boolean> startTask(@ApiParam(value = "任务编号") @RequestParam("rwbh") String rwbh, @ApiParam(value = "corn表达式") @RequestParam("cronExpression") String cronExpression, @ApiParam(value = "jobKey/triggerKey") @RequestParam("name") String name, @ApiParam(value = "jobGroup/triggerGroup") @RequestParam("group") String group, @ApiParam(value = "消息接收人,1:责任人和校办联系秘书，2：分管领导和校办联系秘书") @RequestParam("xxfslx")String xxjsr) throws SchedulerException {
		return new WebResponse<Boolean>().success(customSchedulersService.startJob(rwbh, cronExpression, name, group,xxjsr));
	}

	@ApiOperation(value = "暂停任务")
	@PostMapping("/pauseJob")
	public WebResponse<Boolean> pauseJob(@ApiParam(value = "jobKey/triggerKey") @RequestParam("name") String name, @ApiParam(value = "jobGroup/triggerGroup") @RequestParam("group") String group) throws SchedulerException {
	    return new WebResponse<Boolean>().success(customSchedulersService.pauseJob(name, group));
	}
	
	@ApiOperation(value = "恢复任务【注意：会补发暂停期间错过的调度，如果不想补发可以先删除重新启动】")
	@PostMapping("/resumeJob")
	public WebResponse<Boolean> resumeJob(@ApiParam(value = "jobKey/triggerKey") @RequestParam("name") String name, @ApiParam(value = "jobGroup/triggerGroup") @RequestParam("group") String group) throws SchedulerException {
	    return new WebResponse<Boolean>().success(customSchedulersService.resumeJob(name, group));
	}
	
	@ApiOperation(value = "删除任务")
	@PostMapping("/deleteJob")
	public WebResponse<Boolean> deleteJob(@ApiParam(value = "jobKey/triggerKey") @RequestParam("name") String name, @ApiParam(value = "jobGroup/triggerGroup") @RequestParam("group") String group) throws SchedulerException {
	    return new WebResponse<Boolean>().success(customSchedulersService.deleteJob(name, group));
	}
	
	@ApiOperation(value = "获取任务信息")
	@PostMapping("/getJobInfo")
	public WebResponse<String> getJobInfo(@ApiParam(value = "jobKey/triggerKey") @RequestParam("name") String name, @ApiParam(value = "jobGroup/triggerGroup") @RequestParam("group") String group) throws SchedulerException {
	    return new WebResponse<String>().success(customSchedulersService.getJobInfo(name, group));
	}

	@ApiOperation(value = "获取所有任务信息")
	@PostMapping("/getAllJobInfo")
	public WebResponse<List<String>> getAllJobInfo() throws SchedulerException {
		return new WebResponse<List<String>>().success(customSchedulersService.getAllJobInfo());
	}

}
