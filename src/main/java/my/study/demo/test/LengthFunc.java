package my.study.demo.test;

import java.util.ArrayList;
import java.util.List;

public class LengthFunc {
    public static void main(String[] args) {
        String s = "xxxx;";
        System.out.println(s.substring(0, s.length()-1));

        TestPo testPo = TestPo.builder().build();

        System.out.println("--->");
        List<TestPo> testPos = new ArrayList<>();
        testPos.add(testPo);
        System.out.println(testPos);
        if (testPos.size() > 0 ){
            System.out.println("true1");
        }
        if (testPos == null){
            System.out.println("true2");
        }
    }
}
