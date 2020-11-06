package my.study.demo.test;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        map.put("test1", "111");
        map.put("test2", "222");
        System.out.println(map.get("test1"));
        System.out.println(map.get("test3"));
    }
}
