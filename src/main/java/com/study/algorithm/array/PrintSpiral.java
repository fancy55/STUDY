package com.study.algorithm.array;

import java.util.ArrayList;

public class PrintSpiral {
    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> ans = new ArrayList<>();
        int sr = 0, sc = 0, er = matrix.length-1, ec = matrix[0].length-1;
        while(sr <= er && sc <= ec){
            printEdge(ans, matrix, sr++, sc++, er--, ec--);
        }
        return ans;
    }

    public static void printEdge(ArrayList<Integer> ans, int[][] matrix, int sr, int sc, int er, int ec){
        if(sr == er){
            for(int i = sc;i <= ec; i++) ans.add(matrix[sr][i]);
        }else if(sc == ec){
            for(int i = sr;i <= er; i++) ans.add(matrix[i][sc]);
        }else{
            int tmpSC = sc;
            int tmpSR = sr;
            while(tmpSC != ec){
                ans.add(matrix[sr][tmpSC]);
                tmpSC++;
            }
            while(tmpSR != er){
                ans.add(matrix[tmpSR][ec]);
                tmpSR++;
            }
            while(tmpSC != sc){
                ans.add(matrix[er][tmpSC]);
                tmpSC--;
            }
            while(tmpSR != sr){
                ans.add(matrix[tmpSR][sc]);
                tmpSR--;
            }
        }
    }

    public static void main(String[] args) {
        int[][] a = {{1,2,3,4,1},{5,6,7,8,2},{9,10,11,12,3},{13,14,15,16,4},{17,18,19,20,5}};
        int[][] b = {{1,2},{3,4}};
        System.out.println(printMatrix(a));
    }
}
