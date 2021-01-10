package crw.bishe.team.service.auth.impl;

import crw.bishe.team.entity.auth.OperatorLog;
import crw.bishe.team.mapper.auth.OperatorLogMapper;
import crw.bishe.team.service.auth.IOperatorLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * <p>
 *   服务实现类
 * </p>
 *
 * @author caorongwu
 * @since 2021-01-10
 */
@Service
public class OperatorLogServiceImpl extends ServiceImpl<OperatorLogMapper, OperatorLog> implements IOperatorLogService {

    @Override
    public  IPage<OperatorLog> findListByPage(Integer page, Integer pageCount){
        IPage<OperatorLog> wherePage = new Page<>(page, pageCount);
        OperatorLog where = new OperatorLog();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(OperatorLog operatorLog){
        return baseMapper.insert(operatorLog);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(OperatorLog operatorLog){
        return baseMapper.updateById(operatorLog);
    }

    @Override
    public OperatorLog findById(Long id){
        return  baseMapper.selectById(id);
    }
}
