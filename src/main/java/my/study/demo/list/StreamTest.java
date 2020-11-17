package my.study.demo.list;

import com.alibaba.fastjson.JSON;
import my.study.demo.bean.Animal;
import my.study.demo.bean.Student;
import my.study.demo.vo.StudentVo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {

    public static void main(String[] args) {
        Student s1 = new Student("aa","1", 10);
        Student s2 = new Student("bb","2", 20);
        List<Student> studentList = Arrays.asList(s1, s2);

        studentList.stream()
                .peek(o -> o.setAge(100))
                .forEach(System.out::println);
        System.out.println(JSON.toJSONString(studentList));

        List<Student> aa = studentList.stream().map(item -> {
            item.setAge(1);
            item.setType("aa");
            item.setName("1");
            return item;
        }).collect(Collectors.toList());

        List<Student> collect1 = aa.stream().distinct().collect(Collectors.toList());

        System.out.println(JSON.toJSONString(collect1));

        List<Integer> integers = Arrays.asList(1,2,3,4,3);


        List<Integer> collect = integers.stream().distinct().collect(Collectors.toList());

        System.out.println(JSON.toJSONString(collect));

        System.out.println("============================studentVo=========================");
        List<StudentVo> studentVos = new ArrayList<>(Arrays.asList(new StudentVo("a", "b"), new StudentVo("a", "b")));
        System.out.println(studentVos);

        List<StudentVo> studentVoList = studentVos.stream().distinct().collect(Collectors.toList());
        System.out.println(studentVoList);

        System.out.println("============================Animal=========================");
        List<Animal> animals = new ArrayList<>(
                Arrays.asList(
                        new Animal("wangwang", 3),
                        new Animal("wangwang", 3),
                        new Animal("guagua", 2)
                )
        );
        System.out.println(animals);
        List<Animal> animalList = animals.stream().distinct().collect(Collectors.toList());
        System.out.println(animalList);


    }

}
