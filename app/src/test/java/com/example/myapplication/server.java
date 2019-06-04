package com.example.myapplication;

import com.example.myapplication.services.UtilsService;

import org.junit.Test;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class server{
    String url="http://221.7.85.2:7001/";


    @Test
    public void testlogin(){
        //1.创建OkHttpClient对象
        OkHttpClient okHttpClient = new OkHttpClient();
        //2.通过new FormBody()调用build方法,创建一个RequestBody,可以用add添加键值对
        RequestBody requestBody = new FormBody.Builder().add("username", "DQE").add("password", "123456").build();
        //3.创建Request对象，设置URL地址，将RequestBody作为post方法的参数传入
        Request request = new Request.Builder().url("http://221.7.85.2:7001/auth").post(requestBody).build();
        //4.创建一个call对象,参数就是Request请求对象
        Call call = okHttpClient.newCall(request);
        //5.请求加入调度,重写回调方法
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&");

        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Headers headers = response.headers();
                System.out.println(headers.toString());
                System.out.println(response.body().string());
            }
        });
        System.out.println("######################");
    }


    @Test
    public void testf() {
        OkHttpClient okHttpClient = new OkHttpClient();
        RequestBody requestBody = new FormBody.Builder().add("username", "DQE").add("password", "123456").build();
        Request request = new Request.Builder().url("http://221.7.85.2:7001/auth").post(requestBody).build();
        Call call = okHttpClient.newCall(request);
        try {
            Response response = call.execute();
            System.out.println(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("######################");
    }

    @Test
    public void testff() {
        UtilsService utils = new UtilsService();
        utils.login("DQE", "123456");
    }
}
