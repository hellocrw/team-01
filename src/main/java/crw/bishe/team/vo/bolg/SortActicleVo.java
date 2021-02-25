package crw.bishe.team.vo.bolg;

import lombok.Data;

import java.util.List;

@Data
public class SortActicleVo {
    private Integer sortId;
    private String sortName;
    private List<ArticleVo> articleList;
}
