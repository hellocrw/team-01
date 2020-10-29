package crw.bishe.team.kafka;


import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = {"kafka"})
public class KafkaController {

    @Autowired
    private UserLogProducer userLogProducer;

    @Autowired KafkaService kafkaService;

    @GetMapping("/kafka/producer")
    public void producer(String id){
        userLogProducer.sendLog(id);
    }

    @PostMapping("/kafka/producer2")
    public void producer2(@RequestBody List<KafkaMessage<String>> kafkaMessages){
        kafkaService.sendMessage(kafkaMessages);
    }
}
