package crw.bishe.team.vo.bolg;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class ArticleVo implements Serializable {
    private Integer articleId;
    private String articleTitle;
    private String aticleContent;
    private String sortName;
    private String userName;
    private Date articleCreateDate;
    private Date lastUpdateTime;
    private List<String> labelNames;
    private Integer articleViews;
    private Integer articleLikeCount;
}
