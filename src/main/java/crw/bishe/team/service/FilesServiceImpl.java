package crw.bishe.team.service;

import crw.bishe.team.dto.FilesDto;
import crw.bishe.team.mapper.FilesMapper;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description Description
 * @Author crw
 * @Date Created in 2020/2/22 0022
 * @Time 5:31
 */
@Service
public class FilesServiceImpl implements FilesService {

    @Autowired
    private FilesMapper filesMapper;

    @Value("${file.upload.url}")
    private String uploadPath;

    @Override
    public String[] uploadFiles(MultipartFile[] files) {
        String[] fileNames = new String[files.length];
        // 多文件上传
        if (files != null && files.length > 1){
            BufferedOutputStream bufferedOutputStream = null;
            try {
                for (int i = 0; i < files.length; i++) {
                    // 获取文件名
                    fileNames[i] = files[i].getOriginalFilename();
                    if (StringUtils.isEmpty(fileNames[i])){
                        // 创建文件对象
                        File dest = new File(uploadPath + fileNames[i]);
                        // 拷贝文件到文件对象
                        FileUtils.copyInputStreamToFile(files[i].getInputStream(), dest);
                        // 判断路径是否存在，如果不存在则创建
                        if (!dest.getParentFile().exists()){
                            dest.getParentFile().mkdirs();
                        }
                        // 将文件保存到服务器上
                        files[i].transferTo(dest);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (bufferedOutputStream != null){
                        bufferedOutputStream.close();
                    }
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
        return fileNames;
    }

    @Override
    public void downloadFile(HttpServletResponse response, MultipartFile file) throws Exception {
        String filePath = uploadPath + file.getOriginalFilename();
        // 文件地址
        File dest = new File(filePath);
        // 创建输入对象
        FileInputStream fileInputStream = new FileInputStream(dest);
        // 设置相关格式
        response.setContentType("application/force-download");
        // 设置下载后的文件名以及header
        response.addHeader("Content-disposition","attachment;fileName=" + file.getOriginalFilename());
        // 创建输出对象
        OutputStream outputStream = response.getOutputStream();
        byte[] buf = new byte[1024];
        int len = 0;
        while ((len = fileInputStream.read(buf)) != -1){
            outputStream.write(buf, 0 , len);
        }
        fileInputStream.close();
    }

    @Override
    public List<FilesDto> getFilesByProId(String proId) {
        Long key = Long.parseLong(proId);
        return filesMapper.getFilesByProId(key);
    }

    @Override
    public Integer deleteByProIds(List<String> proIds) {
        List<Long> proIds_list = new ArrayList<>();
        proIds.forEach(proId ->{
            proIds_list.add(Long.parseLong(proId));
        });
        return filesMapper.delectByProIds(proIds_list);
    }
}
