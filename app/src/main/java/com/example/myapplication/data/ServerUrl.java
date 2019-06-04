package com.example.myapplication.data;

public class ServerUrl {
    private String IP = "221.7.85.2";
    private String Port = "7001";

    public String getIP() {
        return IP;
    }

    public String getPort() {
        return Port;
    }

    public String getUrl() {
        return "http://" + getIP() + ":" + getPort() + "/";
    }

}
