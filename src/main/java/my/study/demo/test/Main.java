package my.study.demo.test;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** 
* @Description: List深拷贝 
* @Param:
* @return:  
* @Author: caorongwu
* @Date: 2020/11/11 
*/
public class Main {
    public static void main(String[] args){
        Student student1=new Student("1","tom",20);
        Student student2=new Student("1","tom",20);
        List<Student> list1 = new ArrayList<>();
        list1.add(student1);
        list1.add(student2);

        List<Student> list2 = new ArrayList<>();
        for (Student s : list1) {
            try {
                list2.add((Student)s.clone());
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("list2:"+ JSON.toJSONString(list2));
        student1.setAge(1);
        System.out.println("list1:"+JSON.toJSONString(list1));


        Map<Student,Integer> map=new HashMap<>();
        map.put(student1, 100);
        map.put(student2, 200);
        System.out.println(map.get(student1));
        System.out.println(map.containsKey(student2));
        System.out.println(student1.hashCode()+"：："+student2);
        System.out.println(map.get(student1)+"::"+map.get(student2));
    }
}
class Student implements Cloneable {
    private String type;
    private String name;
    private  int age;
    Student(String type,String name,int age){
        this.age=age;
        this.type=type;
        this.name=name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Student student = null;
        try {
            student = (Student) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return student;

    }
}