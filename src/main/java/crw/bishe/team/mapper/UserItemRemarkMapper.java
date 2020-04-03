package crw.bishe.team.mapper;

import crw.bishe.team.entity.UserItemRemark;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface UserItemRemarkMapper extends Mapper<UserItemRemark> {

    @Select("SELECT user_id, team_type_id, COUNT(team_type_id) AS team_type_num FROM user_item_remark\n" +
            "WHERE user_id = 1\n" +
            "GROUP BY team_type_id;")
    List<Map<String, Object>> getTeamTypeNum(Long userId);
}