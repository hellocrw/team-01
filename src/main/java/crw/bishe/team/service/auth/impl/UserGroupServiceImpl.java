package crw.bishe.team.service.auth.impl;

import crw.bishe.team.entity.auth.UserGroup;
import crw.bishe.team.mapper.auth.UserGroupMapper;
import crw.bishe.team.service.auth.IUserGroupService;
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
public class UserGroupServiceImpl extends ServiceImpl<UserGroupMapper, UserGroup> implements IUserGroupService {

    @Override
    public  IPage<UserGroup> findListByPage(Integer page, Integer pageCount){
        IPage<UserGroup> wherePage = new Page<>(page, pageCount);
        UserGroup where = new UserGroup();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(UserGroup userGroup){
        return baseMapper.insert(userGroup);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(UserGroup userGroup){
        return baseMapper.updateById(userGroup);
    }

    @Override
    public UserGroup findById(Long id){
        return  baseMapper.selectById(id);
    }
}
