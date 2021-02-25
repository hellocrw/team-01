package crw.bishe.team.vo.bolg;

import lombok.Data;

import java.util.Date;

@Data
public class TenArticleVo {
    private Integer articleId;
    private String articleTitle;
    private Date lastUpdatedDate;
}
