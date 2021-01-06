package my.study.demo.test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Demo01 {
    static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-M-d");

    public static void main(String[] args) {
        System.out.println(simpleDateFormat.format(new Date()));
    }
}
