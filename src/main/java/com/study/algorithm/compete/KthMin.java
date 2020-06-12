package com.study.algorithm.compete;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class KthMin {
    static int a[];
    public static void quickSort(int s, int e, int k){
        if(s > e)return ;
        int tmp = a[s];
        int i = s, j = e;
        while(i<j){
            while(a[j] >= tmp && i < j)j--;
            while(a[s] <= tmp && i < j)i++;
            if(i < j) {
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }
        a[s] = a[i];
        a[i] = tmp;
        quickSort(s, i-1, k);
        quickSort(i+1, e, k);
    }

    public static void main(String[] args) throws IOException {
//        Scanner in = new Scanner(System.in);
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int T = Integer.parseInt(br.readLine());//int T = in.nextInt();
//        for(int i = 0;i < T; i++){
//            String[] s = br.readLine().split(" ");
//            int n = Integer.parseInt(s[0]);//in.nextInt();
//            int k = Integer.parseInt(s[1]);//in.nextInt();
//            String[] data = br.readLine().split(" ");
//            a = new int[n];
//            for(int j = 0;j < n; j++)
//                a[j] = Integer.parseInt(data[j]);
////            for(int j = 0;j < n; j++)
////                a[j] = in.nextInt();
//            quickSort(0, a.length-1, k);
//            System.out.println(a[k-1]);
//        }
        System.out.println(Math.log(2));
    }
}
