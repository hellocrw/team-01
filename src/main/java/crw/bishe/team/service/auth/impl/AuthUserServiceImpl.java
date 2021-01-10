package crw.bishe.team.service.auth.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import crw.bishe.team.entity.auth.AuthUser;
import crw.bishe.team.mapper.auth.AuthUserMapper;
import crw.bishe.team.service.auth.IAuthUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * <p>
 *   服务实现类
 * </p>
 *
 * @author caorongwu
 * @since 2021-01-10
 */
@Service
public class AuthUserServiceImpl extends ServiceImpl<AuthUserMapper, AuthUser> implements IAuthUserService {

    @Override
    public  IPage<AuthUser> findListByPage(Integer page, Integer pageCount){
        IPage<AuthUser> wherePage = new Page<>(page, pageCount);
        AuthUser where = new AuthUser();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(AuthUser authUser){
        return baseMapper.insert(authUser);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(AuthUser authUser){
        return baseMapper.updateById(authUser);
    }

    @Override
    public AuthUser findById(Long id){
        return  baseMapper.selectById(id);
    }

    @Override
    public AuthUser selectByUsername(String username) {
        AuthUser authUser = baseMapper.selectOne(new QueryWrapper<AuthUser>().eq("USER_NAME", username));
        return authUser;
    }

}
