package crw.bishe.team.dtoEntityMapping;

import crw.bishe.team.dto.ApplyDto;
import crw.bishe.team.entity.Apply;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * @Description Description 申请表
 * @Author crw
 * @Date Created in 2020/2/4 0004
 * @Time 0:36
 */
@Component("applyMapping")
public class ApplyMappingImpl implements ApplyMapping {

    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public Apply toEntity(ApplyDto applyDto) {
        if (applyDto == null){
            return null;
        }
        Apply apply = new Apply();
        if (applyDto.getApplyId() == null || applyDto.getApplyId() == ""){
            apply.setApplyId(null);
        }else {
            apply.setApplyId(Long.parseLong(applyDto.getApplyId()));
        }
        if (applyDto.getTeamId() != null)
            apply.setTeamId(Long.parseLong(applyDto.getTeamId()));
        if (applyDto.getTeamName() != null)
            apply.setTeamName(applyDto.getTeamName());
        if (applyDto.getUserId() != null)
            apply.setUserId(Long.parseLong(applyDto.getUserId()));
        if (applyDto.getUserName() != null)
            apply.setUserName(applyDto.getUserName());
        if (applyDto.getApplyDate() != null)
            apply.setApplyDate(Date.valueOf(applyDto.getApplyDate()));
        if (applyDto.getDecribe() != null)
            apply.setDecribe(applyDto.getDecribe());
        if (applyDto.getPhone() != null)
            apply.setPhone(applyDto.getPhone());
        if (applyDto.getStatus() != null)
            apply.setStatus(Byte.parseByte(applyDto.getStatus()));
        return apply;
    }

    @Override
    public ApplyDto toDto(Apply apply) {
        if (apply == null){
            return null;
        }
        ApplyDto applyDto = new ApplyDto();
        applyDto.setApplyId(String.valueOf(apply.getApplyId()));
        applyDto.setTeamId(String.valueOf(apply.getTeamId()));
        applyDto.setTeamName(apply.getTeamName());
        applyDto.setUserId(String.valueOf(apply.getUserId()));
        applyDto.setUserName(apply.getUserName());
        applyDto.setApplyDate(simpleDateFormat.format(apply.getApplyDate()));
        applyDto.setDecribe(apply.getDecribe());
        applyDto.setPhone(apply.getPhone());
        applyDto.setStatus(String.valueOf(apply.getStatus()));
        return applyDto;
    }
}
