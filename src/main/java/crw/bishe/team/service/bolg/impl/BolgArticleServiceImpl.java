package crw.bishe.team.service.bolg.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import crw.bishe.team.entity.bolg.BolgArticle;
import crw.bishe.team.entity.bolg.BolgArticleLabel;
import crw.bishe.team.mapper.bolg.BolgArticleLabelMapper;
import crw.bishe.team.mapper.bolg.BolgArticleMapper;
import crw.bishe.team.mapper.bolg.BolgLabelMapper;
import crw.bishe.team.service.bolg.IBolgArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import crw.bishe.team.vo.bolg.ArticleVo;
import crw.bishe.team.vo.bolg.TenArticleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    private BolgArticleLabelMapper bolgArticleLabelMapper;
    private BolgLabelMapper bolgLabelMapper;

    @Autowired
    public BolgArticleServiceImpl(BolgArticleLabelMapper bolgArticleLabelMapper,
                                  BolgLabelMapper bolgLabelMapper){
        this.bolgArticleLabelMapper = bolgArticleLabelMapper;
        this.bolgLabelMapper = bolgLabelMapper;
    }

    @Override
    public  Page<BolgArticle> findListByPage(Integer page, Integer pageCount){
        Page<BolgArticle> wherePage = new Page<>(page, pageCount);
        Page<BolgArticle> bolgArticlePage = baseMapper.selectPage(wherePage, new QueryWrapper<>());
        return  bolgArticlePage;
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

    @Override
    public ArticleVo queryBolg(Integer articleId) {
        ArticleVo articleVo = baseMapper.queryBolg(articleId);
        // 通过文章编号查询标签
        List<BolgArticleLabel> bolgArticleLabelList = bolgArticleLabelMapper.selectList(new QueryWrapper<BolgArticleLabel>().eq("article_id", articleVo.getArticleId()));
        List<Integer> collect = bolgArticleLabelList.stream().map(item -> item.getLabelId()).collect(Collectors.toList());
        List<String> labelNameList = new ArrayList<>();
        for (Integer labelId : collect) {
            String labelName = bolgLabelMapper.selectById(labelId).getLabelName();
            labelNameList.add(labelName);
        }
        articleVo.setLabelNames(labelNameList);
        return articleVo;
    }

    @Override
    public List<TenArticleVo> queryTenArticle() {
        return baseMapper.queryTenArticle();
    }
}
