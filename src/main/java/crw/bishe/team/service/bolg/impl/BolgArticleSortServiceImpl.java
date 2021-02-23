package crw.bishe.team.service.bolg.impl;

import crw.bishe.team.entity.bolg.BolgArticleSort;
import crw.bishe.team.mapper.bolg.BolgArticleSortMapper;
import crw.bishe.team.service.bolg.IBolgArticleSortService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * <p>
 * 博客分类关联表 服务实现类
 * </p>
 *
 * @author caorongwu
 * @since 2021-02-24
 */
@Service
public class BolgArticleSortServiceImpl extends ServiceImpl<BolgArticleSortMapper, BolgArticleSort> implements IBolgArticleSortService {

    @Override
    public  IPage<BolgArticleSort> findListByPage(Integer page, Integer pageCount){
        IPage<BolgArticleSort> wherePage = new Page<>(page, pageCount);
        BolgArticleSort where = new BolgArticleSort();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(BolgArticleSort bolgArticleSort){
        return baseMapper.insert(bolgArticleSort);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(BolgArticleSort bolgArticleSort){
        return baseMapper.updateById(bolgArticleSort);
    }

    @Override
    public BolgArticleSort findById(Long id){
        return  baseMapper.selectById(id);
    }
}
