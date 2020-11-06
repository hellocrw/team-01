package crw.bishe.team.utils;

import crw.bishe.team.kafka.KafkaMessagePo;

import java.util.Map;

public class KafkaMessageUtils {

    public KafkaMessagePo setKafkaMessage(Map<String,Object> map){
        KafkaMessagePo kafkaMessagePo = new KafkaMessagePo();
        kafkaMessagePo.setUrl(map.get("url")==null?null:map.get("url").toString());
        kafkaMessagePo.setSubject(map.get("subject")==null?null:map.get("subject").toString());
        kafkaMessagePo.setCurrentUser(map.get("currentUser")==null?null:map.get("currentUser").toString());
        kafkaMessagePo.setApplyUser(map.get("applyUser")==null?null:map.get("applyUser").toString());
        kafkaMessagePo.setApplyTime(map.get("applyTime")==null?null:map.get("applyTime").toString());
        kafkaMessagePo.setSerialNumber(map.get("serialNumber")==null?null:map.get("serialNumber").toString());
        kafkaMessagePo.setProcessId(map.get("processId")==null?null:map.get("processId").toString());
        kafkaMessagePo.setNodeId(map.get("nodeId")==null?null:map.get("nodeId").toString());
        kafkaMessagePo.setIsMerge(map.get("isMerge")==null?null:map.get("isMerge").toString());
        kafkaMessagePo.setLastUpdateTime(map.get("lastUpdateTime")==null?null:map.get("lastUpdateTime").toString());
        kafkaMessagePo.setPriorityCode(map.get("priorityCode")==null?null:map.get("priorityCode").toString());
        kafkaMessagePo.setBisCode(map.get("bisCode")==null?null:map.get("bisCode").toString());
        kafkaMessagePo.setApproveUser(map.get("approveUser")==null?null:map.get("approveUser").toString());
        kafkaMessagePo.setStatus(map.get("status")==null?null:map.get("status").toString());
        kafkaMessagePo.setDeadline(map.get("deadline")==null?null:map.get("deadline").toString());
        kafkaMessagePo.setNodeName(map.get("nodeName")==null?null:map.get("nodeName").toString());
        kafkaMessagePo.setProcessName(map.get("processName")==null?null:map.get("processName").toString());
        return kafkaMessagePo;
    }
}
