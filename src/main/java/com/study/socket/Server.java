package com.study.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        System.out.println("服务器启动！！！！");
        try {
            //创建服务器,并开放10000端口
            ServerSocket server = new ServerSocket(10000);
            while(true){
                //从连接队列中取出一个连接，如果没有则等待
                Socket socket = server.accept();
                //启动线程
                new Thread(new ToClientDialog(socket)).start();
                System.out.println("客户端连接成功       地址：  "+socket.getInetAddress()+"   端口：:"+socket.getPort());//½ÓÊÕºÍ·¢ËÍÊý¾Ý

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
