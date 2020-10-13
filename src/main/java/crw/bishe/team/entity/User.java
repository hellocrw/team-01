package crw.bishe.team.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * elasticsearch测试的实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String name;
    private String age;
}
