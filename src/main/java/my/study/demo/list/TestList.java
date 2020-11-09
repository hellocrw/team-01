package my.study.demo.list;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TestList {
    public static void main(String[] args) {
        List<EntityPo> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            EntityPo entityPo = EntityPo.builder().id(i).name("name" + i).build();
            list.add(entityPo);
        }
        // list.stream().forEach(item -> System.out.println(item));
        List<EntityPo> collect = list.stream().map(item -> {
            if (item.getId()<5){

            }
            return item;
        }).collect(Collectors.toList());
        System.out.println(collect);


    }


}
