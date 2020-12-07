package bigdata.demo.hadoop.HdfsOparetion;

import org.apache.commons.io.IOUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.FsUrlStreamHandlerFactory;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * 获取文件系统
 */
public class GetFileSystem {

    /**
     * URL 访问方式
     */
    @Test
    public void demo1() throws Exception {
        // 第一步：注册hdfs的url
        URL.setURLStreamHandlerFactory(new FsUrlStreamHandlerFactory());
        // 获取文件输入流
        InputStream inputStream = new URL("hdfs://192.168.92.135:9000/crw/a.txt").openStream();
        // 获取文件输出流
        FileOutputStream outputStream = new FileOutputStream(new File("D:\\hello.txt"));

        // 实现文件的拷贝
        IOUtils.copy(inputStream, outputStream);

        // 关闭流
        IOUtils.closeQuietly(inputStream);
        IOUtils.closeQuietly(outputStream);
    }

    /**
     * 获取FileSystem
     * @throws IOException
     */
    @Test
    public void getFileSystem() throws IOException {
        // 创建Configuration对象
        Configuration configuration = new Configuration();
        // 设置文件系统类型
        configuration.set("fs.defaultFS", "hdfs://192.168.92.135:9000");
        // 获取指定的文件系统
        FileSystem fileSystem = FileSystem.get(configuration);
        // 输出
        System.out.println(fileSystem);
    }

    /**
     * 方式2 ：获取fileSystem
     * @throws URISyntaxException
     * @throws IOException
     */
    @Test
    public void getFileSystem2() throws URISyntaxException, IOException {
        FileSystem fileSystem = FileSystem.get(new URI("hdfs://192.168.92.135:9000"), new Configuration());
        System.out.println(fileSystem);
    }

    /**
     * 方式3：获取文件系统
     * @throws IOException
     */
    @Test
    public void getFileSystem3() throws IOException {
        Configuration configuration = new Configuration();
        // 指定文件系统类型
        configuration.set("fs.defaultFS", "hdfs://192.168.92.135:9000");
        // 获取指定的文件系统
        FileSystem fileSystem = FileSystem.newInstance(configuration);
        System.out.println(fileSystem);
    }

    @Test
    public void getFileSystem4() throws URISyntaxException, IOException {
        FileSystem fileSystem = FileSystem.newInstance(new URI("hdfs://192.168.92.135:9000"), new Configuration());
        System.out.println(fileSystem);
    }
}
