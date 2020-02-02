package crw.bishe.team.mapper;

import crw.bishe.team.entity.Dictionary;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

public interface DictionaryMapper extends Mapper<Dictionary> {
    /**
     * 获取项目类型
     * @return
     */
    @Select("SELECT dictionary.`pro_type` FROM dictionary;")
    String getProType();

    /**
     * 获取学校信息
     * @return
     */
    @Select("SELECT dictionary.`university` FROM dictionary;")
    String getUniversity();
}