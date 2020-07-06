package crw.bishe.team.controller.IO;

import crw.bishe.team.vo.Result;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;

@RestController
@Api(tags = {"IO流"})
@RequestMapping(value = "/api/io")
public class IOController {

    /**
     * 输入流
     * @return
     */
    @GetMapping(value = "/fileInputStream")
    public void fileInputStream() throws IOException {
        int i = 0;
        int num = 0; // 记录字节个数
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream("D:\\temp\\a.txt");  // 从文件中读取数据
        } catch (FileNotFoundException e) {
            System.out.println("找不到文件所在位置");
            e.printStackTrace();
        }
        try {
            while ((i = inputStream.read()) != -1){
                System.out.print((char)i + " ");
                num++;
            }
        } catch (IOException e) {
            System.out.println("文件读取错误");
            e.printStackTrace();
        }
        finally {
            inputStream.close();
            System.out.println("传输字节个数："+num);
        }
    }

    /**
     * 输出流 FileOutputStream
     * @throws IOException
     */
    @GetMapping(value = "/fileOutputStream")
    public void fileOutputStream() throws IOException {
        int i = 0;
        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;
        try {
            inputStream = new FileInputStream("D:\\temp\\a.txt");
            outputStream = new FileOutputStream("D:\\temp\\b.txt");
            while ((i = inputStream.read())!= -1){
                outputStream.write(i);
                System.out.print((char)i + " ");
            }
            System.out.println("文件已复制");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("文件复制错误");
            System.exit(-1);
        }finally {
            inputStream.close();
            outputStream.close();
        }
    }

    @GetMapping("/fileReadWriter")
    public void fileReadWriter() throws IOException {
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        int i = 0;
        try {
            fileReader = new FileReader("D:\\temp\\a.txt");
            fileWriter = new FileWriter("D:\\temp\\b.txt");
            while ((i = fileReader.read()) != -1){
                fileWriter.write(i);
                System.out.print((char)i+" ");
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("文件复制错误");
        }
        finally {
            fileReader.close();
            fileWriter.close();
        }

    }

}
