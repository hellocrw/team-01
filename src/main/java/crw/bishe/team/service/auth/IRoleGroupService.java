package crw.bishe.team.service.auth;

import crw.bishe.team.entity.auth.RoleGroup;
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
public interface IRoleGroupService extends IService<RoleGroup> {

    /**
     * 查询 分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<RoleGroup>
     */
    IPage<RoleGroup> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加 
     *
     * @param roleGroup  
     * @return int
     */
    int add(RoleGroup roleGroup);

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
     * @param roleGroup  
     * @return int
     */
    int updateData(RoleGroup roleGroup);

    /**
     * id查询数据
     *
     * @param id id
     * @return RoleGroup
     */
    RoleGroup findById(Long id);
}
