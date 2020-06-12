package com.study.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client_ {
    public static void main(String[] args) throws IOException {
        while(true) {
            //1、知道服务器的地址
            InetAddress addr = null;
            int port = 1025;
            //2、创建一个socket连接
            Socket socket = null;
            //3、发送消息
            OutputStream os = null;
            Scanner in = new Scanner(System.in);

            InputStream is = null;
            try {
                addr = InetAddress.getByName("127.0.0.1");
                socket = new Socket(addr, port);
                os = socket.getOutputStream();

//                is = socket.getInputStream();
//                byte[] buff = new byte[1024];
//                int len;
//                while ((len = is.read(buff)) != -1) {
//                    os.write(buff, 0, len);
//                }
                System.out.print("客户端：");
                String msg_send = in.next();
                os.write(msg_send.getBytes());

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                os.close();
                socket.close();
            }
        }
    }
}
