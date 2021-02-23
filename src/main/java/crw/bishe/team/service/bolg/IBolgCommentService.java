package crw.bishe.team.service.bolg;

import crw.bishe.team.entity.bolg.BolgComment;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * 评论表 服务类
 * </p>
 *
 * @author caorongwu
 * @since 2021-02-24
 */
public interface IBolgCommentService extends IService<BolgComment> {

    /**
     * 查询评论表分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<BolgComment>
     */
    IPage<BolgComment> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加评论表
     *
     * @param bolgComment 评论表
     * @return int
     */
    int add(BolgComment bolgComment);

    /**
     * 删除评论表
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改评论表
     *
     * @param bolgComment 评论表
     * @return int
     */
    int updateData(BolgComment bolgComment);

    /**
     * id查询数据
     *
     * @param id id
     * @return BolgComment
     */
    BolgComment findById(Long id);
}
