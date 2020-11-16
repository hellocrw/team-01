package my.study.demo.test;

import com.alibaba.fastjson.JSON;
import my.study.demo.bean.Student;

import java.io.*;
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

        String str = "" + "," + "" + "," + "1";
        String[] split = str.split(",");
        System.out.println(JSON.toJSONString(split));

        Student student1=new Student("1","tom",20);
        Student student2=new Student("1","tom",20);
        List<Student> list1 = new ArrayList<>();
        list1.add(student1);
        list1.add(student2);

        List<Student> list2 = new ArrayList<>();
        /*for (Student s : list1) {
            try {
                list2.add((Student)s.clone());
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }*/

        list2 = listCopy(list1);

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

    /**
     * 深度复制的方法
     */
    public static <T> List<T> listCopy(List<T> src) {
        List<T> dest = null;
        try {
            ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(byteOut);
            out.writeObject(src);

            ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
            ObjectInputStream in = new ObjectInputStream(byteIn);
            dest = (List<T>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return dest;
    }
}

