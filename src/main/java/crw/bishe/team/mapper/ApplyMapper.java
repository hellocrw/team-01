package crw.bishe.team.mapper;

import crw.bishe.team.dto.ApplyDto;
import crw.bishe.team.entity.Apply;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ApplyMapper extends Mapper<Apply> {

    /**
     * 根据用户ID获取申请信息
     * @param userId
     * @return
     */
    @Select("SELECT apply.* FROM apply WHERE apply.`user_id`= #{userId};")
    List<ApplyDto> getApplyByUserId(Long userId);
}