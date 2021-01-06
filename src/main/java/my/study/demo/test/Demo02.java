package my.study.demo.test;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import java.util.HashMap;
import java.util.Map;

public class Demo02 {
    public static void main(String[] args) {
        String host = "https://jisuwnl.market.alicloudapi.com";
        String path = "/calendar/holiday";
        String method = "GET";
        String appcode = "31facc1f9cf94179b9d196e59c1736b2";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        Map<String, String> querys = new HashMap<String, String>();


        try {
            /**
             * 重要提示如下:
             * HttpUtils请从
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
             * 下载
             *
             * 相应的依赖请参照
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
             */
            HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
            System.out.println(response.toString());
            System.out.println(response.getEntity());
            //获取response的body
            System.out.println(EntityUtils.toString(response.getEntity(),"utf-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
