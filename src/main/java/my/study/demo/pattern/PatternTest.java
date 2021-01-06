package my.study.demo.pattern;

import java.util.regex.Pattern;

public class PatternTest {
    public static void main(String[] args) {
        String i = "0", j = "9";
        Pattern pattern = Pattern.compile("[0-9]*");

        int hour = 0, minues = 0;

        if (pattern.matcher(i).matches()) {
            hour = Integer.parseInt(i);
        }

        if (pattern.matcher(j).matches()) {
            minues = Integer.parseInt(j);
        }

        System.out.println(hour + " - " +  minues);

    }
}
