package com.study.jvm;

//import org.openjdk.jol.info.ClassLayout;

/**
 * JOL： java Object Layout
 * java：一般是64bit(8字节 )
 * 对象头object header：
 *      1）普通对象
 *              markword(关于锁的信息记录在这里、8)、
 *              class pointer(压缩前是8，压缩后是4)、
 *              instance data(实例数据)、
 *              padding对齐（保证是8的倍数,cpu读起来会更快，提高效率）
 *      2）数组
 *              markword(关于锁的信息记录在这里、8)、
 *              class pointer(压缩前是8，压缩后是4)、
 *              length(数组长度4字节）、
 *              instance data(实例数据)、
 *              padding对齐（保证是8的倍数,cpu读起来会更快，提高效率）
 */
public class ObjectLayout {

    public static void main(String[] args) {
//        User user = new User();//在内存中占了多少字节？    24
//        System.out.println(ClassLayout.parseInstance(user).toPrintable());
//        synchronized (user){ //锁住门、synchronized在对象的markword中
//            System.out.println(ClassLayout.parseInstance(user).toPrintable());
//        }
    }
}

class User{
    Integer no;
    String name;
}
