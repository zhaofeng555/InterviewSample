package com.haojg.cache;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.sun.corba.se.impl.ior.OldJIDLObjectKeyTemplate;

import java.util.AbstractMap;
import java.util.Set;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: 146477
 * @Date: 2018/6/28 20:03
 */
public class LRUCacheMap extends AbstractMap {

    private ExecutorService checkTimePool;

    private final static int MAX_SIZE = 1024;

    private final static ArrayBlockingQueue<Node> queue = new ArrayBlockingQueue<>(MAX_SIZE);

    private final static int default_array_size = 1024;

    private int arraySize;
    private Object[]arrays;
    private volatile boolean flag = true;
    private final static Long expire_time = 60*60*1000L;
    private volatile AtomicInteger size;

    public static void main(String[] args) {
        int ct = 95;
        int n = 7;
        System.out.println(ct%n);
        System.out.println(ct & (n-1));

        LRUCacheMap lru = new LRUCacheMap();
        lru.put("hello", "world");
        Object val = lru.get("hello");
        System.out.println(val);
    }

    public LRUCacheMap(){
        arraySize = default_array_size;
        arrays = new Object[arraySize];
        size=new AtomicInteger(0);
        executeCheckTime();
    }

    private void executeCheckTime(){
        ThreadFactory nameThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("check-thread-%d")
                .setDaemon(true)
                .build();
        checkTimePool = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(1), nameThreadFactory, new ThreadPoolExecutor.AbortPolicy());

    }


    @Override
    public Set<Entry> entrySet() {
        return super.keySet();
    }

    @Override
    public Object put(Object key, Object value) {
        
        int hash = hash(key);
        int index = hash % arraySize;
        Node currentNode = (Node) arrays[index];
        
        if(currentNode == null){
            arrays[index]=new Node(null, null, key, value);
            
            queue.offer((Node)arrays[index]);
            sizeUp();
        }else {
            Node cNode = currentNode;
            Node nNode = cNode;

            if(nNode.key == key){
                nNode.val=value;
            }
            while(nNode.next != null){
                if(nNode.key == key){
                    nNode.val=value;
                    break;
                }else{
                    sizeUp();
                    Node node = new Node(nNode, null, key, value);
                    queue.offer(currentNode);
                    cNode.next=node;
                }
                nNode = nNode.next;
            }
        }
        
        return null;
    }

    @Override
    public Object get(Object key) {

        int hash = hash(key);
        int index = hash%arraySize;
        Node currentNode = (Node)arrays[index];

        if(currentNode==null){
            return null;
        }

        if(currentNode.next == null){
            currentNode.setUpdateTime(System.currentTimeMillis());
            return currentNode;
        }

        Node nNode = currentNode;
        while(nNode.next != null){
            if(nNode.key == key){
                currentNode.setUpdateTime(System.currentTimeMillis());
                return nNode;
            }
            nNode = nNode.next;
        }

        return super.get(key);
    }

    @Override
    public Object remove(Object key) {

        int hash = hash(key);
        int index = hash % arraySize;
        Node currentNode = (Node) arrays[index];
        if(currentNode == null){
            return null;
        }

        if(currentNode.key == key){
            sizeDown();
            arrays[index]=null;

            queue.poll();
            return currentNode;
        }

        Node nNode = currentNode;
        while (nNode.next != null){
            if(nNode.key == key){
                sizeDown();

                nNode.pre.next=nNode.next;
                nNode = null;
                queue.poll();

                return nNode;
            }
            nNode = nNode.next;
        }

        return super.remove(key);
    }

    private void sizeUp() {
        flag = true;
        int curSize = size.incrementAndGet();
        if(curSize >= MAX_SIZE){
            Node node = queue.poll();
            if(node == null){
                throw new RuntimeException("data error !!!!");
            }

            Object key = node.key;
            remove(key);
            lruCallback();
        }
    }
    private void sizeDown() {
        if(queue.size() == 0){
            flag = false;
        }
        size.decrementAndGet();
    }

    @Override
    public int size() {
        return size.get();
    }

    private class Node {
        private Node next;
        private Node pre;
        private Object key;
        private Object val;
        private Long updateTime;

        public Node(Node pre, Node next, Object key, Object val){
            this.pre=pre;
            this.next=next;
            this.key=key;
            this.val=val;
            this.updateTime=System.currentTimeMillis();
        }

        public Long getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(Long updateTime) {
            this.updateTime = updateTime;
        }

        @Override
        public String toString() {
            return "Node:key="+key+", val="+val;
        }
    }

    public int hash(Object key){
        int h ;
        return (key == null)?0:(h=key.hashCode()) ^ (h>>>16);
    }

    private void lruCallback(){
        System.out.println("call back");
    }

    private  class CheckTimeThread implements Runnable{

        @Override
        public void run() {
            while (flag){
                try{
                    Node node = queue.poll();
                    if(node == null){
                        continue;
                    }
                    Long updateTime = node.getUpdateTime();

                    if((updateTime - System.currentTimeMillis()) >= expire_time){
                        remove(node.key);
                    }

                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}
