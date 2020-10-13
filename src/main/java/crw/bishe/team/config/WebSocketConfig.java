package crw.bishe.team.config;

import crw.bishe.team.filter.SpringWebSocketHandlerIntercepter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * 如果采用springboot内置容器启动项目，则需要配置一个Bean；如果采用外部的容器，则可以不需要配置;
 *  编写一个WebSocketConfig配置类，注入对象ServerEndpointExporter,这个bean会自动注册了@ServerEndpoint注解声明的WebSocket endpoint
 */
@Component("webSocketConfig")
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer{

    @Bean
    public ServerEndpointExporter serverEndpointExporter(){
        return new ServerEndpointExporter();
    }

    // 注册具体的服务
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
        // 参数：WebSocket处理器，webSocket访问地址
//        webSocketHandlerRegistry.addHandler().addInterceptors();
    }
}
