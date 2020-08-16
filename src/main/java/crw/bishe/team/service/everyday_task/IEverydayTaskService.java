package crw.bishe.team.service.everyday_task;

import crw.bishe.team.entity.everyday_task.EverydayTask;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author caorongwu
 * @since 2020-08-17
 */
public interface IEverydayTaskService extends IService<EverydayTask> {

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<EverydayTask>
     */
    IPage<EverydayTask> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param everydayTask 
     * @return int
     */
    int add(EverydayTask everydayTask);

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
     * @param everydayTask 
     * @return int
     */
    int updateData(EverydayTask everydayTask);

    /**
     * id查询数据
     *
     * @param id id
     * @return EverydayTask
     */
    EverydayTask findById(Long id);
}
