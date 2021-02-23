package crw.bishe.team.service.bolg.impl;

import crw.bishe.team.entity.bolg.BolgSort;
import crw.bishe.team.mapper.bolg.BolgSortMapper;
import crw.bishe.team.service.bolg.IBolgSortService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * <p>
 * 分类表 服务实现类
 * </p>
 *
 * @author caorongwu
 * @since 2021-02-24
 */
@Service
public class BolgSortServiceImpl extends ServiceImpl<BolgSortMapper, BolgSort> implements IBolgSortService {

    @Override
    public  IPage<BolgSort> findListByPage(Integer page, Integer pageCount){
        IPage<BolgSort> wherePage = new Page<>(page, pageCount);
        BolgSort where = new BolgSort();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(BolgSort bolgSort){
        return baseMapper.insert(bolgSort);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(BolgSort bolgSort){
        return baseMapper.updateById(bolgSort);
    }

    @Override
    public BolgSort findById(Long id){
        return  baseMapper.selectById(id);
    }
}
