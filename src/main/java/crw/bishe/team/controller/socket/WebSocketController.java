package crw.bishe.team.controller.socket;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"websocket通信"})
@RestController
@RequestMapping("/api/web-socket")
public class WebSocketController {

//    private MyWebSocket webSocket = new MyWebSocket();
//
//    @GetMapping()
//    public void sendMsg(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        webSocket.onMessage(request.getSession().getId());
//    }
}
