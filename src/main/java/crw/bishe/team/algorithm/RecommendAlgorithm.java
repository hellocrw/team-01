package crw.bishe.team.algorithm;

import crw.bishe.team.dto.TeamDto;
import crw.bishe.team.mapper.TeamTypeMapper;
import crw.bishe.team.service.TeamService;
import crw.bishe.team.service.UserItemRemarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @Description Description 推荐算法
 * @Author crw
 * @Date Created in 2020/2/15 0015
 * @Time 14:51
 */
@Component("recommendAlgorithm")
public class RecommendAlgorithm {
    
    private final static int MAX_TEAM_NUMBER = 5;  // 推荐团队最大数量
    
    @Autowired
    private TeamService teamService;

    @Autowired
    private UserItemRemarkService userItemRemarkService;

    @Autowired
    private TeamTypeMapper teamTypeMapper;

    /**
     * 通过用户id对数据预处理
     * 主要是获取用户匹配符合的团队类型
     * @param userId
     */
    public String preProcess(String userId){
        List<Map<String, Long>> mapList = userItemRemarkService.getTeamTypeNum(userId);
        // 获取map的value最大的key
        Map<String, Long> max = new HashMap<>();
        max.put("team_type_num", 0L);
        for (int i = 0; i < mapList.size(); i++) {
            if (mapList.get(i).get("team_type_num") >  max.get("team_type_num")){
                max = mapList.get(i);
            }
        }
        return teamTypeMapper.getValueByKey(max.get("team_type_id"));
    }

    /**
     * 筛选数据，按类型以及所在学校推荐
     * @param userId 用户ID
     * @param university 用户所在学校
     * @param teamType 用户的团队类型
     * @return 团队数
     */
    public List<TeamDto> remcommendTeam(String userId, String university, String teamType){
        int index = 0;
        List<TeamDto> teamDtos = teamService.getTeamByTeamType(teamType);
        while (teamDtos.size() > MAX_TEAM_NUMBER){
            for (int i = index; i < teamDtos.size(); i++) {
                if (teamDtos.get(i).getTeamScope() != university){
                    teamDtos.remove(i);
                    index = i++;
                    break;
                }
            }
        }
        return teamDtos;
    }

}
