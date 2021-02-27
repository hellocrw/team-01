package crw.bishe.team.service.user;

import crw.bishe.team.entity.user.BolgUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * 用户信息表 服务类
 * </p>
 *
 * @author caorongwu
 * @since 2021-02-27
 */
public interface IBolgUserService extends IService<BolgUser> {

    /**
     * 查询用户信息表分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<BolgUser>
     */
    IPage<BolgUser> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加用户信息表
     *
     * @param bolgUser 用户信息表
     * @return int
     */
    int add(BolgUser bolgUser);

    /**
     * 删除用户信息表
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改用户信息表
     *
     * @param bolgUser 用户信息表
     * @return int
     */
    int updateData(BolgUser bolgUser);

    /**
     * id查询数据
     *
     * @param id id
     * @return BolgUser
     */
    BolgUser findById(Long id);
}
