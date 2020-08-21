package crw.bishe.team.mapper;

import crw.bishe.team.entity.Admin;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

public interface AdminMapper extends Mapper<Admin> {
    /**
     * 查看adminId是否存在
     * @param key
     * @return
     */
    @Select("SELECT admin.`admin_id` FROM admin WHERE admin.`admin_id`=#{key}; ")
    Integer findAdminId(Long key);
}