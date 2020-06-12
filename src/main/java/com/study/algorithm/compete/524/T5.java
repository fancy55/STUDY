package com.study.algorithm.compete;

import java.io.*;

public class T5 {

    public static void main(String[] args) throws IOException {
        StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter pw=new PrintWriter(new OutputStreamWriter(System.out));
        st.nextToken();
        int n=(int)st.nval;
        st.nextToken();
        int k=(int)st.nval;
        int[][] a=new int[n][n];
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                st.nextToken();
                a[i][j]=(int)st.nval;
                a[i][j]=a[i][j]*(-1);
                if(i==j) a[i][j]++;
                pw.print(a[i][j]+" ");
            }
            pw.println();
        }
        pw.flush();


    }
}
