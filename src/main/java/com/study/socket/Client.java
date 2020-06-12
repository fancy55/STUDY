package com.study.socket;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public static void main(String[] args) throws IOException {
        System.out.println("客户端启动!!!");
        Socket socket;
        try {
            //连接主机地址。
            socket = new Socket("127.0.0.1", 10000); //10.161.10.246自己电脑的主机地址
            //启动
            new Thread(new ToServiceDialog(socket)).start();

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
