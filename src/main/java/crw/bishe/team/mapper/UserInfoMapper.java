package crw.bishe.team.mapper;

import crw.bishe.team.dto.UserDto;
import crw.bishe.team.entity.UserInfo;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface UserInfoMapper extends Mapper<UserInfo> {

    /**
     * 根据用户ID获取用户信息
     * @param userId
     * @return
     */
    @Select("SELECT user_info.* FROM user_info WHERE user_info.`user_id` = #{userId}")
    UserDto getUserInfoByUserId(Long userId);

}