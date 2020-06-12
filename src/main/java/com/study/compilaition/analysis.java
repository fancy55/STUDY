package com.study.compilaition;

import java.util.Scanner;

public class analysis {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入测试语句：(请以#结尾)");
        String str=input.nextLine();
        Operation2 myOperation=new Operation2(str);
        myOperation.GetChar();
        System.out.println("分析后输出结果：");
        if(myOperation.subroutineE()){
            System.out.println("该输入串符合文法");
        }else{
            System.out.println("该输入串不符合文法");
        }
    }
}
class Operation2{
    private int i;     //存放最新读入的字符串的位置
    private char ch;   //存放最新读入的字符串字符
    private String str;//输入的字符串
    private int flag;  //判断是否是正确的输入串标签
    //初始化类
    public Operation2(String str){
        this.i=-1;
        this.ch=' ';
        this.str=str;
        this.flag=1;
    }
    //把下一个字符读入到 ch 中
    public void GetChar(){
        setI(getI()+1);
        if(getI()>=0&&getI()<getStr().length()) setCh(getStr().charAt(getI()));
    }
    //E对应的递归下降子程序
    public boolean subroutineE(){
        subroutineT();
        subroutinee();
        if(getFlag()==1){
            return true;
        }else{
            return false;
        }
    }
    //E'对应的递归下降子程序
    public void subroutinee(){
        if(getCh()=='+'){
            GetChar();
            subroutineE();
        }
    }
    //T对应的递归下降子程序
    public void subroutineT(){
        subroutineF();
        subroutinet();
    }
    //T'对应的递归下降子程序
    public void subroutinet(){
        if(getCh()=='('|getCh()=='a'|getCh()=='b'|getCh()=='^'){
            subroutineT();
        }
    }
    //F对应的递归下降子程序
    public void subroutineF(){
        subroutineP();
        subroutinef();
    }
    //F'对应的递归下降子程序
    public void subroutinef(){
        if(getCh()=='*'){
            GetChar();
            subroutinef();
        }
    }
    //P对应的递归下降子程序
    public void subroutineP(){
        if(getCh()=='a'){
            GetChar();
        }else if(getCh()=='b'){
            GetChar();
        }else if(getCh()=='^'){
            GetChar();
        }else{
            if(getCh()=='('){
                GetChar();
                subroutineE();
                if(getCh()==')'){
                    GetChar();
                }else{
                    setFlag(0);
                }
            }else{
                setFlag(0);
            }
        }
    }
    public int getI() {
        return i;
    }
    public void setI(int i) {
        this.i = i;
    }
    public char getCh() {
        return ch;
    }
    public void setCh(char ch) {
        this.ch = ch;
    }
    public String getStr() {
        return str;
    }
    public void setStr(String str) {
        this.str = str;
    }
    public int getFlag() {
        return flag;
    }
    public void setFlag(int flag) {
        this.flag = flag;
    }
}

