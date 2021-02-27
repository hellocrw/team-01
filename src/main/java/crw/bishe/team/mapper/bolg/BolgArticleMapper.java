package crw.bishe.team.mapper.bolg;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import crw.bishe.team.entity.bolg.BolgArticle;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import crw.bishe.team.vo.bolg.ArticleVo;
import crw.bishe.team.vo.bolg.TenArticleVo;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * <p>
 * 博客表 Mapper 接口
 * </p>
 *
 * @author caorongwu
 * @since 2021-02-23
 */
public interface BolgArticleMapper extends BaseMapper<BolgArticle> {

    /**
     * 分页查询文章内容
     * @param page
     * @return
     */
    List<BolgArticle> selectArticlePage(@Param("page") IPage<BolgArticle> page);

    /**
     * 查看文章信息
     * @param articleId 文章编号
     * @return
     */
    ArticleVo queryBolg(@Param("articleId") Integer articleId);

    /**
     * 查看近来的十章博客
     * @return
     */
    List<TenArticleVo> queryTenArticle();



}
