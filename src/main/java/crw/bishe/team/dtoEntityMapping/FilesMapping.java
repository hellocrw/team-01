package crw.bishe.team.dtoEntityMapping;

import crw.bishe.team.dto.FilesDto;
import crw.bishe.team.entity.Files;

public interface FilesMapping {
    Files toEntity(FilesDto filesDto);
    FilesDto toDto(Files files);
}
