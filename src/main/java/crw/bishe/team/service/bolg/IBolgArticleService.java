package crw.bishe.team.service.bolg;

import crw.bishe.team.entity.bolg.BolgArticle;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * 博客表 服务类
 * </p>
 *
 * @author caorongwu
 * @since 2021-02-23
 */
public interface IBolgArticleService extends IService<BolgArticle> {

    /**
     * 查询博客表分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<BolgArticle>
     */
    IPage<BolgArticle> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加博客表
     *
     * @param bolgArticle 博客表
     * @return int
     */
    int add(BolgArticle bolgArticle);

    /**
     * 删除博客表
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改博客表
     *
     * @param bolgArticle 博客表
     * @return int
     */
    int updateData(BolgArticle bolgArticle);

    /**
     * id查询数据
     *
     * @param id id
     * @return BolgArticle
     */
    BolgArticle findById(Long id);
}
