package crw.bishe.team.controller.test;

import crw.bishe.team.controller.MyWebSocket;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@Api(tags = {"websocket"})
@RestController
public class TaskWebSokcetController {

    @GetMapping("/insert/{message}")
    public void insert(@PathVariable("message") String message) throws IOException {
        MyWebSocket myWebSocket = new MyWebSocket();
        myWebSocket.onMessage(message);
    }

}
