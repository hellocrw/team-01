package crw.bishe.team.dtoEntityMapping;

import crw.bishe.team.dto.FilesDto;
import crw.bishe.team.entity.Files;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.text.SimpleDateFormat;

@Component("filesMapping")
public class FilesMappingImpl implements FilesMapping {

    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public Files toEntity(FilesDto filesDto) {
        if (filesDto == null){
            return null;
        }
        Files files = new Files();
        if (filesDto.getFileId() == null || filesDto.getFileId().equals("")){
            files.setFileId(null);
        }else{
            files.setFileId(Long.parseLong(filesDto.getFileId()));
        }
        files.setFileName(filesDto.getFileName());
        files.setFileLink(filesDto.getFileLink());
        files.setUserId(Long.parseLong(filesDto.getUserId()));
        files.setUserName(filesDto.getUserName());
        files.setProId(Long.parseLong(filesDto.getProId()));
        files.setProName(filesDto.getProName());
        files.setUploadTime(Date.valueOf(filesDto.getUploadTime()));
        return files;
    }

    @Override
    public FilesDto toDto(Files files) {
        if (files == null){
            return null;
        }
        FilesDto filesDto = new FilesDto();
        filesDto.setFileId(String.valueOf(files.getFileId()));
        filesDto.setFileName(files.getFileName());
        filesDto.setFileLink(files.getFileLink());
        filesDto.setUserId(String.valueOf(files.getUserId()));
        filesDto.setUserName(files.getUserName());
        filesDto.setProId(String.valueOf(files.getProId()));
        filesDto.setProName(files.getProName());
        filesDto.setUploadTime(simpleDateFormat.format(files.getUploadTime()));
        return filesDto;
    }
}
