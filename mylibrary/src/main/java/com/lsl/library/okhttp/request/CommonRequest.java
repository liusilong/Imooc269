package com.lsl.library.okhttp.request;

import java.util.Map;

import okhttp3.FormBody;
import okhttp3.Request;

/**
 * Created by liusilong on 2017/8/19.
 * 接受请求参数，为我们生成Request对象
 */

public class CommonRequest {
    /**
     * 创建一个Post请求
     *
     * @param url    请求连接
     * @param params 请求参数
     * @return 返回一个创建好的Request对象
     */
    public static Request createPostRequest(String url, RequestParams params) {
        FormBody.Builder mFormBuild = new FormBody.Builder();
        if (params != null) {
            for (Map.Entry<String, String> entry : params.urlParams.entrySet()) {
//                将请求参数添加到构建类中
                mFormBuild.add(entry.getKey(), entry.getValue());
            }
        }
//        通过请求构建类的build方法获取真正的请求体对象
        FormBody mFormBody = mFormBuild.build();
//        返回Request对象
        return new Request.Builder().url(url).post(mFormBody).build();
    }


    /**
     * 创建一个Get请求
     *
     * @param url    请求连接
     * @param params 请求参数
     * @return
     */
    public static Request createGetRequest(String url, RequestParams params) {
        StringBuilder urlBuilder = new StringBuilder(url).append("?");
        if (params != null) {
            for (Map.Entry<String, String> entry : params.urlParams.entrySet()) {
//                拼接get请求参数
                urlBuilder.append(entry.getKey())
                        .append("=")
                        .append(entry.getValue())
                        .append("&");
            }

        }

        return new Request.Builder().url(urlBuilder.substring(0, urlBuilder.length() - 1)).get().build();
    }
}
