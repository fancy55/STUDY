package com.study.algorithm.compete;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


//err超时
public class T4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        long s = System.currentTimeMillis();
        while (str != null){
            long n = Long.parseLong(str);
            long flag = 0;
            for(long i = 10; i <= 2999999999l; i++){
                if(bitMul(i) == n){
                    flag = i;
                    break;
                }
            }
            if(flag != 0) System.out.println(flag);
            else System.out.println(-1);
            System.out.println(System.currentTimeMillis()-s);
            str = br.readLine();
        }
    }
    //数位乘积
    public static long bitMul(long ans){
        long res = 1;
        while(ans!=0){
            res *= ans%10;
            ans/=10;
        }
        return res;
    }
}
