package com.study.compilaition;

import java.util.*;

public class morphology {
	public static final int $ID = 33;  	//标识符
	public static final int $INT = 34; 	//常数

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("input：");
		String str=input.nextLine();

		List<Map.Entry<Integer, String>> list = new ArrayList<>();
		Operation myOperation = new Operation(str);
		analysis(list,str,myOperation);

		System.out.println("result：");
		for (Map.Entry<Integer, String> entry : list) {
			System.out.println("(" + entry.getKey() + "," + entry.getValue()+")");
		}
	}

	//识别出目标代码中的标识符（关键字）
	public static void analysis(List<Map.Entry<Integer, String>> list, String str, Operation myOperation){
		do{
			Map<Integer, String> map =  new HashMap<>();
			int code = 0,value = 0;
			int param = 0;
			String strToken= "";
			myOperation.GetChar();
			myOperation.GetBC();
//			System.out.println(myOperation.getCh());
			if(myOperation.IsLetter()){
				while (myOperation.IsLetter()||myOperation.IsDigit()){
					strToken += myOperation.getCh();
					myOperation.GetChar();//下移
				}
				myOperation.Retract();
				code = myOperation.isKeyWord(strToken); //判断是否是保留字
				if (code == 0){//非保留字
					value = myOperation.InsertId(strToken);
					param=1;
				}
//				System.out.println(strToken+" "+code+" "+value);
			}else if (myOperation.IsDigit()){
				while(myOperation.IsDigit()){
					strToken += myOperation.getCh();
					myOperation.GetChar();
				}
				myOperation.Retract();
				value = myOperation.InsertConst(strToken);
				param=2;
			}else if (myOperation.getCh()=='*'){
				code=myOperation.Find("*");
			}else if (myOperation.getCh()=='/'){
				code=myOperation.Find("/");
			}else if (myOperation.getCh()=='%'){
				code=myOperation.Find("%");
			}else if (myOperation.getCh()=='~'){
				code=myOperation.Find("~");
			}else if (myOperation.getCh()=='^'){
				code=myOperation.Find("^");
			}else if (myOperation.getCh()=='?'){
				code=myOperation.Find("?");
			}else if (myOperation.getCh()==':'){
				code=myOperation.Find(":");
			}else if (myOperation.getCh()=='.'){
				code=myOperation.Find(".");
			}else if (myOperation.getCh()==','){
				code=myOperation.Find(",");
			}else if (myOperation.getCh() ==';') {
				code=myOperation.Find(";");
			}else if (myOperation.getCh() =='('){
				code=myOperation.Find("(");
			}else if (myOperation.getCh() ==')'){
				code=myOperation.Find(")");
			}else if (myOperation.getCh()==']'){
				code=myOperation.Find("]");
			}else if (myOperation.getCh()=='['){
				code=myOperation.Find("[");
			}else if (myOperation.getCh()=='{'){
				code=myOperation.Find("{");
			}else if (myOperation.getCh()=='}'){
				code=myOperation.Find("}");
			}else if (myOperation.getCh()=='='){
				myOperation.GetChar();
				if (myOperation.getCh() =='='){
					code=myOperation.Find("==");
				}else{
					myOperation.Retract();
					code=myOperation.Find("=");
				}
			}else if (myOperation.getCh()=='+'){
				myOperation.GetChar();
				if (myOperation.getCh() =='+'){
					code=myOperation.Find("++");
				}else {
					code=myOperation.Find("+");
					myOperation.Retract();
				}
			}else if (myOperation.getCh()=='-'){
				myOperation.GetChar();
				if (myOperation.getCh() =='-'){
					code=myOperation.Find("--");
				}else if(myOperation.IsDigit()) {
					strToken += "-";
					while(myOperation.IsDigit()){
						strToken += myOperation.getCh();
						myOperation.GetChar();
					}
					myOperation.Retract();
//					System.out.println(strToken);
					param = 2;
				}else{
					myOperation.Retract();
					code=myOperation.Find("-");
				}
			}else if (myOperation.getCh()=='&'){
				myOperation.GetChar();
				if (myOperation.getCh() =='&'){
					code=myOperation.Find("&&");
				}else{
					myOperation.Retract();
					code=myOperation.Find("&");
				}
			}else if (myOperation.getCh()=='|'){
				myOperation.GetChar();
				if (myOperation.getCh() =='|'){
					code=myOperation.Find("||");
				}else{
					myOperation.Retract();
					code=myOperation.Find("|");
				}
			}else if (myOperation.getCh()=='!'){
				myOperation.GetChar();
				if (myOperation.getCh() =='='){
					code=myOperation.Find("!=");
				}else{
					myOperation.Retract();
					code=myOperation.Find("!");
				}
			}else if (myOperation.getCh()=='>'){
				myOperation.GetChar();
				if (myOperation.getCh() =='>'){
					code=myOperation.Find(">>");
				}else if(myOperation.getCh() =='='){
					code=myOperation.Find(">=");
				}else{
					myOperation.Retract();
					code=myOperation.Find(">");
				}
			}else if (myOperation.getCh()=='<'){
				myOperation.GetChar();
				if (myOperation.getCh() =='<'){
					code=myOperation.Find("<<");
				}else if(myOperation.getCh() =='='){
					code=myOperation.Find("<=");
				}else{
					myOperation.Retract();
					code=myOperation.Find("<");
				}
			}else{ //err
				code = 0;
			}
			if(param == 1)map.put($ID, strToken);
			else if(param == 2) map.put($INT, strToken);
			else map.put(code, "-");

			Map.Entry<Integer,String> entry = null;
			for(Map.Entry<Integer,String> entry1:map.entrySet())
				entry = entry1;
			list.add(entry);
//			System.out.println(code+" "+value);
		}while(myOperation.getI()<str.length()-1);
	}
}

