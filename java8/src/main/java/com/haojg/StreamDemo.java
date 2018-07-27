package com.haojg;

import java.util.stream.IntStream;

/**
 * Hello world!
 *
 */
public class StreamDemo {
	public static void main(String[] args) {
		testIntStream();
		
	}
	
	static void testIntStream(){
		int[] nums={1,3,5,2,9,8,6};
		
		//单线程获取最小值
		int min = IntStream.of(nums).min().getAsInt();
		//多线程获取最大值
		int max = IntStream.of(nums).parallel().max().getAsInt();
		
		System.out.println("min = "+min);
		System.out.println("max = "+max);
		
	}
}