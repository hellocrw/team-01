package crw.bishe.team.kafka;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.List;
import java.util.UUID;

public class KafkaMesssageThread extends Thread{
	
	
	KafkaTemplate<String,String> kafkaTemplate;
	
	List<KafkaMessage<String>> messages;
	
	private String topic;
	
	public KafkaMesssageThread(KafkaTemplate<String,String> kafkaTemplate, String topic, List<KafkaMessage<String>> messages) {
		super();
		this.kafkaTemplate = kafkaTemplate;
		this.topic = topic;
		this.messages = messages;
	}

	public void run() {
		if(messages!=null && messages.size()>0){
			int messageCount = messages.size();
			int splitSize = 1800;
			System.out.println("messageCount : " + messageCount);
			if (messageCount > splitSize) {
				System.out.println("messageCount : " + messageCount);
				int size = (messageCount/splitSize + (messageCount%splitSize>0?1:0));
				for (int i=0; i < size; i++) {
					List<KafkaMessage<String>> messagesSplit = messages.subList(splitSize*i, i==size-1?messageCount:splitSize*(i+1));
					String message = createMessage(messagesSplit);
//					ProducerRecord<String,String> record = new ProducerRecord<String,String>(topic, message);
//					kafkaTemplate.send(record);
					String key = UUID.randomUUID().toString();
					kafkaTemplate.send(topic, key, message);
				}
			} else {
				System.out.println("messageCount : " + messageCount);
				String message = createMessage(messages);
//				ProducerRecord<String,String> record = new ProducerRecord<String,String>(topic, message);
//				kafkaTemplate.send(record);
				String key = UUID.randomUUID().toString();
				kafkaTemplate.send(topic, key, message);
			}
		}
	}
	
	private String createMessage(List<KafkaMessage<String>> messages) {
		return new StringBuilder().append("{data:").append(JSON.toJSONString(messages, SerializerFeature.WriteMapNullValue)).append("}").toString();
	}
}
