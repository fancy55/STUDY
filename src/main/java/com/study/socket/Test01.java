package com.study.socket;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**信件、快递
 * 打电话：TCP用户传输协议【可靠连接（三次握手四次分手）、稳定、传输完成释放连接】
 * 短信：UDP用户数据报协议【不可靠连接、不稳定、不管有没有准备好都可以发给你（DDOS洪水攻击、饱和攻击），】
 * 地球村
 * 计算机网络：是指将地理位置不同的具有独立功能的多台计算机及外部设备，通过通信线路连接起来。
 *              在操作系统、网络管理软件、网络通信协议的管理和协调上，实现资源共享和信息传递的计算机系统。
 * 通信协议：HTTP【超文本传输协议】、TCP、UDP、SMTP【邮件】、FTP【文件上传】、Telnet远程登录、DNS域名解析、IP、ICMP、ARP、RARP
 * osi七层模型、TCP/IP四层【应用层（qq\微信）、传输层（通信）、网络层（分包）、数据链路层(光纤、电缆、卫星传输、无线网)】
 * 网络编程的目的：数据交换、通信【否则单机
 * 需要什么：
 *          1、如何准确定位到网络上的一台主机【ip:端口【vpc服务
 *          2、定位到计算机上某个资源【应用
 *          3、如何传输数据
 *  javaweb：网页编程 BS         java->万物皆对象
 *  网络编程（套接字编程）：TCP/IP  CS
 *  人工智能（智能汽车【工厂、人少【伦理问题】】）
 *  网络通信的要素：ip【局域网192.168.1.1】+端口号、规则【协议】
 *
 *  ip:
 *      ipv4：四个字节 42亿公网（互联网）【30亿都在北美，亚洲只有4亿，2011年用尽】、私网（局域网192.168.xx.xx专门给组织内部使用的）、ABCD类地址
 *      ipv6：fe80::d422:dfa1:66fa:fd72%18  128位，8个无符号整数
 *  端口表示是计算机上的一个程序的进程
 *      不同进程有不同端口号，用来区分软件
 *      0~65535
 *      UDP,TCP：65535*2 tcp:80,udp:80     不同协议同一端口不冲突
 *      分类：
 *          共有：0~1023
 *              HTTP:80
 *              HTTPS:443
 *              FTP:21
 *              Telent:23
 *          程序注册端口：1024~49151，分配用户或程序
 *              Tomcat:8080
 *              MySQl:3306
 *              Oracle:1521
 *           动态、私有：49152~65535
 *              netstat -ano【查看所有端口】
 *              netstat -aon|findstr "5900"【查看指定端口】【|管道过滤，先执行后面，再执行前面】
 *              tasklist|findstr "8696" 【查看指定端口进程】
 *              ctrl+shift+esc
 *    tcp:用户传输协议
 *    ip：网际互连协议
 */
public class Test01 {

    public void host() throws UnknownHostException{
        //查询本机地址
        InetAddress addr1 = InetAddress.getByName("127.0.0.1");
        InetAddress addr2 = InetAddress.getByName("localhost");
        InetAddress addr3 = InetAddress.getLocalHost();
    }

    public static void main(String[] args)  {

    }
}
