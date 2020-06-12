package com.study.algorithm.base;

public class Fibonacci {
    public static int fac(int n){
        if(n<=2)return n;
        int ans = 0, pr1 = 1, pr2 = 2;
        n -= 2;
        while((n--)>0){
            ans = pr1 + pr2;
            pr1 = pr2;
            pr2 = ans;
        }
        return ans;
    }

    public static void main(String[] args) {
        //1、
        int n = 3;
        System.out.println(fac(n));
        //2、
//        System.out.println(FrogStep.fac(n));
    }
}

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */
//递归远比循环占用更多的资源
class FrogStep{
    public static int fac(int n){
        if(n <= 2)return n;
        return fac(n-1)+fac(n-2);
    }
}

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
//基础知识：数列求和
class FrogStep1{
    public static int fac(int n){
        if(n <= 2)return n;
        return fac(n-1)*2;
    }
}