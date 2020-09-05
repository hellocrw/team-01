package crw.bishe.team.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * mongodb测试实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Demo implements Serializable {
    private String id;
    private String name;
    private String age;
}
