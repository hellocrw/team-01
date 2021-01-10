package crw.bishe.team.service.auth;

import crw.bishe.team.entity.auth.RolePermission;
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
public interface IRolePermissionService extends IService<RolePermission> {

    /**
     * 查询 分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<RolePermission>
     */
    IPage<RolePermission> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加 
     *
     * @param rolePermission  
     * @return int
     */
    int add(RolePermission rolePermission);

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
     * @param rolePermission  
     * @return int
     */
    int updateData(RolePermission rolePermission);

    /**
     * id查询数据
     *
     * @param id id
     * @return RolePermission
     */
    RolePermission findById(Long id);
}
