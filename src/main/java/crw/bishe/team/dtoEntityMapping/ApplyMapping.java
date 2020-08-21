package crw.bishe.team.dtoEntityMapping;

import crw.bishe.team.dto.ApplyDto;
import crw.bishe.team.entity.Apply;

/**
 * @Description Description
 * @Author crw
 * @Date Created in 2020/2/4 0004
 * @Time 0:34
 */
public interface ApplyMapping {

    /**
     * 将applyDto 转为 entity
     * @param applyDto
     * @return
     */
    Apply toEntity(ApplyDto applyDto);

    /**
     * 将entity 转为 dto
     * @param apply
     * @return
     */
    ApplyDto toDto(Apply apply);
}
