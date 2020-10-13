package crw.bishe.team.controller.test;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import crw.bishe.team.entity.User;
import io.swagger.annotations.Api;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.master.AcknowledgedRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * elasticsearch测试类
 */
@Api(tags = {"elasticsearch测试类"})
@RestController
@RequestMapping("elasticsearch")
public class ESTestController {

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    /**
     * 创建索引
     * @throws IOException
     */
    @PostMapping("/createIndex")
    public void createIndex() throws IOException {
        // 1. 创建索引请求
        CreateIndexRequest request = new CreateIndexRequest("crw");
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
        GetIndexRequest request = new GetIndexRequest("crw");
        boolean res = restHighLevelClient.indices().exists(request, RequestOptions.DEFAULT);
        System.out.println(res);
    }

    /**
     * 删除索引
     * @throws IOException
     */
    @DeleteMapping("/deleteIndex")
    public void deleteIndex() throws IOException {
        DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest("crw");
        AcknowledgedResponse acknowledgedResponse = restHighLevelClient.indices().delete(deleteIndexRequest, RequestOptions.DEFAULT);
        System.out.println(acknowledgedResponse.isAcknowledged());
    }

    /**
     * 添加文档  put /crw/_doc/1 {xxx}
     */
    @PostMapping("/addDocument")
    public void addDocument() throws IOException {
        User user = new User("aab", "18");
        JSONObject obj = JSONUtil.parseObj(user);
        System.out.println(obj);
        IndexRequest indexRequest = new IndexRequest("crw");
        indexRequest.source(obj, XContentType.JSON);
        indexRequest.timeout(TimeValue.timeValueSeconds(1));
        indexRequest.id("4");
        IndexResponse index = restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
        System.out.println(index.toString());
        System.out.println(index.status());
    }

    /**
     * 判断文档是否存在(和判断索引差不多)
     * @throws IOException
     */
    @GetMapping("/existDocument")
    public void existDocument() throws IOException {
        GetRequest getRequest = new GetRequest("crw", "2");
        boolean exists = restHighLevelClient.exists(getRequest, RequestOptions.DEFAULT);
        System.out.println(exists);
    }

    /**
     * 获取文档
     * @throws IOException
     */
    @GetMapping("/getDocument")
    public void getDocument() throws IOException {
        GetRequest getRequest = new GetRequest("crw", "2");
        GetResponse documentFields = restHighLevelClient.get(getRequest, RequestOptions.DEFAULT);
        System.out.println(documentFields);
        System.out.println(documentFields.getSourceAsString());
    }

    /**
     * 更新文档
     * @throws IOException
     */
    @PutMapping("/updateDocument")
    public void updateDocument() throws IOException {
        UpdateRequest updateRequest = new UpdateRequest("crw", "2");
        User user = new User("lisi", "22");
        updateRequest.doc(JSONUtil.parseObj(user), XContentType.JSON);
        updateRequest.timeout("1s");
        UpdateResponse update = restHighLevelClient.update(updateRequest, RequestOptions.DEFAULT);
        System.out.println(update);
        System.out.println(update.status());
    }

    /**
     * 删除文档
     * @throws IOException
     */
    @DeleteMapping("delDocument")
    public void delDocument() throws IOException {
        DeleteRequest deleteRequest = new DeleteRequest("crw", "2");
        deleteRequest.timeout("1s");
        DeleteResponse delete = restHighLevelClient.delete(deleteRequest, RequestOptions.DEFAULT);
        System.out.println(delete);
        System.out.println(delete.status());
    }

    /**
     * 批量插入
     * @throws IOException
     */
    @PostMapping("/bulkDocument")
    public void bulkDocument() throws IOException {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("aa", "10"));
        users.add(new User("bb", "11"));
        users.add(new User("cc", "12"));
        BulkRequest bulkRequest = new BulkRequest();
        for (int i = 0; i < users.size(); i++) {
            bulkRequest.add(new IndexRequest("crw").id("" + (i+1)).source(JSONUtil.parseObj(users.get(i)), XContentType.JSON));
        }

        BulkResponse bulk = restHighLevelClient.bulk(bulkRequest, RequestOptions.DEFAULT);
        System.out.println(bulk);
        System.out.println(bulk.status());
        System.out.println(bulk.hasFailures());
    }

    /**
     * 查询
     * @throws IOException
     */
    @GetMapping("/search")
    public void search() throws IOException {
        // 查询请求
        SearchRequest searchRequest = new SearchRequest("crw");
        // 查询构造
         TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("name", "aa");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
         searchSourceBuilder.highlighter();
        // 查询条件
//        QueryBuilder queryBuilder = new TermQueryBuilder("name", "aa");
        searchSourceBuilder.query(termQueryBuilder);
        searchSourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));
        searchRequest.source(searchSourceBuilder);
        SearchResponse search = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        System.out.println(search);

        System.out.println(JSONUtil.parse(search.getHits()));
        System.out.println("---------------------------");
        for (SearchHit hit: search.getHits()) {
            System.out.println(hit.getSourceAsMap());
        }
        System.out.println("---------------------------");
        for (SearchHit hit : search.getHits().getHits()) {
            System.out.println(hit.getSourceAsMap());
        }
    }

    /**
     * 分页 + 搜索 + 高亮业务编写
     * @param keyword
     * @param pageNo
     * @param pageSize
     * @return
     * @throws IOException
     */
    @GetMapping("/searchPage")
    public List<Map<String, Object>> searchPage(String keyword, int pageNo, int pageSize) throws IOException {
        if (pageNo <= 1) {
            pageNo = 1;
        }
        // 查询请求
        SearchRequest searchRequest = new SearchRequest("jd_index");
        // 查询构造
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

        //分页
        searchSourceBuilder.from(pageNo);
        searchSourceBuilder.size(pageSize);

        //精准匹配
        TermQueryBuilder queryBuilder = QueryBuilders.termQuery("title", keyword);
        searchSourceBuilder.query(queryBuilder);

        //高亮
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.field("title");
        highlightBuilder.requireFieldMatch(false); //多处高亮
        highlightBuilder.preTags("<span style= 'color:red'>");
        highlightBuilder.postTags("</span>");
        searchSourceBuilder.highlighter(highlightBuilder);

        // 执行搜索
        searchRequest.source(searchSourceBuilder);
        SearchResponse search = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        System.out.println(search);
        ArrayList<Map<String, Object>> list = new ArrayList<>();
        for (SearchHit hit : search.getHits()) {
            //解析高亮的字段，将原来的字段换为我们高亮的字段即可
            Map<String, HighlightField> highlightFields = hit.getHighlightFields();
            HighlightField title1 = highlightFields.get("title");
            Map<String, Object> sourceAsMap = hit.getSourceAsMap();//原来的结果
            //解析高亮的字段，将原来的字段换为我们高亮的字段即可
            if (title1 != null) {
                Text[] fragments = title1.fragments();
                String n_title = "";
                for (Text text : fragments) {
                    n_title += text;
                }
                sourceAsMap.put("title", n_title);
            }
            list.add(sourceAsMap);
        }
        return list;
    }


}
