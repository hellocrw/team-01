package my.study.demo.test;

public class Demo04 {

    public static void main(String[] args) {
        String element = "test";
        System.out.println(element.substring(0, 1));
        System.out.println(element.indexOf("e"));
        element = "te" + element;
        System.out.println(element);

    }
}
