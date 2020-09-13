package com.shop.web.utils;

import com.alibaba.fastjson.JSON;
import org.apache.commons.collections.MapUtils;
import org.apache.http.*;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * http 请求工具类
 *
 * @Author: hzzhouwen
 * @Date: 2018/2/2 15:23
 */
public class HttpUtil {

    private static final Logger logger = LoggerFactory.getLogger(HttpUtil.class);

    private static String charset = "UTF-8";

    /**
     * @param url
     * @param pairs
     * @param mediaType
     * @return
     */
    public static String postMethod(String url, List<NameValuePair> pairs, String mediaType) throws IOException {
        HttpClient httpClient = HttpClients.createDefault();
        HttpPost post = new HttpPost(url);
        UrlEncodedFormEntity se = new UrlEncodedFormEntity(pairs, charset);
        se.setContentType(mediaType);
        post.setEntity(se);
        HttpResponse response = httpClient.execute(post, HttpClientContext.create());
        StatusLine sl = response.getStatusLine();
        HttpEntity entity = response.getEntity();
        String ret = EntityUtils.toString(entity, charset);
        if (HttpStatus.SC_OK == sl.getStatusCode()) {
            return ret;
        } else {
            logger.error("reqesut url failed. url {}, return code {}, content {}", url, sl.getStatusCode(), ret);
        }
        return null;
    }

    /**
     * 发送get请求获取数据
     *
     * @param url
     * @param header
     * @param charsetName
     * @return
     */
    public static String sendGetRequest(String url, Map<String, String> header, String charsetName) {
        String result = null;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        if (null == url || url.length() <= 0)
            throw new RuntimeException("url can not be null.");
        HttpGet httpGet = new HttpGet(url);
        if (MapUtils.isNotEmpty(header)) {
            header.forEach(httpGet::setHeader);
        }
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpGet);
            if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
                logger.error("http status is not 200. code:{}", response.getStatusLine().getStatusCode());
                throw new RuntimeException("http status is not 200. code:" + response.getStatusLine().getStatusCode());
            }
            HttpEntity httpEntity = response.getEntity();
            if (null == httpEntity) {
                logger.error("http response entity is null.");
                throw new RuntimeException("http response entity is null");
            }
            result = new BufferedReader(new InputStreamReader(httpEntity.getContent(), charsetName)).lines().collect(Collectors.joining());
        } catch (Exception e) {
            logger.error(String.format("execute get request error. url:%s", url), e);
        } finally {
            try {
                if (null != response) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 发送post请求获取数据
     *
     * @param url
     * @param param
     * @param header
     * @param charsetName
     * @return
     */
    public static String sendPostRequest(String url, Map<String, String> param, Map<String, String> header, String charsetName) {
        String result = null;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        if (null == url || url.length() <= 0)
            throw new RuntimeException("url can not be null.");
        HttpPost httpPost = new HttpPost(url);
        if (MapUtils.isNotEmpty(header)) {
            header.forEach(httpPost::addHeader);
        }
        List<NameValuePair> nameValuePairs = new ArrayList<>();
        if (MapUtils.isNotEmpty(param)) {
            param.forEach((key, value) -> nameValuePairs.add(new BasicNameValuePair(key, value)));
        }
        CloseableHttpResponse response = null;

        try {
            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs, Charset.forName("UTF-8")));
            response = httpClient.execute(httpPost);

            if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
                logger.error("http status is not 200. code:{}", response.getStatusLine().getStatusCode());
                throw new RuntimeException("http status is not 200. code:" + response.getStatusLine().getStatusCode());
            }

            HttpEntity httpEntity = response.getEntity();
            if (null == httpEntity) {
                logger.error("http response entity is null.");
                throw new RuntimeException("http response entity is null");
            }
            result = new BufferedReader(new InputStreamReader(httpEntity.getContent(), charsetName)).lines().collect(Collectors.joining());
        } catch (Exception e) {
            logger.error(String.format("execute post request error. url:%s", url), e);
        } finally {
            try {
                if (null != response) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 发送post请求获取数据
     *
     * @param url
     * @param header
     * @param charsetName
     * @return
     */
    public static String sendPostRequest(String url, Map<String, String> header, String charsetName) {
        String result = null;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        if (null == url || url.length() <= 0)
            throw new RuntimeException("url can not be null.");
        HttpPost httpPost = new HttpPost(url);
        if (MapUtils.isNotEmpty(header)) {
            header.forEach(httpPost::addHeader);
        }
        CloseableHttpResponse response = null;

        try {
            response = httpClient.execute(httpPost);

            if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
                logger.error("http status is not 200. code:{}", response.getStatusLine().getStatusCode());
                throw new RuntimeException("http status is not 200. code:" + response.getStatusLine().getStatusCode());
            }

            HttpEntity httpEntity = response.getEntity();
            if (null == httpEntity) {
                logger.error("http response entity is null.");
                throw new RuntimeException("http response entity is null");
            }
            result = new BufferedReader(new InputStreamReader(httpEntity.getContent(), charsetName)).lines().collect(Collectors.joining());
        } catch (Exception e) {
            logger.error(String.format("execute post request error. url:%s", url), e);
        } finally {
            try {
                if (null != response) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 发送post请求获取数据,参数通过json传输
     *
     * @param url
     * @param param
     * @param header
     * @param charsetName
     * @return
     */
    public static String sendPostRequestByJson(String url, Map<String, Object> param, Map<String, String> header, String charsetName) {
        String result = null;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        if (null == url || url.length() <= 0)
            throw new RuntimeException("url can not be null.");
        HttpPost httpPost = new HttpPost(url);
        if (MapUtils.isNotEmpty(header)) {
            header.forEach(httpPost::addHeader);
        }
        CloseableHttpResponse response = null;

        try {
            httpPost.addHeader("Content-Type", "application/json");
            httpPost.setEntity(new StringEntity(JSON.toJSONString(param), charsetName));
            response = httpClient.execute(httpPost);

            if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
                logger.error("http status is not 200. code:{}", response.getStatusLine().getStatusCode());
                throw new RuntimeException("http status is not 200. code:" + response.getStatusLine().getStatusCode());
            }

            HttpEntity httpEntity = response.getEntity();
            if (null == httpEntity) {
                logger.error("http response entity is null.");
                throw new RuntimeException("http response entity is null");
            }
            result = new BufferedReader(new InputStreamReader(httpEntity.getContent(), charsetName)).lines().collect(Collectors.joining());
        } catch (Exception e) {
            logger.error(String.format("execute post request error. url:%s", url), e);
        } finally {
            try {
                if (null != response) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
