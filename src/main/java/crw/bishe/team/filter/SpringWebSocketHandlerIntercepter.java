package crw.bishe.team.filter;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * webSocket连接的拦截器
 * 记录建立连接的用户的session，以便根据不同session来通信
 */
public class SpringWebSocketHandlerIntercepter extends HttpSessionHandshakeInterceptor {

    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response,
                                   WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {
        System.out.println("调用了SpringWebSocketHandlerIntercepter #BeforeHandsake");
        if (request instanceof ServletServerHttpRequest){
            ServletServerHttpRequest servletRequest = (ServletServerHttpRequest) request;
            HttpSession session = servletRequest.getServletRequest().getSession(false);
            if (session != null) {
                // 使用username 区分 webSocketHandler，以便定向发送消息
                String userName = (String) session.getAttribute("SESSION_USERNAME"); // 一般直接保存user实体
                if (userName != null){
                    attributes.put("WEBSOCKET_USERID", userName);
                }
            }
            /* 在拦截器中强行修改websocket协议，将部分浏览器不支持的x-webkit-deflate-frame扩展修改成permessage-deflate */
            if(request.getHeaders().containsKey("Sec-WebSocket-Extensions")){
                request.getHeaders().set("Sec-WebSocket-Extensions", "permessage-deflate");
            }
        }
        return super.beforeHandshake(request, response, wsHandler, attributes);
    }

    @Override
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Exception ex) {
        System.out.println("SpringWebSocketHandlerIntercepter #afterHandshake");
        super.afterHandshake(request, response, wsHandler, ex);
    }
}
