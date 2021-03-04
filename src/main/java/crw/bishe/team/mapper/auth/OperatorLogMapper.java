package crw.bishe.team.mapper.auth;

import crw.bishe.team.entity.auth.OperatorLog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *   Mapper 接口
 * </p>
 *
 * @author caorongwu
 * @since 2021-01-10
 */
public interface OperatorLogMapper extends BaseMapper<OperatorLog> {

    /**
     * 获取当前在线的用户数量
     * @return
     */
    Long getOnlineUser();

}