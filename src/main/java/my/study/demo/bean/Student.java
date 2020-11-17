package my.study.demo.bean;

import java.util.Objects;

public class Student {
    private String type;
    private String name;
    private  int age;
    public Student(String type, String name, int age){
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
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()){
            return false;
        }
        Student student = (Student)obj;
        if (this == obj){
            return true;
        }
        return (Objects.equals(name, student.name) && (Objects.equals(type, student.type)) && Objects.equals(age, student.age));
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type, age);
    }
}

