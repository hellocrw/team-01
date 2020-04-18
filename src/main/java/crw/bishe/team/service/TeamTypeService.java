package crw.bishe.team.service;

import java.util.List;
import java.util.Map;

public interface TeamTypeService {
    /**
     * 通过key获取value
     * @param key
     * @return
     */
    String getValueByKey(String key);

    /**
     * 获取团队类型数量
     * @param userId
     * @return
     */
    List<Map<String, Object>> getTeamTypeNumber(String userId);

    /**
     * 通过userId获取项目分析数据
     * @param userId
     * @return
     */
    List<Map<String, Object>> getProTypeNumber(String userId);

    /**
     * 通过userId获取任务分析数据
     * @param userId
     * @return
     */
    List<Map<String, Object>> getTaskTypeNumber(String userId);
}
