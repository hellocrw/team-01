package crw.bishe.team.service;

import crw.bishe.team.dto.FilesDto;
import crw.bishe.team.dtoEntityMapping.FilesMapping;
import crw.bishe.team.entity.Files;
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

    @Autowired
    private FilesMapping filesMapping;

    @Value("${file.upload.url}")
    private String uploadPath;

    @Override
    public String uploadFiles(MultipartFile files) {
        String fileName = null;
        // 文件上传
        if (files != null ){
            BufferedOutputStream bufferedOutputStream = null;
            try {
                // 获取文件名
                fileName = files.getOriginalFilename();
                if (!StringUtils.isEmpty(fileName)){
                    // 创建文件对象
                    File dest = new File(uploadPath + fileName);
                    // 拷贝文件到文件对象
                    FileUtils.copyInputStreamToFile(files.getInputStream(), dest);
                    // 判断路径是否存在，如果不存在则创建
                    if (!dest.getParentFile().exists()){
                        dest.getParentFile().mkdirs();
                    }
                    System.out.println("保存到服务器中");
                    // 将文件保存到服务器上
                    files.transferTo(dest);
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
        return fileName;
    }

    @Override
    public String downloadFile(HttpServletResponse response, String fileNames) throws Exception {
        String fileName = "team.sql";
        if (!StringUtils.isEmpty(fileName)){
            String filePath = uploadPath + fileName;
            // 文件地址
            File dest = new File(filePath);
            // 创建输入对象
            FileInputStream fileInputStream = new FileInputStream(dest);
            // 设置相关格式
            response.setContentType("application/force-download");
            // 设置下载后的文件名以及header
            response.addHeader("Content-disposition","attachment;fileName=" + fileName);
            try{
                // 创建输出对象
                OutputStream outputStream = response.getOutputStream();
                byte[] buf = new byte[1024];
                int len = 0;
                while ((len = fileInputStream.read(buf)) != -1){
                    outputStream.write(buf, 0 , len);
                }
            } catch (IOException e){
                e.printStackTrace();
            }finally {
                fileInputStream.close();
            }
        }
        return "下载成功";
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

    @Override
    public FilesDto saveFile(FilesDto filesDto) {
        Files files = filesMapping.toEntity(filesDto);
        Integer res = filesMapper.saveFile(files);
        return filesMapping.toDto(files);
    }

    @Override
    public Integer delectByFileId(String fileId) {
        Long key = Long.parseLong(fileId);
        return filesMapper.delectByFileId(key);
    }
}
