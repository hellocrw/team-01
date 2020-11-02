package crw.bishe.team.kafka;

import lombok.Data;

@Data
public class KafkaMessagePo {

    /**
     * 消息跳转链接
     */
    private String url;

    /**
     * 标题
     */
    private String subject;

    /**
     * 当前办理人
     */
    private String currentUser;

    /**
     * 申请人
     */
    private String applyUser;

    /**
     * 申请时间
     */
    private String applyTime;

    /**
     * 流水号
     */
    private String serialNumber;

    /**
     * 流程编号
     */
    private String processId;

    /**
     * 节点编号
     */
    private String nodeId;

    /**
     * 是否可以合并
     */
    private String isMerge;

    /**
     * 最后更新时间
     */
    private String lastUpdateTime;

    /**
     * 紧急程度
     */
    private String priorityCode = "3";

    /**
     * 业务类型
     */
    private String bisCode = "YBT";

    /**
     * 审核人
     */
    private String approveUser;

    /**
     * 实例状态
     */
    private String status;

    /**
     * 截止时间
     */
    private String deadline;

    /**
     * 节点名称
     */
    private String nodeName;

    /**
     * 流程名称
     */
    private String processName;
}