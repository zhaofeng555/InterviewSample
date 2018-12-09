package com.haojg.multi.read;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Callable;

public class ReadDataCallable implements Callable<Map<Integer, String>> {
    private Integer beginId;
    public ReadDataCallable(Integer beginId){
        this.beginId=beginId;
    }
    @Override
    public Map<Integer, String> call() throws Exception {
        Map<Integer, String> rs = new HashMap<>();
        rs.put(beginId, "hello"+beginId);
        System.out.print("call : \t");
        System.out.println(rs);
        Thread.sleep(new Random().nextInt(10));
        return rs;
    }
}
