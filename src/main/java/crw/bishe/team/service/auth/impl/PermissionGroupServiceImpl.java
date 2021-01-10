package crw.bishe.team.service.auth.impl;

import crw.bishe.team.entity.auth.PermissionGroup;
import crw.bishe.team.mapper.auth.PermissionGroupMapper;
import crw.bishe.team.service.auth.IPermissionGroupService;
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
public class PermissionGroupServiceImpl extends ServiceImpl<PermissionGroupMapper, PermissionGroup> implements IPermissionGroupService {

    @Override
    public  IPage<PermissionGroup> findListByPage(Integer page, Integer pageCount){
        IPage<PermissionGroup> wherePage = new Page<>(page, pageCount);
        PermissionGroup where = new PermissionGroup();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(PermissionGroup permissionGroup){
        return baseMapper.insert(permissionGroup);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(PermissionGroup permissionGroup){
        return baseMapper.updateById(permissionGroup);
    }

    @Override
    public PermissionGroup findById(Long id){
        return  baseMapper.selectById(id);
    }
}
