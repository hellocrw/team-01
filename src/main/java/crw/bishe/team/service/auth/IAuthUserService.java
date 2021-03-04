package crw.bishe.team.service.auth;

import crw.bishe.team.dto.AlterPasswordDto;
import crw.bishe.team.dto.UserRegisterDto;
import crw.bishe.team.entity.auth.AuthUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

import javax.servlet.http.HttpServletRequest;

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

    /**
     * 用户注册
     * @param userRegisterDto
     * @return
     */
    String register(UserRegisterDto userRegisterDto);

    /**
     * 修改密码
     * @param alterPasswordDto
     * @return
     */
    String alterPassword(AlterPasswordDto alterPasswordDto, HttpServletRequest request);

    /**
     * 获取当前在线的用户
     * @return
     */
    Long getOnlineUser();

    /**
     * 获取系统用户总数
     * @return
     */
    Long getAllUsers();
}