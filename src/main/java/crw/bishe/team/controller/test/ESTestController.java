package crw.bishe.team.controller.test;

import cn.hutool.json.JSON;
import crw.bishe.team.entity.User;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.support.master.AcknowledgedRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("elasticsearch")
public class ESTestController {

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    /**
     * 创建索引
     * @throws IOException
     */
    @GetMapping("/createIndex")
    public void createIndex() throws IOException {
        // 1. 创建索引请求
        CreateIndexRequest request = new CreateIndexRequest("kuang_index");
        // 2. 客户端执行请求 IndicessClient ，请求后获得响应
        CreateIndexResponse createIndexResponse = restHighLevelClient.indices()
                .create(request, RequestOptions.DEFAULT);
        System.out.println(createIndexResponse);
    }

    /**
     * 判断索引是否存在
     * @throws IOException
     */
    @GetMapping("/existIndex")
    public void existIndex() throws IOException {
        GetIndexRequest request = new GetIndexRequest("kuang_index");
        boolean res = restHighLevelClient.indices().exists(request, RequestOptions.DEFAULT);
        System.out.println("existIndex");
        System.out.println(res);
    }

    /**
     * 删除索引
     * @throws IOException
     */
    @GetMapping("deleteIndex")
    public void deleteIndex() throws IOException {
        DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest("kuang_index");
        AcknowledgedResponse acknowledgedResponse = restHighLevelClient.indices().delete(deleteIndexRequest, RequestOptions.DEFAULT);
        System.out.println(acknowledgedResponse.isAcknowledged());
    }

    public void addDocument(){
        User user = new User("zhangsan", "18");
//        String s = JSON
    }

}
