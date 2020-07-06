package crw.bishe.team.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ServerEndpoint 表示标识作用在类上，主要功能是把当前类标识成一个WebSocket的服务器，注解的值用于客户端连接访问的URL地址
 * ws://127.0.0.1:8888/api/websocket/testname
 */
@ServerEndpoint(value = "/api/websocket/{name}")
@Component
@Log4j2
public class MyWebSocket {

    private static int onlineCount = 0;
    /**
     * 用于保存所有连接服务的客户端，这个对象存储是安全的
     */
    private static Map<String, MyWebSocket> clients = new ConcurrentHashMap<>();
    /**
     * 与某个客户的连接对话，需要通过它来给客户端发送消息
     */
    private Session session;
    /**
     * 标识当前连接客户端的用户名
     */
    private String username;

    @OnOpen
    public void onOpen(Session session, @PathParam("name") String name) throws IOException {
        System.out.println("--------------open-----------");
        this.username = name;
        this.session = session;

        addOnlineCount();
        clients.put(username, this);
        System.out.println("已连接" + clients.size() + "人");
        System.out.println("当前连接人数为：" + clients.size());
        this.session.getAsyncRemote().sendText("恭喜你连接上WebSocket --> 当前人数为:" + clients.size());
    }

    @OnClose
    public void onClose() throws IOException{
        clients.remove(username);
        subOnlineCount();
        System.out.println("有一个连接关闭，当前在线人数为：" + clients.size());
    }

    @OnMessage
    public void onMessage(String message) throws IOException {

        System.out.println("来自客户端的消息:" + message);

        // 群发消息
        sendMessageAll(message);
    }

    @OnError
    public void onError(Throwable error){
        System.out.println("发生错误");
        error.printStackTrace();
    }

    private void sendMessageAll(String message) throws IOException {
        System.out.println("群发消息");
        for (MyWebSocket item: clients.values()){
            item.session.getAsyncRemote().sendText(message);
        }
    }

    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        MyWebSocket.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        MyWebSocket.onlineCount--;
    }

    public static synchronized Map<String, MyWebSocket> getClients() {
        return clients;
    }


}
