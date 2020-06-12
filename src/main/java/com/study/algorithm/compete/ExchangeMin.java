package com.study.algorithm.compete;

import java.util.Scanner;
import java.util.Vector;

public class ExchangeMin {
    static int[] a;
    static int n;
    public static void sort(){
        n = 0;
        for(int i = 0;i < a.length; i++){
            for(int j = i+1;j < a.length; j++){
                if(a[j] < a[i]){
                    int t = a[i];
                    a[i] = a[j];
                    a[j] = t;
                    n++;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cnt= in.nextInt();
        a = new int[cnt];
        for(int i = 0;i < cnt; i++)
            a[i] = in.nextInt();
        sort();
        System.out.println(n);
    }
}
