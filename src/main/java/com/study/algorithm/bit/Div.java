package com.study.algorithm.bit;

import static com.study.algorithm.bit.Minus.minusBit;
import static com.study.algorithm.bit.Multi.multiBit;
import static com.study.algorithm.bit.Plus.addBit;

/*除法: 乘法的逆运算*/
public class Div {
    public static int divBit(int a, int b) {
        if (b == 0) throw new RuntimeException("divisor is 0");
        if (a == b) return 1;
        if (b == Integer.MIN_VALUE) return 0;
        if (a == Integer.MIN_VALUE){
            int res = div(addBit(a,1), b);
            System.out.println("res:::"+res);
            return addBit(res, div(minusBit(a, multiBit(res, b)), b));
        }
        return div(a, b);
    }

    public static int div(int a, int b) {
        int x = a, y = b;
        if(a < 0)a = ~a+1;
        if(b < 0)b = ~b+1;
        int ans = 0;
        for(int i = 31; i >= 0; i--){
            if((a>>i) >= b){
                ans |= (1<<i);
                a = minusBit(a, b<<i);
            }
        }
        return isNeg(x)^isNeg(y)?(~ans+1):ans;
    }


    public static boolean isNeg(int x){
        return x<0;
    }

    public static void main(String[] args) {
        System.out.println(divBit(Integer.MIN_VALUE, 1));
        System.out.println(divBit(Integer.MIN_VALUE, 2));
        System.out.println(divBit(Integer.MIN_VALUE, 3));
        System.out.println(divBit(Integer.MIN_VALUE, 7));
        System.out.println(divBit(Integer.MIN_VALUE, 21));
        System.out.println(divBit(22, 2));
    }
}
