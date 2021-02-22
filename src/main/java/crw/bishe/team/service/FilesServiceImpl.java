package crw.bishe.team.service;

import crw.bishe.team.dto.FilesDto;
import crw.bishe.team.dtoEntityMapping.FilesMapping;
import crw.bishe.team.entity.Files;
import crw.bishe.team.mapper.FilesMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description Description
 * @Author crw
 * @Date Created in 2020/2/22 0022
 * @Time 5:31
 */
@Service
@Slf4j
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
    public String downloadFile(HttpServletResponse response, String fileName) throws Exception {
        File file = new File(uploadPath + fileName);
        if (!file.exists()){
            return "文件不存在";
        }
        byte[] bytes = new byte[1024];
        BufferedInputStream bufferedInputStream = null;
        OutputStream outputStream = null;
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            bufferedInputStream = new BufferedInputStream(fileInputStream);
            response.setContentType("application/force-download");
            response.setHeader("Content-Disposition",
                    "attachment;filename=" + new String(fileName.getBytes("utf-8"), "ISO8859-1"));
            outputStream = response.getOutputStream();
            int length;
            while ((length = bufferedInputStream.read(bytes)) != -1){
                outputStream.write(bytes, 0, length);
            }
            outputStream.flush();
        }catch (Exception e){
            log.error("文件下载失败", e);
        }finally {
            try {
                if (bufferedInputStream != null){
                    bufferedInputStream.close();
                }

                if (outputStream != null){
                    outputStream.close();
                }

                if (fileInputStream != null){
                    fileInputStream.close();
                }
            }catch (IOException e){
                log.error(e.getMessage(), e);
            }
        }
        return "success";
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
