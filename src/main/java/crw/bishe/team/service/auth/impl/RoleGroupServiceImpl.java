package crw.bishe.team.service.auth.impl;

import crw.bishe.team.entity.auth.RoleGroup;
import crw.bishe.team.mapper.auth.RoleGroupMapper;
import crw.bishe.team.service.auth.IRoleGroupService;
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
public class RoleGroupServiceImpl extends ServiceImpl<RoleGroupMapper, RoleGroup> implements IRoleGroupService {

    @Override
    public  IPage<RoleGroup> findListByPage(Integer page, Integer pageCount){
        IPage<RoleGroup> wherePage = new Page<>(page, pageCount);
        RoleGroup where = new RoleGroup();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(RoleGroup roleGroup){
        return baseMapper.insert(roleGroup);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(RoleGroup roleGroup){
        return baseMapper.updateById(roleGroup);
    }

    @Override
    public RoleGroup findById(Long id){
        return  baseMapper.selectById(id);
    }
}
