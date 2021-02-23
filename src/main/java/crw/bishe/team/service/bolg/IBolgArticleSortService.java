package crw.bishe.team.service.bolg;

import crw.bishe.team.entity.bolg.BolgArticleSort;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * 博客分类关联表 服务类
 * </p>
 *
 * @author caorongwu
 * @since 2021-02-24
 */
public interface IBolgArticleSortService extends IService<BolgArticleSort> {

    /**
     * 查询博客分类关联表分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<BolgArticleSort>
     */
    IPage<BolgArticleSort> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加博客分类关联表
     *
     * @param bolgArticleSort 博客分类关联表
     * @return int
     */
    int add(BolgArticleSort bolgArticleSort);

    /**
     * 删除博客分类关联表
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改博客分类关联表
     *
     * @param bolgArticleSort 博客分类关联表
     * @return int
     */
    int updateData(BolgArticleSort bolgArticleSort);

    /**
     * id查询数据
     *
     * @param id id
     * @return BolgArticleSort
     */
    BolgArticleSort findById(Long id);
}
