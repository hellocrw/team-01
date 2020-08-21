package crw.bishe.team.service;

import crw.bishe.team.dto.ApplyDto;

import java.util.List;

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

    /**
     * 通过用户ID获取申请通知信息
     * @param userId
     * @return
     */
    List<ApplyDto> getApplyByUserId(String userId);

    /**
     * 获取别人的入队申请信息
     * @param userId
     * @return
     */
    List<ApplyDto> getEnqueueApply(String userId);

    Integer deleteByTeamId(String teamId);

    /**
     * 同意入队
     * @param applyId
     * @return
     */
    Integer agreeApply(String applyId);

    /**
     * 拒绝入队
     * @param applyId
     * @return
     */
    Integer disagreeApply(String applyId);
}
