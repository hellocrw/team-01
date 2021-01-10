package crw.bishe.team.service.auth;

import crw.bishe.team.entity.auth.AuthPermission;
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
public interface IAuthPermissionService extends IService<AuthPermission> {

    /**
     * 查询 分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<AuthPermission>
     */
    IPage<AuthPermission> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加 
     *
     * @param authPermission  
     * @return int
     */
    int add(AuthPermission authPermission);

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
     * @param authPermission  
     * @return int
     */
    int updateData(AuthPermission authPermission);

    /**
     * id查询数据
     *
     * @param id id
     * @return AuthPermission
     */
    AuthPermission findById(Long id);
}
