package my.study.demo.utils;

import com.alibaba.fastjson.JSON;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间格式处理工具类
 */
public class TimeUtils {

    /**
     * 将"2020年1月1日"格式转为"2020-01-01"格式
     * @return
     */
    public static String toDateTimeForm(String dateTime) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String replace = dateTime.replace("年", "-").replace("月", "-");
        Date date = sdf.parse(replace);
        String result = sdf.format(date);
        return result;
    }

    /**
     * 输入月日, 输出年月日，年份为当前年
     * "1月1日" 转 "2020-01-01"
     */
    public static String toDate(String dateTime) throws ParseException {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        String strDate = year + "年" + dateTime;
        String result = toDateTimeForm(strDate);
        return result;
    }

    /**
     * 将 "2020年2月2日" 或 "2月2日" 转 "2020-02-02"
     * @param dateTime
     * @return
     * @throws ParseException
     */
    public static String toDateStr(String dateTime) throws ParseException {
        String result ;
        if (dateTime == null || dateTime.length() == 0){
            result = null;
        }
        if (!dateTime.contains("年")){
            result = toDate(dateTime);
        }else {
            result = toDateTimeForm(dateTime);
        }
        return result;
    }

    /**
     * 2020年02月02日 2:00:00 - > 2020-02-02 02:00:00
     * @param dateTime
     * @return
     */
    public static String toDateStr2(String dateTime) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String replaceDate = dateTime.replaceAll("年", "-").replaceAll("月", "-").replaceAll("日", "");
        Date date = sdf.parse(replaceDate);
        String result = sdf.format(date);
        return result;
    }

    public static String toDateStr3(String dateTime) {
        return null;
    }

}
