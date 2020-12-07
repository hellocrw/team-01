package bigdata.demo.hadoop.HdfsOparetion;

import org.apache.commons.io.IOUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class OparetionHDFS {

    /**
     * hdfs文件的遍历， 文件的上传和下载
     * @throws URISyntaxException
     * @throws IOException
     */
    @Test
    public void listMyFiles() throws URISyntaxException, IOException {
        // 获取FileSystem实例
        FileSystem fileSystem = FileSystem.get(new URI("hdfs://192.168.92.135:9000"), new Configuration());
        // 调用方法listFiles 获取/目录下所有的文件信息
        RemoteIterator<LocatedFileStatus> iterator = fileSystem.listFiles(new Path("/"), true);
        // 遍历迭代器
        while (iterator.hasNext()){
            LocatedFileStatus fileStatus = iterator.next();
            // 获取文件的绝对路径 : hdfs://xxx:9000/xxx
            Path path = fileStatus.getPath();
            System.out.println(path + "----" + fileStatus.getPath().getName());
            // 文件的block信息
            BlockLocation[] blockLocations = fileStatus.getBlockLocations();
            System.out.println("block数：" + blockLocations.length);
        }
    }

    /**
     * 创建文件夹以及文件
     */
    @Test
    public void mkdirs() throws URISyntaxException, IOException {
        FileSystem fileSystem = FileSystem.get(new URI("hdfs://192.168.92.135:9000"), new Configuration());
        // 创建文件夹
        boolean bl = fileSystem.mkdirs(new Path("/aaa/bbb/ccc"));
        // 创建文件
        fileSystem.create(new Path("/aaa/bbb/ccc/a.txt"));
        System.out.println(bl);
        // 关闭fileSystem
        fileSystem.close();
    }

    /**
     * 下载文件
     */
    @Test
    public void downloadFile() throws URISyntaxException, IOException {
        FileSystem fileSystem = FileSystem.get(new URI("hdfs://192.168.92.135:9000"), new Configuration());
        // 获取hdfs输入流
        FSDataInputStream inputStream = fileSystem.open(new Path("/crw/a.txt"));
        // 获取本地路径的输出流
        FileOutputStream outputStream = new FileOutputStream("D://a.txt");
        // 文件拷贝
        IOUtils.copy(inputStream, outputStream);
        // 关闭流
        IOUtils.closeQuietly(inputStream);
        IOUtils.closeQuietly(outputStream);
        fileSystem.close();
    }
    /**
     * 下载文件2
     */
    @Test
    public void downloadFile2() throws URISyntaxException, IOException, InterruptedException {
        FileSystem fileSystem = FileSystem.get(new URI("hdfs://192.168.92.135:9000"), new Configuration(), "root");
        fileSystem.copyToLocalFile(false,new Path("/bin_txt.txt"), new Path("D://big_txt.txt"),true);
        fileSystem.close();
    }

    /**
     * 文件上传
     */
    @Test
    public void uploadFile() throws URISyntaxException, IOException {
        FileSystem fileSystem = FileSystem.get(new URI("hdfs://192.168.92.135:9000"), new Configuration());
        fileSystem.copyFromLocalFile(new Path("D://hello.txt"), new Path("/crw"));
        fileSystem.close();
    }

    /**
     * 小文件的合并
     */
    @Test
    public void mergeFile() throws URISyntaxException, IOException, InterruptedException {
        // 获取FileSystem文件系统
        FileSystem fileSystem = FileSystem.get(new URI("hdfs://192.168.92.135:9000"), new Configuration(), "root");
        // 获取hdfs大文件输出流
        FSDataOutputStream outputStream = fileSystem.create(new Path("/bin_txt.txt"));
        // 获取本地文件系统
        LocalFileSystem localFileSystem = FileSystem.getLocal(new Configuration());
        // 获取本地文件夹下所有文件的详情
        FileStatus[] fileStatuses = localFileSystem.listStatus(new Path("D:\\input"));
        // 遍历每个文件，获取每个文件的输入流
        for (FileStatus fileStatuse: fileStatuses) {
            FSDataInputStream inputStream = localFileSystem.open(fileStatuse.getPath());
            // 将小文件的数据复制到大文件
            IOUtils.copy(inputStream, outputStream);
            IOUtils.closeQuietly(inputStream);
        }
        // 关闭流
        IOUtils.closeQuietly(outputStream);
        localFileSystem.close();
        fileSystem.close();
    }
}
