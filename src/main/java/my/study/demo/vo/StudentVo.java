package my.study.demo.vo;

import java.util.Objects;

public class StudentVo {
    private String type;
    private String name;

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

    public StudentVo() {
    }

    public StudentVo(String type, String name) {
        this.type = type;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()){
            return false;
        }
        StudentVo student = (StudentVo)obj;
        if (this == obj){
            return true;
        }
        return (Objects.equals(name, student.name) && (Objects.equals(type, student.type)));
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type);
    }

    @Override
    public String toString() {
        return "StudentVo{" + "name='" + name + '\'' + ", type=" + type + '}';
    }
}
