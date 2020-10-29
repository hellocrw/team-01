package crw.bishe.team.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
public class KafaServiceImpl implements KafkaService{

	@Autowired
    KafkaTemplate<String,String> kafkaTemplate;
	
	@Value("${spring.kafka.producer.topic}")
	private String topic;
	
	@Value("${spring.kafka.enable}")
	private String enable;

	@Override
	public void sendMessage(List<KafkaMessage<String>> messages) {
		if("true".equals(enable)){
			KafkaMesssageThread thread = new KafkaMesssageThread(kafkaTemplate, topic, messages);
			thread.start();
		}
	}
}
