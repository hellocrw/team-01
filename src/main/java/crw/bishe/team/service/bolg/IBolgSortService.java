package crw.bishe.team.service.bolg;

import crw.bishe.team.entity.bolg.BolgSort;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * 分类表 服务类
 * </p>
 *
 * @author caorongwu
 * @since 2021-02-24
 */
public interface IBolgSortService extends IService<BolgSort> {

    /**
     * 查询分类表分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<BolgSort>
     */
    IPage<BolgSort> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加分类表
     *
     * @param bolgSort 分类表
     * @return int
     */
    int add(BolgSort bolgSort);

    /**
     * 删除分类表
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改分类表
     *
     * @param bolgSort 分类表
     * @return int
     */
    int updateData(BolgSort bolgSort);

    /**
     * id查询数据
     *
     * @param id id
     * @return BolgSort
     */
    BolgSort findById(Long id);
}
