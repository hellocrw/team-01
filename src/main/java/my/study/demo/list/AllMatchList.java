package my.study.demo.list;

import com.alibaba.fastjson.JSON;
import my.study.demo.bean.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AllMatchList {
    public static void main(String[] args) {
        test2();
    }

    private static void test1(){
        List<Student> studentList = new ArrayList<>();
        Student student1 = new Student("1", "zhangsan1", 1);
        Student student2 = new Student("2", "zhangsan2", 1);
        studentList.add(student1);
        studentList.add(student2);

        List<Integer> integerList = new ArrayList<>();
        integerList.add(3);
        integerList.add(2);

        List<Student> collect = studentList.stream().filter(student -> {
            boolean res = true;
            for (int i = 0; i < integerList.size(); i++) {
                if (integerList.get(i) == student.getAge()) {
                    res = false;
                    break;
                }
            }
            return res;
        }).collect(Collectors.toList());

        System.out.println(JSON.toJSONString(collect));
    }

    private static void test2(){
        List<Student> studentList = new ArrayList<>();
        Student student1 = new Student("1", "zhangsan1", 1);
        Student student2 = new Student("2", "zhangsan2", 2);
        studentList.add(student1);
        studentList.add(student2);

        List<Integer> integerList = new ArrayList<>();
        integerList.add(3);
        integerList.add(1);

        Student student3 = new Student("1", "zhangsan1", 3);
        Student student4 = new Student("2", "zhangsan2", 2);
        List<Student> studentList1 = Arrays.asList(student3, student4);

        List<Student> collect = studentList.stream().filter(student -> integerList.stream().anyMatch(integer -> student.getAge() == integer))
                .collect(Collectors.toList());

        List<Student> collect2 = studentList.stream().filter(student -> studentList1.stream().anyMatch(studentx -> student.getAge() == studentx.getAge()))
                .collect(Collectors.toList());

        System.out.println(JSON.toJSONString(collect));
        System.out.println(JSON.toJSONString(collect2));
    }
}
