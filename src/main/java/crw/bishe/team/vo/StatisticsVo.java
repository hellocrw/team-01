package crw.bishe.team.vo;

import lombok.Data;

@Data
public class StatisticsVo {

    /**
     * 填写人数
     */
    private Integer writerNumber;
    /**
     * 参加人数
     */
    private Integer joinNumber;
    /**
     * 不参加人数
     */
    private Integer noJoinNumber;

}
