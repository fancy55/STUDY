package com.study.algorithm.string;

import java.util.ArrayList;
import java.util.TreeSet;

//输入一个字符串,按字典序打印出该字符串中字符的所有排列
public class arrange {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if(str == null)return null;
        char[] ch = str.toCharArray();
        TreeSet<String> set = new TreeSet<>();
        goToPermutation(ch, 0, set);
        res.addAll(set);
        return res;
    }

    public void goToPermutation(char[] ch, int s, TreeSet<String> set){
        if(s == ch.length-1)set.add(String.valueOf(ch));
        else{
            for(int i = s;i < ch.length; i++){
                swap(ch, s, i);
                goToPermutation(ch, s+1, set);
                swap(ch, s, i);
            }
        }
    }

    public void swap(char[] ch, int m, int n){
        char t = ch[m];
        ch[m] = ch[n];
        ch[n] = t;
    }

}
