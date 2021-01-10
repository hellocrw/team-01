package crw.bishe.team.service.auth;

import crw.bishe.team.entity.auth.OperatorLog;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 *   服务类
 * </p>
 *
 * @author caorongwu
 * @since 2021-01-10
 */
public interface IOperatorLogService extends IService<OperatorLog> {

    /**
     * 查询 分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<OperatorLog>
     */
    IPage<OperatorLog> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加 
     *
     * @param operatorLog  
     * @return int
     */
    int add(OperatorLog operatorLog);

    /**
     * 删除 
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改 
     *
     * @param operatorLog  
     * @return int
     */
    int updateData(OperatorLog operatorLog);

    /**
     * id查询数据
     *
     * @param id id
     * @return OperatorLog
     */
    OperatorLog findById(Long id);
}
