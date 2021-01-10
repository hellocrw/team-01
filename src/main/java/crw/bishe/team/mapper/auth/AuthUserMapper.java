package crw.bishe.team.mapper.auth;

import crw.bishe.team.entity.auth.AuthUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *   Mapper 接口
 * </p>
 *
 * @author caorongwu
 * @since 2021-01-10
 */
public interface AuthUserMapper extends BaseMapper<AuthUser> {

    AuthUser getByNum(String id);

}
