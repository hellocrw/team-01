package crw.bishe.team.kafka;

import java.util.List;

public interface KafkaService {
	
	/**
	 * 
	 * Method Name:  sendMessage
	 * Description:  发送消息
	 * @param messages
	 * @return void
	 * @exception 	
	 * @author lizhenwei
	 * @mail lizhenwei@ly-sky.com
	 * @date: 2018年11月30日
	 */
	void sendMessage(List<KafkaMessage<String>> messages);

}
