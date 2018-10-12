package com.haojg.abstractclass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestMain {
//    private ConcurrentHashMap<String, Boolean> jobReadWriteFlagMap = new ConcurrentHashMap<>();
    private Map<String, Boolean> jobReadWriteFlagMap = new HashMap<>();

    public static void main(String[] args) {
        new TestMain().test();
    }

    private static void test1() {
        SubTest1 s1 = new SubTest1();
        SubTest2 s2 = new SubTest2();

        System.out.println(SubTest1.testList1() == SubTest2.testList1());
        SubTest1.testList();
        SubTest2.testList();
        System.out.println(SubTest1.testList1() == SubTest2.testList1());

        System.out.println(s1.testList2() == s2.testList2());

        System.out.println(new Object().hashCode());

        System.out.println(s1.getObj() == s2.getObj());

        System.out.println(s1.hello.hashCode());
        System.out.println(s2.hello.hashCode());
    }

    public void test(){
        jobReadWriteFlagMap.put("hello", false);
        new Thread(()->{
            while (true){
                try {
                    TimeUnit.SECONDS.sleep(2L);
                } catch (InterruptedException e) {
                }
                Boolean s = true;
                System.out.println(s);
                jobReadWriteFlagMap.put("hello", true);
            }
        }).start();

        new Thread(()->{
            while (true){
                Boolean s = jobReadWriteFlagMap.get("hello");
                System.out.println(s);
                try {
                    TimeUnit.SECONDS.sleep(1L);
                } catch (InterruptedException e) {
                }
            }
        }).start();
    }
}
