package my.study.demo.test;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.BeanUtils;

/**
 * BeanUtils.copyProperties深拷贝
 */
public class CopyBean {

    public static void main(String[] args) {
        Student student = new Student("1", "name1", 1);
        StudentVo studentVo = new StudentVo();
        BeanUtils.copyProperties(student, studentVo);
        student.setName("name2");
        System.out.println(JSON.toJSONString(studentVo));
        System.out.println(JSON.toJSONString(student));
    }

}
