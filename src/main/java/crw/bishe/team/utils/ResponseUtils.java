package crw.bishe.team.utils;

import crw.bishe.team.vo.Result;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 数据返回格式
 */
@Component
public class ResponseUtils {
    private final static Integer SUCCESS = 200;
    private final static Integer FAULT = 500;
    private final static String SUCCESS_MSG = "success";
    private final static String FAULT_MSG = "fault";

    public ResponseEntity<Result> success(Map<String, Object> data){
        return new ResponseEntity<>(new Result(SUCCESS, SUCCESS_MSG, data), HttpStatus.OK);
    }

    public ResponseEntity<Result> fault(Map<String, Object> data){
        return new ResponseEntity<>(new Result(FAULT, FAULT_MSG), HttpStatus.BAD_REQUEST);
    }
}
