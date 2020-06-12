package com.study.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

//动态代理实际上是JDK在运行期动态创建class字节码并加载的过程
//利用反射机制在运行时创建代理类
public class DynamicProxy {
    public static void main(String[] args) {
        //这种没有实现类但是在运行期动态创建了一个接口对象的方式，我们称为动态代码。
        // JDK提供的动态创建接口对象的方式，就叫动态代理

        //1、定义一个InvocationHandler实例，它负责实现接口的方法调用
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(method);
                if(method.getName().equals("Day")){
                    System.out.println("Day:"+args[0]);
                }
                return null;
            }
        };

        //2、创建接口实例
        Data date = (Data) Proxy.newProxyInstance(
                Data.class.getClassLoader(),
                new Class[]{Data.class},
                handler
        );
        date.Day("Thursday");
    }


}


interface Data{
    void Day(String day);;
}