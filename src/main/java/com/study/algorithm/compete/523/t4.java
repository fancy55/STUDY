package com.study.algorithm.compete;

import java.util.ArrayList;
import java.util.Scanner;

public class t4 {
    static long[] f = new long[1000004];
    static long[] g = new long[1000004];
    static ArrayList<Integer> t = new ArrayList<>();


    /*能够整除x的数中的中位数*/
    public static void other(){
        for(int i = 1;i*i <= 1000000; i++){
            for(int j = i;i*j <= 1000000; j++){
                f[i*j] = (i+j)/2;
            }
        }
    }
    /*求1~x的中位数之和*/
    public static void sum(){
        for(int i = 3;i <= 1000000; i++) {
            g[i] = g[i - 1] + f[i];
        }
    }

    public static void main(String[] args) {
        f[1] = f[2] = g[1] = 1; g[2] = 2; f[3] = 2;
        Scanner in = new Scanner(System.in);
        other();
        sum();
        int T = in.nextInt();
        for(int i = 0;i < T; i++){
            int n = in.nextInt();
            System.out.println(g[n]%(1000000007));
        }
    }
}
