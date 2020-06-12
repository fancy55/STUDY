package com.study.algorithm.compete;

import java.util.Scanner;

public class T3 {
    static int[][] t = new int[10][10];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int m = 0;m < n; m++){
            int flag = 0;
            int id = in.nextInt();
            int x = in.nextInt()-1;
            for(int i = 0;i < 10; i++){
                for(int j = 0;j < 10; j++){
                    if(id==1){
                      if(t[j][x] == 1||t[j][x+1] == 1){//ok
                             t[j-1][x] = t[j-1][x+1] = t[j-2][x] = t[j-2][x+1] = 1;
                            flag = 1;
                        }
                        else if(j == 9){
                            t[9][x] = t[9][x+1] = t[8][x] = t[8][x+1] = 1;
                            flag = 1;
                        }
                    }else if(id==2){ //ok
                        if(t[j][x] == 1||t[j][x+1] == 1||t[j][x+2] == 1){
                            t[j-1][x] = t[j-1][x+1] = t[j-1][x+2] = t[j-2][x] = 1;
                            flag = 1;
                        }else if(j == 9){
                            t[9][x] = t[9][x+1] = t[9][x+2] = t[8][x] = 1;
                            flag = 1;
                        }
                    }else if(id==3){
                        if(t[j][x] == 1||t[j][x+1] == 1||t[j][x+2] == 1|| t[j][x+3] == 1){
                            t[j-1][x] = t[j-1][x+1] = t[j-1][x+2] = t[j-1][x+3] = 1;
                            flag = 1;
                        }else if(j == 9) {
                            t[9][x] = t[9][x+1] = t[9][x+2] = t[9][x+3] = 1;
                            flag = 1;
                        }
                    }else if(id==4){ //ok
                        if(t[j][x] == 1||t[j][x+1] == 1||t[j][x+2] == 1){
                            t[j-1][x] = t[j-1][x+1] = t[j-1][x+2] = t[j-2][x+1] = 1;
                            flag = 1;
                        }else if(j == 9) {
                            t[9][x] = t[9][x+1] = t[9][x+2] = t[8][x+1] = 1;
                            flag = 1;
                        }
                    }
                    if(flag == 1)break;
                }
                if(flag == 1)break;
            }
        }
        for(int i = 0;i < 10; i++){
            for(int j = 0;j < 10; j++){
                System.out.print(t[i][j]);
            }
            System.out.println();
        }
    }
}
