package crw.bishe.team.service;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

/**
 * @Description Description
 * @Author crw
 * @Date Created in 2020/2/22 0022
 * @Time 5:28
 */
public interface FilesService {

    /**
     * 文件上传功能
     * @param files 上传的文件
     * @return
     */
    String[] uploadFiles(MultipartFile[] files);

    /**
     * 文件下载功能
     * @param response
     * @param file
     * @throws Exception
     */
    void downloadFile(HttpServletResponse response, MultipartFile file) throws Exception;
}
