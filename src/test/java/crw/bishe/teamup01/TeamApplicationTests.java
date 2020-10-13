package crw.bishe.teamup01;

import javafx.application.Application;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

@SpringBootTest(classes = SpringJUnit4ClassRunner.class)
class TeamApplicationTests {

    @Autowired
    @Qualifier("restHighLevelClient")
    private RestHighLevelClient client;

    // 索引的创建  Request
    @Test
    void testCreateIndex() throws IOException {
        // 创建索引请求
        CreateIndexRequest request = new CreateIndexRequest("kuang_index");
        // 客户端执行请求 IndicessClient ，请求后获得响应
        CreateIndexResponse createIndexResponse = client.indices().create(request, RequestOptions.DEFAULT);

        System.out.println(createIndexResponse);
    }


    @Test
    void contextLoads() {
        System.out.println("test");
    }

}
