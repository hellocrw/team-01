package crw.bishe.team.service.bolg.impl;

import crw.bishe.team.entity.bolg.BolgArticleLabel;
import crw.bishe.team.mapper.bolg.BolgArticleLabelMapper;
import crw.bishe.team.service.bolg.IBolgArticleLabelService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * <p>
 * 博客标签关联表 服务实现类
 * </p>
 *
 * @author caorongwu
 * @since 2021-02-24
 */
@Service
public class BolgArticleLabelServiceImpl extends ServiceImpl<BolgArticleLabelMapper, BolgArticleLabel> implements IBolgArticleLabelService {

    @Override
    public  IPage<BolgArticleLabel> findListByPage(Integer page, Integer pageCount){
        IPage<BolgArticleLabel> wherePage = new Page<>(page, pageCount);
        BolgArticleLabel where = new BolgArticleLabel();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(BolgArticleLabel bolgArticleLabel){
        return baseMapper.insert(bolgArticleLabel);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(BolgArticleLabel bolgArticleLabel){
        return baseMapper.updateById(bolgArticleLabel);
    }

    @Override
    public BolgArticleLabel findById(Long id){
        return  baseMapper.selectById(id);
    }
}
