package my.study.demo.list;

import java.util.Arrays;
import java.util.List;

public class StreamTest {

    public static void main(String[] args) {
        Student s1 = new Student("aa", 10);
        Student s2 = new Student("bb", 20);
        List<Student> studentList = Arrays.asList(s1, s2);

        studentList.stream()
                .peek(o -> o.setAge(100))
                .forEach(System.out::println);

    }

}
