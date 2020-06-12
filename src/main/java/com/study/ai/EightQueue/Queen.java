package com.study.ai.EightQueue;

/*n皇后问题*/
public class Queen {
    //皇后的个数
    public final static int MAXQUEEN = 8;
    //皇后摆放方法的个数
    public static int num = 0;
    //每一列的皇后在该列中的行号
    public static int[] cols = new int[MAXQUEEN];
    //@param n 当前列号
    public static void getCount(int n) {
        //如果8列都放上了皇后，则实现了一种摆放方法
        if(n==MAXQUEEN) {
            num++;
            System.out.println("第"+num+"种摆放方式：");
            printQueen();
        }
        //m代表的是行号
        for(int m=0; m < MAXQUEEN; m++) {
            //如果是第一列，则皇后摆放无限制，可以从0行到最后一行随便放
            if(n==0) {
                cols[n] = m;
                getCount(n+1);
            } else {
                int i = 0;
                //遍历之前所有摆放皇后的位置
                for(; i<n; i++) {
                    //如果当前行号与前面摆放皇后的行号差值为0则在同一行不能摆放，
                    //差值与列的差值相等则在对角线上不能摆放
                    int d = Math.abs(m - cols[i]);
                    if(d==0 || d==n-i) {
                        break;
                    }
                }
                //如果i与n相等代表当前的m行可以放皇后，不与前面的皇后位置冲突
                if(i==n) {
                    cols[n] = m;
                    getCount(n+1);
                }
            }
        }
    }

    /**打印皇后位置，0表示皇后*/
    private static void printQueen() {
        for(int i=0; i<MAXQUEEN; i++) {
            for(int j=0; j<MAXQUEEN; j++) {
                if(cols[j] == i) {
                    System.out.print("0 ");
                } else {
                    System.out.print("+ ");
                }
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        getCount(0);
    }
}