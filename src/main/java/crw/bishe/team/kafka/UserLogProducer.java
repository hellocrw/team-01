package crw.bishe.team.kafka;

import com.alibaba.fastjson.JSON;
import crw.bishe.team.dto.UserLogDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * 定义消息的发送者
 */
@Component
public class UserLogProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    /**
     * 发送数据
     * @param userid
     */
    public void sendLog(String userid){
        UserLogDto userLogDto = UserLogDto.builder()
                .username("jhp")
                .userid(userid)
                .state("0")
                .build();
        System.out.println("发送用户日志数据" + userLogDto);
        kafkaTemplate.send("user-log", JSON.toJSONString(userLogDto));

    }


}
