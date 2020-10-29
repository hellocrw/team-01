package crw.bishe.team.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.kafka.support.ProducerListener;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class KafkaProducerListener implements ProducerListener {

    /**
     * 成功时调用
     * @param topic
     * @param partition
     * @param key
     * @param value
     * @param recordMetadata
     */
    @Override
    public void onSuccess(String topic, Integer partition, Object key, Object value, RecordMetadata recordMetadata) {
        log.info("==========kafka发送数据成功（日志开始）==========");
        log.info("----------topic:" + topic);
        log.info("----------partition:" + partition);
        log.info("----------key:" + key);
        log.info("----------value:" + value);
        log.info("----------RecordMetadata:" + recordMetadata);
        log.info("~~~~~~~~~~kafka发送数据成功（日志结束）~~~~~~~~~~");
    }

    /**
     * 失败时调用
     * @param topic
     * @param partition
     * @param key
     * @param value
     * @param exception
     */
    @Override
    public void onError(String topic, Integer partition, Object key, Object value, Exception exception) {
        log.info("==========kafka发送数据错误（日志开始）==========");
        log.info("----------topic:" + topic);
        log.info("----------partition:" + partition);
        log.info("----------key:" + key);
        log.info("----------value:" + value);
        log.info("----------Exception:" + exception);
        log.info("~~~~~~~~~~kafka发送数据错误（日志结束）~~~~~~~~~~");
        exception.printStackTrace();
    }

    /**
     * 启动监听
     * @return
     */
    @Override
    public boolean isInterestedInSuccess() {
        return true;
    }
}
