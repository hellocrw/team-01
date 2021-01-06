package my.study.demo.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Demo03 {
    public static void main(String[] args) throws ParseException {
        Boolean holiday;
        // 判断是否是周末
        Calendar calendar = Calendar.getInstance();
        String date = "2021-01-09 08:00:00";
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = sf.parse(date);
        calendar.setTime(parse);
//        calendar.set(2021, 0, 9);
        if(calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY){
            holiday = true;
        } else{
            holiday = false;
        }
        System.out.println(holiday);
    }
}
