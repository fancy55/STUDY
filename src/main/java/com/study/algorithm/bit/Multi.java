package com.study.algorithm.bit;

import static com.study.algorithm.bit.Plus.addBit;

/*乘法*/
public class Multi {
    public static int multiBit(int a, int b){
        int ans = 0;
        while(b != 0){
            if((b&1) != 0)ans = addBit(ans, a);
            a <<= 1;
            b >>>= 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(multiBit(4, 6));
    }
}
