package crw.bishe.team.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description Description
 * @Author crw
 * @Date Created in 2020/2/4 0004
 * @Time 21:54
 */
@Data
public class UniversityDto implements Serializable {
    private String id;
    private String university;
    private String college;
    private String profession;
}
