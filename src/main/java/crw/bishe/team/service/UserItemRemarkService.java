package crw.bishe.team.service;

import java.util.List;
import java.util.Map;

public interface UserItemRemarkService {
    List<Map<String, Long>> getTeamTypeNum(String userId);
}
