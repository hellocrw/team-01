package crw.bishe.team.mapper;

import crw.bishe.team.dto.ApplyDto;
import crw.bishe.team.entity.Apply;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ApplyMapper extends Mapper<Apply> {

    /**
     * 根据用户ID获取申请信息： 获取自己的申请信息
     * @param userId
     * @return
     */
    @Select("SELECT apply.* FROM apply WHERE apply.`user_id`= #{userId};")
    List<ApplyDto> getApplyByUserId(Long userId);

    /**
     * 根据用户ID获取申请信息： 获取别人入队的申请信息
     * userId  --select--> teamIds  --select-->  applys
     * @param userId
     * @return
     */
    @Select("SELECT apply.* FROM apply WHERE apply.`status` = 0 AND apply.`team_id` IN (SELECT team.`team_id` FROM team WHERE team.`leader_id` = #{userId})")
    List<ApplyDto> getEnqueueApply(Long userId);

    /**
     * 根据团队ID删除申请信息
     * teamId --delete--> applys
     * @param teamId
     * @return
     */
    @Delete("DELETE FROM apply WHERE team_id = #{teamId}")
    Integer deleteByTeamId(Long teamId);

    /**
     * 同意入队
     * @param applyId
     * @return
     */
    @Update("UPDATE apply SET apply.`status`=1 WHERE apply.`apply_id`=#{applyId}")
    Integer agreeApply(Long applyId);

    /**
     * 拒绝入队
     * @param applyId
     * @return
     */
    @Update("UPDATE apply SET apply.`status`=2 WHERE apply.`apply_id`=#{applyId}")
    Integer disagreeApply(Long applyId);
}