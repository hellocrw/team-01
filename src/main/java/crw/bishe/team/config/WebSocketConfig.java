package crw.bishe.team.config;

import crw.bishe.team.filter.SpringWebSocketHandlerIntercepter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * 如果采用springboot内置容器启动项目，则需要配置一个Bean；如果采用外部的容器，则可以不需要配置;
 *  编写一个WebSocketConfig配置类，注入对象ServerEndpointExporter,这个bean会自动注册了@ServerEndpoint注解声明的WebSocket endpoint
 */
@Configuration
public class WebSocketConfig {

    @Bean
    public ServerEndpointExporter serverEndpointExporter(){
        return new ServerEndpointExporter();
    }

}
