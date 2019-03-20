package com.haojg.queue;

import java.util.ArrayList;
import java.util.List;

public class DoubleBufferQueue<T> {
	private List<T> readList = new ArrayList<T>();
	private List<T> writeList = new ArrayList<T>();
	private static DoubleBufferQueue bufferQueue = new DoubleBufferQueue();
	
	private DoubleBufferQueue() {
	}
	
	public static DoubleBufferQueue getInstance() {
		return bufferQueue;
	}
	
	public void push(T value) {
		synchronized (writeList) {			
			writeList.add(value);
		}
	}

	
	public List<T> getReadList() {
		return readList;
	}
	
	public void swap() {
		synchronized(writeList) {
			List<T> tmp = readList;
			readList = writeList;
			writeList = tmp;
			
			writeList.clear();	
		}
	}

	public static void main(String[] args) {
		DoubleBufferQueue<String> queue = DoubleBufferQueue.getInstance();

		queue.push("hello");
		queue.push("world");
		queue.swap();

		System.out.println(queue.getReadList());

		queue.push("hello1");
		queue.push("world2");
		queue.swap();

		List<String> readList = queue.getReadList();
		System.out.println(readList);



	}
}