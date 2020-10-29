package crw.bishe.team.kafka;

import lombok.Data;
import lombok.ToString;

/**
 * 消息实体类
 * @param <T>
 */
@Data
@ToString
public class KafkaMessage<T> {
    /**
     * id
     */
    private String id;

    /**
     * 发送时间
     */
    private String sendTime;

    /**
     * 消息体
     */
    private T message;

}