class Operation{
	private int i;     //最新读入的字符串的位置
	private char ch;   //存放最新读入的源程序字符
	private String str;//输入的字符串
	int wordKey = 0;		//标识符表的指向位置
	int constantsKey = 0;	//常数表的指向位置
//	String[] wordExcel = new String[100];	//标识符表
//	int[] constantsExcel = new int[100];	//常数表

	//保留字表
	String reservedWord[]={
			" ","int","long","short","float","double","char","unsigned","signed",
			"const","void","volatile","enum","struct","union","if","else","goto",
			"switch","case","do","while","for","continue","break","return","default",
			"typedef","auto","register","extern","static","sizeof"
	};

	//运算符和界符表
	String symbol[]={
			"+","++","-","--","*","/","%","<","<=","<<",">",">=",">>","=","==","!=","!",
			"&","&&","|","||","~","^","?",":",",",";",".","[","]","(",")","{","}"
	};

	//初始化类
	public Operation(String str){
		this.i=-1;
		this.ch=' ';
		this.str=str;
	}

	//把下一个字符读入到 ch 中
	public void GetChar(){
		setI(getI()+1);
		if(getI()>=0&&getI()<getStr().length()) setCh(getStr().charAt(getI()));
	}

	//跳过空白符，直至 ch 中读入一非空白符
	public void GetBC(){
		while(getCh()==' '&&getI()<str.length()){
			GetChar();
		}
	}

	//判断ch中字符是否为字母
	public boolean IsLetter(){
		char c=getCh();
		if(c-'a'>=0&&c-'z'<=0){
			return true;
		}else if(c-'A'>=0&&c-'Z'<=0){
			return true;
		}else{
			return false;
		}
	}

	//判断ch中字符是否为数字
	public boolean IsDigit(){
		char c=getCh();
		if(c-'0'>=0&&c-'9'<=0){
			return true;
		}else{
			return false;
		}
	}

	//判断保留字
	public int isKeyWord(String str){
		for (int i=0;i<reservedWord.length;i++) {
			if(str.equals(reservedWord[i])) return i;
//			System.out.println("index = " + i + ", Value = " + reservedWord[i]);
		}
		return 0;
	}

	public int Find(String str){
		for (int i=0;i<symbol.length;i++) {
			if(str.equals(symbol[i])) return i+35;
//			System.out.println("index = " + i + ", Value = " + symbol[i]);
		}
		return 0;
	}

	//回退
	public void Retract(){
		setI(getI()-1);
		if(getI()>=0&&getI()<getStr().length())setCh(str.charAt(getI()));
	}

	//将strToken中的标识符插入符号表，返回符号表指针
	public int InsertId(String str){
//		wordExcel[wordKey]=str;
		return wordKey++;
	}

	//将strToken中的常数插入常数表
	public int InsertConst(String str){
//		constantsExcel[constantsKey]=Integer.parseInt(str);
		return constantsKey++;
	}

	public int getI() { return i; }//当前读的位置
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
}
