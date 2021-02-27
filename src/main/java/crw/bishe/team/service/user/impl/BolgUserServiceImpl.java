package crw.bishe.team.service.user.impl;

import crw.bishe.team.entity.user.BolgUser;
import crw.bishe.team.mapper.user.BolgUserMapper;
import crw.bishe.team.service.user.IBolgUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author caorongwu
 * @since 2021-02-27
 */
@Service
public class BolgUserServiceImpl extends ServiceImpl<BolgUserMapper, BolgUser> implements IBolgUserService {

    @Override
    public  IPage<BolgUser> findListByPage(Integer page, Integer pageCount){
        IPage<BolgUser> wherePage = new Page<>(page, pageCount);
        BolgUser where = new BolgUser();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(BolgUser bolgUser){
        return baseMapper.insert(bolgUser);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(BolgUser bolgUser){
        return baseMapper.updateById(bolgUser);
    }

    @Override
    public BolgUser findById(Long id){
        return  baseMapper.selectById(id);
    }
}
