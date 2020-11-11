package my.study.demo.list;

public class CollectionUtilsTest {
    public static void main(String[] args) {
        EntityPo entityPo = EntityPo.builder().build();
        test();

        System.out.println("end");

    }

    public static String test(){
        String i = "100";
        i += "ces";
        System.out.println("测试");
        return i;
    }
}
