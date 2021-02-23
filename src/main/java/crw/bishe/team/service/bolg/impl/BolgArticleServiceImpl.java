package crw.bishe.team.service.bolg.impl;

import crw.bishe.team.entity.bolg.BolgArticle;
import crw.bishe.team.mapper.bolg.BolgArticleMapper;
import crw.bishe.team.service.bolg.IBolgArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * <p>
 * 博客表 服务实现类
 * </p>
 *
 * @author caorongwu
 * @since 2021-02-23
 */
@Service
public class BolgArticleServiceImpl extends ServiceImpl<BolgArticleMapper, BolgArticle> implements IBolgArticleService {

    @Override
    public  IPage<BolgArticle> findListByPage(Integer page, Integer pageCount){
        IPage<BolgArticle> wherePage = new Page<>(page, pageCount);
        BolgArticle where = new BolgArticle();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(BolgArticle bolgArticle){
        return baseMapper.insert(bolgArticle);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(BolgArticle bolgArticle){
        return baseMapper.updateById(bolgArticle);
    }

    @Override
    public BolgArticle findById(Long id){
        return  baseMapper.selectById(id);
    }
}
