package com.study.algorithm.compete;

import java.math.BigInteger;
import java.util.Scanner;

public class t2 {
    final static String MY = "AOLIGEI!";
    final static String SL = "DAAAAAMN!!";

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        BigInteger n = in.nextBigInteger();
        BigInteger n75 = new BigInteger("75");
        BigInteger n0 = new BigInteger("0");
        while(n.compareTo(n0) != 0){
            if(n.compareTo(n75) > 0) System.out.println(SL);
            else System.out.println(MY);
            n = in.nextBigInteger();
        }
    }
}
