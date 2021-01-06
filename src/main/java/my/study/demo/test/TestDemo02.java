package my.study.demo.test;

import org.junit.Test;

public class TestDemo02 {

    @Test
    public void test(){
        int i = 0;
        add(i);
        System.out.println(i);
    }

    public void add(int i){
        i++;
    }
}
