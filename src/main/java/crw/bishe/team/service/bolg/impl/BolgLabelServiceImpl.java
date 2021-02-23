package crw.bishe.team.service.bolg.impl;

import crw.bishe.team.entity.bolg.BolgLabel;
import crw.bishe.team.mapper.bolg.BolgLabelMapper;
import crw.bishe.team.service.bolg.IBolgLabelService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * <p>
 * 标签表 服务实现类
 * </p>
 *
 * @author caorongwu
 * @since 2021-02-23
 */
@Service
public class BolgLabelServiceImpl extends ServiceImpl<BolgLabelMapper, BolgLabel> implements IBolgLabelService {

    @Override
    public  IPage<BolgLabel> findListByPage(Integer page, Integer pageCount){
        IPage<BolgLabel> wherePage = new Page<>(page, pageCount);
        BolgLabel where = new BolgLabel();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(BolgLabel bolgLabel){
        return baseMapper.insert(bolgLabel);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(BolgLabel bolgLabel){
        return baseMapper.updateById(bolgLabel);
    }

    @Override
    public BolgLabel findById(Long id){
        return  baseMapper.selectById(id);
    }
}
