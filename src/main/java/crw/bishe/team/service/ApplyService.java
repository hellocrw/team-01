package crw.bishe.team.service;

import crw.bishe.team.dto.ApplyDto;

/**
 * @Description Description
 * @Author crw
 * @Date Created in 2020/2/4 0004
 * @Time 0:45
 */
public interface ApplyService {

    /**
     * 增加申请表信息
     * @param applyDto
     * @return
     */
    int create(ApplyDto applyDto);
}
