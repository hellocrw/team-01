package crw.bishe.team.service.auth;

import crw.bishe.team.dto.UserRegisterDto;
import crw.bishe.team.entity.auth.AuthUser;
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
public interface IAuthUserService extends IService<AuthUser> {

    /**
     * 查询 分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<AuthUser>
     */
    IPage<AuthUser> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param authUser
     * @return int
     */
    int add(AuthUser authUser);

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
     * @param authUser  
     * @return int
     */
    int updateData(AuthUser authUser);

    /**
     * id查询数据
     *
     * @param id id
     * @return AuthUser
     */
    AuthUser findById(Long id);

    AuthUser selectByUsername(String username);

    String register(UserRegisterDto userRegisterDto);
}
