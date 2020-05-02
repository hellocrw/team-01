package crw.bishe.team.service;

import crw.bishe.team.dto.SubTaskDto;

import java.util.List;
import java.util.Map;

public interface SubTaskService {

    Integer deleteByTaskIds( List<String> taskIds);

    List<SubTaskDto> selectByTaskIds(List<String> taskIds);
}
