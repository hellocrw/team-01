package crw.bishe.team.service.auth.impl;

import crw.bishe.team.entity.auth.AuthRole;
import crw.bishe.team.mapper.auth.AuthRoleMapper;
import crw.bishe.team.service.auth.IAuthRoleService;
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
public class AuthRoleServiceImpl extends ServiceImpl<AuthRoleMapper, AuthRole> implements IAuthRoleService {

    @Override
    public  IPage<AuthRole> findListByPage(Integer page, Integer pageCount){
        IPage<AuthRole> wherePage = new Page<>(page, pageCount);
        AuthRole where = new AuthRole();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(AuthRole authRole){
        return baseMapper.insert(authRole);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(AuthRole authRole){
        return baseMapper.updateById(authRole);
    }

    @Override
    public AuthRole findById(Long id){
        return  baseMapper.selectById(id);
    }
}
