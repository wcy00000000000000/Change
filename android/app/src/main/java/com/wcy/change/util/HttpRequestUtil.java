package com.wcy.change.util;

import android.content.SharedPreferences;
import android.util.Log;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by WCY on 2019/5/6
 */
public class HttpRequestUtil {
    public static String baseUrl = "http://8z9zma.natappfree.cc";
    private OkHttpClient client;//所有请求都由同一个client进行，减少资源消耗

    private HttpRequestUtil() {
        client = new OkHttpClient();
    }

    private static HttpRequestUtil httpUtil = null;
    public static HttpRequestUtil getInstance() {
        if (httpUtil == null) {
            httpUtil = new HttpRequestUtil();
        }
        return httpUtil;
    }

    public void sendRequestWithCallback(final String method, final String address, final RequestBody body, final HttpCallbackListener listener
    ) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Request.Builder builder = new Request.Builder()
                        .url(address);

                switch (method) {
                    case "POST":
                        builder.post(body);
                        break;
                    case "PUT":
                        builder.put(body);
                        break;
                    case "DELETE":
                        builder.delete(body);
                        break;
                    default:
                        builder.get();
                        break;
                }

                Request request = builder.build();
                try {
                    //实际进行请求的代码
                    Log.i("url = ", address);
                    Response response = client.newCall(request).execute();

                    String result = response.body().string();
                    if (result != null && listener != null) {
                        //当response的code大于200，小于300时，视作请求成功
                        if (response.isSuccessful()) {
                            listener.onFinish(result);
                        } else {
                            listener.onError(new IOException(result));
                        }
                    }

                } catch (IOException e) {
                    if (listener != null) {
                        listener.onError(e);
                    }
                }
            }
        }).start();

    }

    public void post(final String address, RequestBody body, final HttpCallbackListener listener) {
        sendRequestWithCallback("POST", address, body, listener);
    }

    public void get(String address, HttpCallbackListener listener) {
        sendRequestWithCallback("GET", address, null, listener);
    }

    public void delete(String address, RequestBody body, HttpCallbackListener listener) {
        sendRequestWithCallback("DELETE", address, body, listener);
    }

    public void put(String address, RequestBody body, HttpCallbackListener listener) {
        sendRequestWithCallback("PUT", address, body, listener);
    }
}
