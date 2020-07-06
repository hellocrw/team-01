package crw.bishe.team.controller.IO;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

@RestController
@Api(tags = {"socket通信"})
@RequestMapping(value = "/api/socket")
public class socketController {

    @GetMapping("/server")
    public void serverSocket(){
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("启动服务器");
            Socket socket = serverSocket.accept();
            System.out.println("客户端:" + socket.getInetAddress().getHostName() + "已连接到服务器");

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // 读取客户端发来的消息
            String message = bufferedReader.readLine();
            System.out.println("client:"+message);
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bufferedWriter.write(message+"\n");
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/client")
    public void clientServer(){
        try {
            Socket socket = new Socket("127.0.0.1", 8080);
            // 构建IO
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
            // 向服务器发送一条消息
            bufferedWriter.write("测试客户端和服务器通信，服务器收到消息返回到客户端\n");
            bufferedWriter.flush();

            // 读取服务器返回的消息
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String message = bufferedReader.readLine();
            System.out.println("server:"+ message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
