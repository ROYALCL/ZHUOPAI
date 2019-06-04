package com.example.myapplication.services;

import com.example.myapplication.data.ServerUrl;
import com.example.myapplication.servicesImpl.UtilsServiceImpl;

import java.io.IOException;
import java.util.logging.Logger;

import okhttp3.Call;
import okhttp3.Cookie;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class UtilsService implements UtilsServiceImpl {
    Logger logger = Logger.getLogger(this.getClass().toString());
    ServerUrl serverUrl = new ServerUrl();

    @Override
    public Cookie login(String username, String password) {
        logger.info("调用login函数，传入参数为：" + username + "," + password);
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url(serverUrl.getUrl() + "auth").build();
        Call call = okHttpClient.newCall(request);
        try {
            Response response = call.execute();
            System.out.println(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
