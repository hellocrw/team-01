package crw.bishe.team.service.everyday_task.impl;

import crw.bishe.team.entity.everyday_task.EverydayTask;
import crw.bishe.team.mapper.everyday_task.EverydayTaskMapper;
import crw.bishe.team.service.everyday_task.IEverydayTaskService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author caorongwu
 * @since 2020-08-17
 */
@Service
public class EverydayTaskServiceImpl extends ServiceImpl<EverydayTaskMapper, EverydayTask> implements IEverydayTaskService {

    @Override
    public  IPage<EverydayTask> findListByPage(Integer page, Integer pageCount){
        IPage<EverydayTask> wherePage = new Page<>(page, pageCount);
        EverydayTask where = new EverydayTask();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(EverydayTask everydayTask){
        return baseMapper.insert(everydayTask);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(EverydayTask everydayTask){
        return baseMapper.updateById(everydayTask);
    }

    @Override
    public EverydayTask findById(Long id){
        return  baseMapper.selectById(id);
    }
}
