package crw.bishe.team.service.naire.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import crw.bishe.team.entity.naire.QuestionNaire;
import crw.bishe.team.mapper.naire.QuestionNaireMapper;
import crw.bishe.team.service.naire.IQuestionNaireService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import crw.bishe.team.vo.StatisticsVo;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.logging.SimpleFormatter;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author caorongwu
 * @since 2021-02-10
 */
@Service
public class QuestionNaireServiceImpl extends ServiceImpl<QuestionNaireMapper, QuestionNaire> implements IQuestionNaireService {

    @Override
    public  IPage<QuestionNaire> findListByPage(Integer page, Integer pageCount){
        IPage<QuestionNaire> wherePage = new Page<>(page, pageCount);
        QuestionNaire where = new QuestionNaire();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(QuestionNaire questionNaire){
        questionNaire.setId(UUID.randomUUID().toString());
        questionNaire.setCreateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        return baseMapper.insert(questionNaire);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(QuestionNaire questionNaire){
        return baseMapper.updateById(questionNaire);
    }

    @Override
    public QuestionNaire findById(Long id){
        return  baseMapper.selectById(id);
    }

    @Override
    public StatisticsVo statistics() {
        List<QuestionNaire> questionNaireList = baseMapper.selectList(new QueryWrapper<QuestionNaire>().orderByAsc("id"));
        List<QuestionNaire> joinList = baseMapper.selectList(new QueryWrapper<QuestionNaire>().eq("is_join", "1"));
        List<QuestionNaire> noJoinList = baseMapper.selectList(new QueryWrapper<QuestionNaire>().eq("is_join", "0"));
        StatisticsVo statisticsVo = new StatisticsVo();
        statisticsVo.setWriterNumber(questionNaireList.size());
        statisticsVo.setJoinNumber(joinList.size());
        statisticsVo.setNoJoinNumber(noJoinList.size());
        return statisticsVo;
    }
}
