package crw.bishe.team.service.auth.impl;

import crw.bishe.team.entity.auth.UserRole;
import crw.bishe.team.mapper.auth.UserRoleMapper;
import crw.bishe.team.service.auth.IUserRoleService;
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
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {

    @Override
    public  IPage<UserRole> findListByPage(Integer page, Integer pageCount){
        IPage<UserRole> wherePage = new Page<>(page, pageCount);
        UserRole where = new UserRole();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(UserRole userRole){
        return baseMapper.insert(userRole);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(UserRole userRole){
        return baseMapper.updateById(userRole);
    }

    @Override
    public UserRole findById(Long id){
        return  baseMapper.selectById(id);
    }
}
