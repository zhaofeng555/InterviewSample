package com.haojg.expression;

public class Test {
	public static void main(String args[]) throws Exception{
		String 表达式="100.25+ (100 /( 25+ 12.5*2))+50/(23+(1+1))";
		System.out.println(new Calculate().处理表达式(表达式));
	}
}
