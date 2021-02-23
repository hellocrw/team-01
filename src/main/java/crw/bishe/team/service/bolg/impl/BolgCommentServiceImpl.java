package crw.bishe.team.service.bolg.impl;

import crw.bishe.team.entity.bolg.BolgComment;
import crw.bishe.team.mapper.bolg.BolgCommentMapper;
import crw.bishe.team.service.bolg.IBolgCommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * <p>
 * 评论表 服务实现类
 * </p>
 *
 * @author caorongwu
 * @since 2021-02-24
 */
@Service
public class BolgCommentServiceImpl extends ServiceImpl<BolgCommentMapper, BolgComment> implements IBolgCommentService {

    @Override
    public  IPage<BolgComment> findListByPage(Integer page, Integer pageCount){
        IPage<BolgComment> wherePage = new Page<>(page, pageCount);
        BolgComment where = new BolgComment();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(BolgComment bolgComment){
        return baseMapper.insert(bolgComment);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(BolgComment bolgComment){
        return baseMapper.updateById(bolgComment);
    }

    @Override
    public BolgComment findById(Long id){
        return  baseMapper.selectById(id);
    }
}
