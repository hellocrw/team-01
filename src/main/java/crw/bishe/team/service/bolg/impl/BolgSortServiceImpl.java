package crw.bishe.team.service.bolg.impl;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import crw.bishe.team.entity.bolg.BolgArticle;
import crw.bishe.team.entity.bolg.BolgArticleSort;
import crw.bishe.team.entity.bolg.BolgSort;
import crw.bishe.team.mapper.bolg.BolgArticleMapper;
import crw.bishe.team.mapper.bolg.BolgArticleSortMapper;
import crw.bishe.team.mapper.bolg.BolgSortMapper;
import crw.bishe.team.service.bolg.IBolgSortService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import crw.bishe.team.vo.bolg.ArticleVo;
import crw.bishe.team.vo.bolg.SortActicleVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 分类表 服务实现类
 * </p>
 *
 * @author caorongwu
 * @since 2021-02-24
 */
@Service("bolgSortService")
public class BolgSortServiceImpl extends ServiceImpl<BolgSortMapper, BolgSort> implements IBolgSortService {

    private BolgArticleSortMapper bolgArticleSortMapper;
    private BolgArticleMapper bolgArticleMapper;

    @Autowired
    public BolgSortServiceImpl(BolgArticleSortMapper bolgArticleSortMapper,
                                BolgArticleMapper bolgArticleMapper){
        this.bolgArticleSortMapper = bolgArticleSortMapper;
        this.bolgArticleMapper = bolgArticleMapper;
    }

    @Override
    public  IPage<BolgSort> findListByPage(Integer page, Integer pageCount){
        IPage<BolgSort> wherePage = new Page<>(page, pageCount);
        BolgSort where = new BolgSort();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(BolgSort bolgSort){
        return baseMapper.insert(bolgSort);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(BolgSort bolgSort){
        return baseMapper.updateById(bolgSort);
    }

    @Override
    public BolgSort findById(Long id){
        return  baseMapper.selectById(id);
    }

    @Override
    public List<SortActicleVo> querySortActicle() {
        List<SortActicleVo> sortActicleVoList = new ArrayList<>();
        List<BolgSort> bolgSortList = baseMapper.selectList(new QueryWrapper<>());
        for (BolgSort bolgSort : bolgSortList) {
            SortActicleVo sortActicleVo = new SortActicleVo();
            BeanUtils.copyProperties(bolgSort, sortActicleVo);
            sortActicleVoList.add(sortActicleVo);
        }
        for (SortActicleVo sortActicleVo : sortActicleVoList) {
            List<BolgArticleSort> articleSortList = bolgArticleSortMapper.selectList(new QueryWrapper<BolgArticleSort>()
                    .eq("sort_id", sortActicleVo.getSortId())
            );
            List<ArticleVo> articleVoList = new ArrayList<>();
            for (BolgArticleSort bolgArticleSort : articleSortList) {
                ArticleVo articleVo = new ArticleVo();
                BolgArticle bolgArticle = bolgArticleMapper.selectById(bolgArticleSort.getArticleId());
                articleVo.setArticleId(bolgArticle.getArticleId());
                articleVo.setArticleTitle(bolgArticle.getArticleTitle());
                articleVoList.add(articleVo);
            }
            sortActicleVo.setArticleList(articleVoList);
        }
        return sortActicleVoList;
    }

    @Override
    public List<BolgSort> queryRootSort() {
        return baseMapper.selectList(new QueryWrapper<BolgSort>().eq("parent_sort_id", 0));
    }
}
