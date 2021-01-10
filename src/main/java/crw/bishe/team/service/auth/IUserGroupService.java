package crw.bishe.team.service.auth;

import crw.bishe.team.entity.auth.UserGroup;
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
public interface IUserGroupService extends IService<UserGroup> {

    /**
     * 查询 分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<UserGroup>
     */
    IPage<UserGroup> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加 
     *
     * @param userGroup  
     * @return int
     */
    int add(UserGroup userGroup);

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
     * @param userGroup  
     * @return int
     */
    int updateData(UserGroup userGroup);

    /**
     * id查询数据
     *
     * @param id id
     * @return UserGroup
     */
    UserGroup findById(Long id);
}
