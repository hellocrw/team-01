package crw.bishe.team.service.naire;

import crw.bishe.team.entity.naire.QuestionNaire;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import crw.bishe.team.vo.StatisticsVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author caorongwu
 * @since 2021-02-10
 */
public interface IQuestionNaireService extends IService<QuestionNaire> {

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<QuestionNaire>
     */
    IPage<QuestionNaire> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param questionNaire 
     * @return int
     */
    int add(QuestionNaire questionNaire);

    /**
     * 删除
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改
     *
     * @param questionNaire 
     * @return int
     */
    int updateData(QuestionNaire questionNaire);

    /**
     * id查询数据
     *
     * @param id id
     * @return QuestionNaire
     */
    QuestionNaire findById(Long id);

    /**
     * 统计
     * @return
     */
    StatisticsVo statistics();
}
