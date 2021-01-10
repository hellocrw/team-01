package crw.bishe.team.service.auth.impl;

import crw.bishe.team.entity.auth.AuthPermission;
import crw.bishe.team.mapper.auth.AuthPermissionMapper;
import crw.bishe.team.service.auth.IAuthPermissionService;
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
public class AuthPermissionServiceImpl extends ServiceImpl<AuthPermissionMapper, AuthPermission> implements IAuthPermissionService {

    @Override
    public  IPage<AuthPermission> findListByPage(Integer page, Integer pageCount){
        IPage<AuthPermission> wherePage = new Page<>(page, pageCount);
        AuthPermission where = new AuthPermission();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(AuthPermission authPermission){
        return baseMapper.insert(authPermission);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(AuthPermission authPermission){
        return baseMapper.updateById(authPermission);
    }

    @Override
    public AuthPermission findById(Long id){
        return  baseMapper.selectById(id);
    }
}
