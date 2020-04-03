package crw.bishe.team.algorithm;

import crw.bishe.team.dto.TeamDto;
import crw.bishe.team.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;

/**
 * @Description Description 推荐算法
 * @Author crw
 * @Date Created in 2020/2/15 0015
 * @Time 14:51
 */
public class RecommendAlgorithm {
    
    private final static int MAX_TEAM_NUMBER = 10;  // 推荐团队最大数量
    
    @Autowired
    private TeamService teamService;

    /**
     * 通过用户id对数据预处理
     * @param userId
     */
    public void preProcess(Long userId){

    }

    /**
     * 按类型以及所在学校推荐
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
