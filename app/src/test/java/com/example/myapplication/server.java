package com.example.myapplication;

import org.junit.Test;
import org.junit.runners.JUnit4;
import org.junit.runners.model.InitializationError;

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
    OkHttpClient okHttpClient =new OkHttpClient();
    String url="http://221.7.85.2:7001/";

    @Test
    public void print(){
        System.out.println(url);
    }


    @Test
    public void testauth() throws IOException {
        System.out.println(run(url+"auth"));
    }

    String run(String url) throws IOException {
        Request request = new Request.Builder().url(url).build();
        try (Response response = okHttpClient.newCall(request).execute()) {
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
            return "NULL";
        }
    }

    @Test
    public void testlogin(){
        //1.创建OkHttpClient对象
        //2.通过new FormBody()调用build方法,创建一个RequestBody,可以用add添加键值对
        RequestBody requestBody = new FormBody.Builder().add("username","zhangqilu").add("password","25").build();
        //3.创建Request对象，设置URL地址，将RequestBody作为post方法的参数传入
        Request request = new Request.Builder().url(url+"login").post(requestBody).build();
        //4.创建一个call对象,参数就是Request请求对象
        Call call = okHttpClient.newCall(request);
        //5.请求加入调度,重写回调方法
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Headers headers = response.headers();
                for (int i = 0; i < headers.size(); i++) {
                   System.out.println(headers.name(i) + ":" + headers.value(i));
                }
                System.out.println( "onResponse: " + response.body().string());
            }
        });
    }


}
