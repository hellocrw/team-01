package crw.bishe.team.service.auth;

import crw.bishe.team.entity.auth.AuthRole;
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
public interface IAuthRoleService extends IService<AuthRole> {

    /**
     * 查询 分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<AuthRole>
     */
    IPage<AuthRole> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加 
     *
     * @param authRole  
     * @return int
     */
    int add(AuthRole authRole);

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
     * @param authRole  
     * @return int
     */
    int updateData(AuthRole authRole);

    /**
     * id查询数据
     *
     * @param id id
     * @return AuthRole
     */
    AuthRole findById(Long id);
}
