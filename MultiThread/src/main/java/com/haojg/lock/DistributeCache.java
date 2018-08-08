package com.haojg.lock;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

/**
 * 分布式进程消费共享消息
 * @author coshaho
 *
 */
public class DistributeCache 
{
    private static List<String> msgCache = new ArrayList<String>();
    
    static class MsgConsumer extends Thread 
    {
        @Override
        public void run() 
        {
            while(!CollectionUtils.isEmpty(msgCache))
            {
                String lock = ZookeeperLock.getInstance().getLock();
                if(CollectionUtils.isEmpty(msgCache))
                {
                    return;
                }
                String msg = msgCache.get(0);
                System.out.println(Thread.currentThread().getName() + " consume msg: " + msg);
                try 
                {
                    Thread.sleep(1000);
                } 
                catch (InterruptedException e) 
                {
                    e.printStackTrace();
                }
                msgCache.remove(msg);
                ZookeeperLock.getInstance().releaseLock(lock);
            }
        }
    }
    
    public static void main(String[] args)
    {
        for(int i = 0; i < 10; i++)
        {
            msgCache.add("msg" + i);
        }
        MsgConsumer consumer1 = new MsgConsumer();
        MsgConsumer consumer2 = new MsgConsumer();
        consumer1.start();
        consumer2.start();
    }
}