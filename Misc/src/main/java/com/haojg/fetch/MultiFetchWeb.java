package com.haojg.fetch;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MultiFetchWeb {
    static int num = Runtime.getRuntime().availableProcessors()*10;
    static LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>(10000){

        @Override
        public boolean offer(Runnable o) {
            try {
                put(o);
            } catch (InterruptedException e) {
            }
            return true;
        }
    };
    static  ThreadPoolExecutor exe = new ThreadPoolExecutor(num, num, 0, TimeUnit.SECONDS, queue);

    public static void main(String[] args) {
        OkHttpClient client = new OkHttpClient();
        int ct = Integer.MAX_VALUE;
        for(int i=0; i<ct; i++){
            Random r = new Random();
            exe.submit(()->{
                String url = "http://www.qizhisiwei.com/sort/puzzle/?"+r.nextDouble()+System.currentTimeMillis();
//                String url = "http://www.qizhisiwei.com/sort/puzzle/";
                System.out.println(url);
                Request request = new Request.Builder()
                        .url(url)
                        .build();

                try {
                    Response response = client.newCall(request).execute();

                    String con =  response.body().string();
                    System.out.println("code = "+response.code()+ ":"+response.message() + " , content length = "+con.length());

                    response.close();
                }catch (Exception e){
                    System.err.println(e.getMessage());
                }
            });

        }

        exe.shutdown();
    }


}
