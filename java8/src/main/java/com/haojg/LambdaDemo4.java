package com.haojg;

import java.text.DecimalFormat;
import java.util.function.Function;

@FunctionalInterface
interface IMoneyFormat{
	String format(int i);
}
class MyMoney{
	int money;
	public MyMoney(int money){
		this.money=money;
	}
	
	public void print(IMoneyFormat format){
		System.out.println("我的存款"+format.format(money)+"元");
	}
	public void print2(Function<Integer, String> moneyFormat){
		System.out.println("我的存款"+moneyFormat.apply(money)+"元");
	}
}
public class LambdaDemo4 {

	public static void main(String[] args) {
		MyMoney me = new MyMoney(999999);
		me.print(i->new DecimalFormat("#,###").format(i));
		me.print2(i->new DecimalFormat("#,###").format(i));
		
		Function<Integer, String> moneyFormat = i->new DecimalFormat("#,###").format(i);
		me.print2(moneyFormat.andThen(s->"人民币："+s));
		
	}
	
}