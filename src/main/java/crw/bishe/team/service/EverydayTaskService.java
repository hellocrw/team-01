package crw.bishe.team.service;

import crw.bishe.team.entity.EverydayTask;

import java.util.List;

public interface EverydayTaskService {
    /**
     * 添加每天任务
     */
    Integer createEverydayTask(EverydayTask everydayTask);

    /**
     * 获取当天任务信息
     * @param userId
     * @return
     */
    List<EverydayTask> qureyEverydayTask(String userId);

    /**
     * 每天打卡
     * @param userId
     * @param everydayTaskId
     * @return
     */
    Integer clock(String userId, String everydayTaskId);

    /**
     * 删除每日打卡任务
     * @param everydayTaskId 每天打卡任务ID
     * @return
     */
    Integer deleteTask(String everydayTaskId);
}
