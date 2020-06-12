package com.study.algorithm.compete;

import java.util.Arrays;
import java.util.Scanner;

public class T1 {
    static int[] a;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        a = new int[n];
        for(int i = 0;i < n; i++) {
            a[i] = in.nextInt();
        }
        int flag = 0;
        for(int i = 0;i < n; i++){
            if(a[flag] < a[i]){
                flag = i;
            }
        }
        System.out.println(a[flag]+","+a[n-1]);
        System.out.println(a[n-1] - (a[flag]-m*flag));
    }
}
