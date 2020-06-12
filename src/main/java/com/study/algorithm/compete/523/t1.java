package com.study.algorithm.compete;

import java.util.Scanner;

/*链接：https://ac.nowcoder.com/acm/contest/5678/D
来源：牛客网

有一个 n 个数的数组，代表 n 栋建筑，有如下两种操作：
1. 修改：区间 l 到 r 内的建筑增高 k（正整数）
2. 查询：对于某个位置 x，求 y 的数目（ y \gt xy>x ，且对于位置 y ，位置 x 到位置 y 的这段区间的最小值是位置 y 的值）
*/
//err
public class t1 {
    static int[] a;
    static String[] t;
    public static void print(Scanner in,int m){
        while(m > 0){
            char ch = in.next().charAt(0);
            int l=0,r=0,k=0,x=0;
            if(ch == 'c'){
                l=in.nextInt();
                r=in.nextInt();
                k=in.nextInt();
                for(int i = l-1;i < r; i++){
                    a[i] += k;
                }
            }else if(ch == 'q'){
                x=in.nextInt();
                int t = 0;
                int flag = a[x-1];
                for(int i = x;i < a.length; i++){
                    if(a[i] <= flag){
                        flag=a[i];
                        t++;
                    }
                }
                System.out.println(t);
            }
            m--;
        }
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        a = new int[n];
        for(int i = 0;i < n; i++){
            a[i] = in.nextInt();
        }
        print(in, m);
    }
}
