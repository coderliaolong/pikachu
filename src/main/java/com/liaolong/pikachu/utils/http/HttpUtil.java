package com.liaolong.pikachu.utils.http;

import com.liaolong.pikachu.pojo.User;
import org.apache.http.Consts;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

/**
 * http请求工具类
 *
 * @author LiaoLong
 * @date 2022-02-09 23:13
 */
public class HttpUtil {

    private static final HttpClient CLIENT = HttpClients.createDefault();

    public static void main(String[] args) {
        String url = "https://www.baidu.com";
        try {
            HashMap<String, String> map = new HashMap<>();
            map.put("wd", "java");
            String s = doGet(url, map);
            System.out.println(s);
            User user = doGet(url, response -> new User());
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }

    /**
     * GET 请求, 适合RESTFUL风格的请求URL
     * @param url 请求地址
     * @return json字符串
     */
    public static String doGet(String url) throws IOException{
        return doGet(new HttpGet(url));
    }

    /**
     * GET 请求, 适合RESTFUL风格的请求URL
     * @param url 请求地址
     * @param handler 响应处理器
     * @return bean类对象
     */
    public static <T> T doGet(String url, ResponseHandler<T> handler) throws IOException {
        return doGet(new HttpGet(url), handler);
    }

    /**
     * GET 请求, url后拼接参数
     * @param url 请求地址
     * @param paramMap 参数列表
     * @return json字符串
     */
    public static String doGet(String url, Map<String, String> paramMap) throws IOException, URISyntaxException {
        URIBuilder builder = new URIBuilder(url);
        paramMap.forEach(builder::setParameter);
        return doGet(new HttpGet(builder.build()));
    }

    /**
     * GET 请求, url后拼接参数
     * @param url 请求地址
     * @param paramMap 参数列表
     * @param handler 响应处理器
     * @return 返回bean类对象
     */
    public static <T> T doGet(String url, Map<String, String> paramMap, ResponseHandler<T> handler) throws IOException, URISyntaxException {
        URIBuilder builder = new URIBuilder(url);
        paramMap.forEach(builder::setParameter);
        return doGet(new HttpGet(builder.build()), handler);
    }

    /**
     * GET 请求, url后拼接参数
     * @param url 请求地址
     * @param paramMap 参数列表
     * @param headers 请求头
     * @return json字符串
     */
    public static String doGet(String url, Map<String, String> paramMap, Header[] headers) throws IOException, URISyntaxException {
        URIBuilder builder = new URIBuilder(url);
        paramMap.forEach(builder::setParameter);
        HttpGet httpGet = new HttpGet(builder.build());
        httpGet.setHeaders(headers);
        return doGet(httpGet);
    }

    /**
     * GET 请求, url后拼接参数
     * @param url 请求地址
     * @param paramMap 参数列表
     * @param headers 请求头
     * @param handler 响应处理器
     * @return 返回一个bean类
     */
    public static <T> T doGet(String url, Map<String, String> paramMap, Header[] headers, ResponseHandler<T> handler) throws IOException, URISyntaxException {
        URIBuilder builder = new URIBuilder(url);
        paramMap.forEach(builder::setParameter);
        HttpGet httpGet = new HttpGet(builder.build());
        httpGet.setHeaders(headers);
        return doGet(httpGet, handler);
    }

    /**
     * 返回字符串的GET请求
     * @param httpGet httpGet
     * @return 字符串
     */
    public static String doGet(HttpGet httpGet) throws IOException {
        HttpResponse response = CLIENT.execute(httpGet);
        HttpEntity entity = response.getEntity();
        return EntityUtils.toString(entity, Consts.UTF_8);
    }

    /**
     * 返回指定对象的GET请求
     * @param httpGet httpGet
     * @param handler http响应处理器
     * @return bean类对象
     */
    public static <T> T doGet(HttpGet httpGet, ResponseHandler<T> handler) throws IOException {
        return CLIENT.execute(httpGet, handler);
    }
}
