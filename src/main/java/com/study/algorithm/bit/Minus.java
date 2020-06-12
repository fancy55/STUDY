package com.study.algorithm.bit;

/*减法: a-b = a+(-b)*/
public class Minus {
    public static int minusBit(int a, int b){
        b = ~b + 1; //取反+1
        int sum = a;
        while(b != 0){
            sum = a ^ b;
            b = (a&b)<<1;
            a = sum;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(minusBit(9,10));
    }
}
