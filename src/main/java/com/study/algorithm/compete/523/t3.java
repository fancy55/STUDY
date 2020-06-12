package com.study.algorithm.compete;

import java.util.Scanner;

public class t3 {
    static int[] a;
    static int n, m, k, m1;
    public static void compete(){
        int res = 0;
        for(int i = 0;i < n; i++){
            int t = a[i];
            while(t >= m){
                t-=m;
                m = m1;
                res++;
            }
            if(t==0)continue;
            if(t < m){ //当前体力能拿所有剩余被子
                if(i == n-1){
                    res++;
                    System.out.println(res);
                    return;
                }
                m-=t;
                if(m > k){ //当前体力还能上一层楼
                    m -= k;
                    continue;
                }
                else if(m <= 0 || m <= k){//体力耗尽或当前体力<=k
                    m = m1;
                    res++;
                }
            }
        }
        System.out.println(res);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int q = 0;q < T; q++) {
            n = in.nextInt();
            m = in.nextInt();
            k = in.nextInt();
            m1 = m;
            a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = in.nextInt();
            compete();
        }
    }
}
