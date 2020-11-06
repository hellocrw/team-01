package my.study.demo.test;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TestPo {
    private String id;
    private String name;
}
