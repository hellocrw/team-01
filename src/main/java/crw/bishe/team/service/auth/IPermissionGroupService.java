package crw.bishe.team.service.auth;

import crw.bishe.team.entity.auth.PermissionGroup;
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
public interface IPermissionGroupService extends IService<PermissionGroup> {

    /**
     * 查询 分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<PermissionGroup>
     */
    IPage<PermissionGroup> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加 
     *
     * @param permissionGroup  
     * @return int
     */
    int add(PermissionGroup permissionGroup);

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
     * @param permissionGroup  
     * @return int
     */
    int updateData(PermissionGroup permissionGroup);

    /**
     * id查询数据
     *
     * @param id id
     * @return PermissionGroup
     */
    PermissionGroup findById(Long id);
}
