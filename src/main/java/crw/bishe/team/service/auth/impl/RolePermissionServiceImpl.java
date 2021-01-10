package crw.bishe.team.service.auth.impl;

import crw.bishe.team.entity.auth.RolePermission;
import crw.bishe.team.mapper.auth.RolePermissionMapper;
import crw.bishe.team.service.auth.IRolePermissionService;
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
public class RolePermissionServiceImpl extends ServiceImpl<RolePermissionMapper, RolePermission> implements IRolePermissionService {

    @Override
    public  IPage<RolePermission> findListByPage(Integer page, Integer pageCount){
        IPage<RolePermission> wherePage = new Page<>(page, pageCount);
        RolePermission where = new RolePermission();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(RolePermission rolePermission){
        return baseMapper.insert(rolePermission);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(RolePermission rolePermission){
        return baseMapper.updateById(rolePermission);
    }

    @Override
    public RolePermission findById(Long id){
        return  baseMapper.selectById(id);
    }
}
