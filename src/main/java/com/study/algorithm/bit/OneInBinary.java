package com.study.algorithm.bit;

/*输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。*/


public class OneInBinary {

    /**
    * 把一个整数减去1，再和原整数做与运算，会把该整数最右边一个1变成0
    * 那么一个整数的二进制有多少个1，就可以进行多少次这样的操作
    */
    //循环次数只与1的个数有关
    public static int NumberOf1(int n) {
        int cnt = 0;
        while(n!=0){
            cnt++;
            n &= (n-1);//抹掉最右边的1  n-=n&(~n+1) //n&(~n+1) 得到最右侧1
        }
        return cnt;
    }

    /**
     * 整数n每次无符号右移一位,检查最右边的bit是否为1来统一
     */
    //在最复杂的情况下要经过23次循环
    public static int Number1(int n){
        int ans = 0;
        while(n!=0){
            ans += n&1;
            n >>>= 1;//无符号右移
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(NumberOf1(-15));
        System.out.println(Number1(16));
    }
}
