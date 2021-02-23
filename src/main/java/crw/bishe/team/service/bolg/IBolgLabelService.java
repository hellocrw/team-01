package crw.bishe.team.service.bolg;

import crw.bishe.team.entity.bolg.BolgLabel;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * 标签表 服务类
 * </p>
 *
 * @author caorongwu
 * @since 2021-02-23
 */
public interface IBolgLabelService extends IService<BolgLabel> {

    /**
     * 查询标签表分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<BolgLabel>
     */
    IPage<BolgLabel> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加标签表
     *
     * @param bolgLabel 标签表
     * @return int
     */
    int add(BolgLabel bolgLabel);

    /**
     * 删除标签表
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改标签表
     *
     * @param bolgLabel 标签表
     * @return int
     */
    int updateData(BolgLabel bolgLabel);

    /**
     * id查询数据
     *
     * @param id id
     * @return BolgLabel
     */
    BolgLabel findById(Long id);
}
