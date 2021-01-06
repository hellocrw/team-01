package my.study.demo.test;

import lombok.extern.slf4j.Slf4j;
import my.study.demo.bean.User;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class TestDemo01 {

    public static void main(String[] args) {
        User user = new User();
        List<User> userList = new ArrayList<>();
        userList.forEach(item -> {
            System.out.println("test");
            System.out.println(item);
        });
        try {
            User user1 = User.builder().name(userList.get(0).getName()).build();
        }catch (Exception e){
            log.error(e.getMessage(), e);
        }
    }
}
