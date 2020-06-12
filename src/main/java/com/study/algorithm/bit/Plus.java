package com.study.algorithm.bit;

/*位运算实现加法*/

/**
 * 不考虑进位: t1 = a^b
 * 只算进位:   t2 = (a&b)<<1
 * 正确结果:   t  = t1 + t2
 * 一直重复这样的过程,直至进位产生的值完全消失,说明所有的过程都加完了
 */
public class Plus {
    public static int addBit(int a, int b){
        int sum = a;
         while(b != 0){
             sum = a ^ b;
             b = (a&b)<<1;
             a = sum;
         }
         return sum;
    }

    public static void main(String[] args) {
        System.out.println(addBit(9,10));
    }
}
