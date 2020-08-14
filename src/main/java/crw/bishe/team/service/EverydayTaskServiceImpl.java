package crw.bishe.team.service;

import cn.hutool.core.convert.Convert;
import crw.bishe.team.entity.EverydayTask;
import crw.bishe.team.entity.StudyPlan;
import crw.bishe.team.mapper.EverydayTaskMapper;
import crw.bishe.team.mapper.StudyPlanMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class EverydayTaskServiceImpl implements EverydayTaskService {

    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Resource
    private EverydayTaskMapper everydayTaskMapper;

    @Resource
    public StudyPlanMapper studyPlanMapper;

    @Override
    public Integer createEverydayTask(EverydayTask everydayTask) {
        return everydayTaskMapper.insert(everydayTask);
    }

    @Override
    public List<EverydayTask> qureyEverydayTask(String userId) {
        Long key = Long.parseLong(userId);
        List<EverydayTask> everydayTasks = everydayTaskMapper.qureyEverydayTask(key);
        // 筛选出今天未完成的任务
        List<EverydayTask> everydayTaskList = new ArrayList<>();
        // 获取今天凌晨5点的时间
        Long currentTimestamps = System.currentTimeMillis();
        Long oneDayTimestamps = Long.valueOf(60*60*24*1000);
        Long Deadline = currentTimestamps - (currentTimestamps+60*60*3*1000)%oneDayTimestamps;
        System.out.println("Deadline：" + new Date(Deadline));
        everydayTasks.forEach( item -> {
            // 1. 打卡时间不是当天时间
            if (item.getClockTime() == null || item.getClockTime().getTime() < Deadline){
                everydayTaskList.add(item);
            }
        });

        return everydayTaskList;
    }

    @Override
    public Integer clock(String userId, String everydayTaskId) {
        Long user_id = Long.parseLong(userId);
        Long everyday_task_id = Long.parseLong(everydayTaskId);
        Integer res = everydayTaskMapper.updateClockTime(user_id, everyday_task_id);
        // 将今日完成的任务添加到学习任务中
        EverydayTask everydayTask =everydayTaskMapper.selectByPrimaryKey(everyday_task_id);
        StudyPlan studyPlan = new StudyPlan();
        studyPlan.setSpTime(new Date());
        studyPlan.setSpTitle(everydayTask.getContent());
        studyPlan.setSpContext("每天任务");
        studyPlan.setUserId(everydayTask.getUserId());
        studyPlan.setSpLink("http://120.79.191.236/#/team");
        studyPlanMapper.insert(studyPlan);
        return res;
    }

    @Override
    public Integer deleteTask(String everydayTaskId) {
        Long everydayId = Convert.toLong(everydayTaskId);
        return everydayTaskMapper.deleteByPrimaryKey(everydayId);
    }
}
