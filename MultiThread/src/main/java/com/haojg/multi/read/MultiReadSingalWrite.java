package com.haojg.multi.read;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class MultiReadSingalWrite {
    List<String> arr = new ArrayList<>();

    static TreeMap<Integer, String> map = new TreeMap<>();

    static AtomicInteger readPageIndex = new AtomicInteger(0);
    static AtomicInteger writePageIndex = new AtomicInteger(0);
    static Integer ct = 100;
    static Integer step = 10;

    static ExecutorService pool = Executors.newFixedThreadPool(5);
    LinkedBlockingQueue<Integer> beginIdQueue = new LinkedBlockingQueue<>(5);
    LinkedBlockingQueue<Future<Map<Integer, String>>> dataQueue = new LinkedBlockingQueue<>(5);

    static AtomicBoolean isComplete = new AtomicBoolean(false);

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        MultiReadSingalWrite mrt = new MultiReadSingalWrite();
        mrt.readBeginPageId2Queue();
        mrt.handleQueueData2Queue();
        mrt.outQueueData();

        pool.shutdown();
    }

    void outQueueData() {
        try {
            while (!isComplete.get() || !dataQueue.isEmpty()) {
                Future<Map<Integer, String>> fu =  dataQueue.poll(10L, TimeUnit.MILLISECONDS);
                Map<Integer, String> rs = fu.get();
                System.out.println("get future data"+ rs.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void handleQueueData2Queue() {
       new Thread(()->{
           try {
               while (!isComplete.get() || !beginIdQueue.isEmpty()) {
                   Integer beginId = beginIdQueue.poll(10L, TimeUnit.MILLISECONDS);
                   if (beginId != null) {
                       ReadDataCallable cal = new ReadDataCallable(beginId);
                       Future<Map<Integer, String>> fu = pool.submit(cal);
                       dataQueue.put(fu);
                   }
               }

           } catch (Exception e) {
               e.printStackTrace();
           }
       }).start();
    }


    void readBeginPageId2Queue() {
        new Thread(() -> {
            while (true) {

                if(readPageIndex.get()>getSumPage()){
                    isComplete.set(true);
                    break;
                }

                int[] indexArr = readDBInfo();
                try {
                    for (int i : indexArr) {
                        beginIdQueue.put(i);
                        System.out.println("readBeginPageId2Queue "+i);
                        readPageIndex.incrementAndGet();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    int[] readDBInfo() {
        int[] rs = new int[5];
        int beginId = readPageIndex.get();
        for (int i = beginId; i < beginId + 5; i++) {
            rs[i % 5] = i;
        }
        return rs;
    }

    int getSumPage() {
        return 20;
    }
}


