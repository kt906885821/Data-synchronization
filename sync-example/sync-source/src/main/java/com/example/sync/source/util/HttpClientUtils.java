package com.example.sync.source.util;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @author yuming
 * @date 2019/1/20
 */
public class HttpClientUtils {

    /**
     * 发送数据
     *
     * @param url url
     * @return
     */
    public static String send(String url, String json) {
        CloseableHttpClient client = HttpClientPool.getClient();
        HttpPost httpPost = new HttpPost(url);
        StringEntity stringEntity = new StringEntity(json, ContentType.APPLICATION_JSON);
        stringEntity.setContentEncoding("utf-8");
        httpPost.setEntity(stringEntity);
        httpPost.setConfig(getConfig());
        CloseableHttpResponse response = null;
        try {
            response = client.execute(httpPost);
            int success = 200;
            if (response.getStatusLine().getStatusCode() == success) {
                HttpEntity entity = response.getEntity();
                String result = "";
                if (entity != null) {
                    result = EntityUtils.toString(entity, "utf-8");
                }
                return result;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            release(response);
        }

        return null;
    }

    /**
     * 设置连接参数
     *
     * @return config
     */
    private static RequestConfig getConfig() {
        // 配置连接参数
        return RequestConfig.custom()
                .setConnectTimeout(1000)
                .setConnectionRequestTimeout(1000)
                .setSocketTimeout(1000 * 10)
                .build();
    }

    /**
     * 释放资源
     *
     * @param response response
     */
    private static void release(CloseableHttpResponse response) {
        if (response != null) {
            try {
                response.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
