package my.study.demo.list;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EntityPo {
    private int id;
    private String name;
}
