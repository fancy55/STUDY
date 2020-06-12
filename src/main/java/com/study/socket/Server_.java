package com.study.socket;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server_ {
    public static void main(String[] args) throws IOException {
        //1、先设一个地址
        ServerSocket socket = null;
        //2、等待客户端连接
        Socket accept = null;
        //3、读取客户端消息
        InputStream is = null;

            /*
            byte[] buff = new byte[1024];
            int len;
            while(len=is.read(buff) != -1){
                String msg = new String(buff,0,len);

            }
             */
        //4、管道流
        ByteArrayOutputStream os=null;
        try {
            socket = new ServerSocket(1025);
            accept = socket.accept();
            is = accept.getInputStream();
            os = new ByteArrayOutputStream();
            byte[] buff = new byte[1024];
            int len;
            while((len=is.read(buff)) != -1){
                os.write(buff,0,len);
            }
            System.out.println("客户端====="+os.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            os.close();
            is.close();
            socket.close();
            accept.close();
        }

    }
}
