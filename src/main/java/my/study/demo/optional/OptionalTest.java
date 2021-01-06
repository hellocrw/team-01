package my.study.demo.optional;

import my.study.demo.bean.User;

import java.util.Optional;

public class OptionalTest {
    public static void main(String[] args) throws Exception {
        myFunc2();
//        OptionalTest.mapTest();
//        OptionalTest.getUser();
//        OptionalTest.test();
//        OptionalTest.throwTest();
    }

    public static void getUser(){
        User user = User.builder().id(1).age("2").name("lisi").build();
        System.out.println(user);
        Optional.ofNullable(user).filter(u ->
                "zhangsan".equals(u.getName())).orElseGet(() -> {
            user.setName("zhangsan");
            return user;
        });
        System.out.println(user);
    }

    public static void test(){
        User user = User.builder().age("2").name("李四").build();
        System.out.println(user);
        User user1 = User.builder().id(2).age("2").name("李四").build();
        System.out.println(user1);
        Integer integer = Optional.ofNullable(user.getId()).orElse(1);
        Integer integer1 = Optional.ofNullable(user.getId()).orElseGet(()-> {
           user.setId(5);
           return user.getId();
        });
        System.out.println(integer);
        System.out.println(integer1);
        System.out.println(user);
    }

    public static void throwTest() throws Exception {
        User user = User.builder().id(1).build();
        User user2 = null;
        Optional.ofNullable(user).orElseThrow( () -> new Exception("用户不存在"));
    }

    public static void mapTest(){
        User user = User.builder().age("2").name("李四").build();
        String s = Optional.ofNullable(user).map(u -> u.getName()).get();
        System.out.println(s);
    }

    public static void myFunc(){
        User user = User.builder().id(1).name("张三").build();
        User nullUser = null;
        User nullValue = null;
        // 判读是否为空
        boolean present = Optional.ofNullable(user).isPresent();
        System.out.println(present);
//        String name = Optional.ofNullable(user).map(u -> u.getName()).get();
//        System.out.println(name);
        Optional<User> user1 = Optional.of(user);
        User user2 = user1.get();
        System.out.println(user2);

        User user3 = Optional.ofNullable(user).orElse(nullUser);
        // 判断是否相等
        boolean equals = Optional.ofNullable(user.getName()).equals(Optional.of("张三"));
        System.out.println("是否相等: " + (equals ? "是" : "否"));
        System.out.println(user3);

    }

    public static void myFunc2(){
        User user = null;
        // ifPresent
        Optional.ofNullable(user).ifPresent(u -> System.out.println(u));
        // map
        User user2 = Optional.ofNullable(user).map(u -> User.builder().age("3").build()).orElse(User.builder().name("2").build());
        System.out.println(user2);

        User user1 = User.builder().age("2").name("李四").build();
        String s = Optional.ofNullable(user1).map(u -> u.getName()).get();
        System.out.println(s);
        Optional<String> stringOptional = Optional.of("3");
    }


}
