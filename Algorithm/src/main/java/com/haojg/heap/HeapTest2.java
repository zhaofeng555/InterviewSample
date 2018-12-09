package com.haojg.heap;

import org.junit.Test;

import java.util.Iterator;
import java.util.PriorityQueue;

public class HeapTest2 {

    @Test
    public void testMemory() {
        int[] array = new int[Integer.MAX_VALUE];
        System.out.println(array.length);
    }

    @Test
    public void testPriorityQueue() {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.offer(50);
        queue.offer(60);
        queue.offer(30);
        queue.offer(20);
        queue.offer(70);
        queue.offer(25);
        queue.offer(10);
        queue.offer(40);

        System.out.println(queue);

        Iterator<Integer> iter = queue.iterator();
        while (iter.hasNext()) {
            System.out.print(iter.next() + ", ");
        }
        System.out.println();

    }
}
