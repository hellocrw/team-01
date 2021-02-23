package crw.bishe.team.service.bolg;

import crw.bishe.team.entity.bolg.BolgArticleLabel;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * 博客标签关联表 服务类
 * </p>
 *
 * @author caorongwu
 * @since 2021-02-24
 */
public interface IBolgArticleLabelService extends IService<BolgArticleLabel> {

    /**
     * 查询博客标签关联表分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<BolgArticleLabel>
     */
    IPage<BolgArticleLabel> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加博客标签关联表
     *
     * @param bolgArticleLabel 博客标签关联表
     * @return int
     */
    int add(BolgArticleLabel bolgArticleLabel);

    /**
     * 删除博客标签关联表
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改博客标签关联表
     *
     * @param bolgArticleLabel 博客标签关联表
     * @return int
     */
    int updateData(BolgArticleLabel bolgArticleLabel);

    /**
     * id查询数据
     *
     * @param id id
     * @return BolgArticleLabel
     */
    BolgArticleLabel findById(Long id);
}
