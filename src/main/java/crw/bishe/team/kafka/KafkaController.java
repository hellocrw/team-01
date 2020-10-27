package crw.bishe.team.kafka;


import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = {"kafka"})
public class KafkaController {

    @Autowired
    private UserLogProducer userLogProducer;

    @GetMapping("/kafka/producer")
    public void producer(String id){
        userLogProducer.sendLog(id);
    }
}
