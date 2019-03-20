package com.haojg.cache;

import org.springframework.cache.concurrent.ConcurrentMapCache;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRU1<K, V> {
    private final int MAX_CACHE_SIZE;
    private final float DEFAULT_LOAD_FACTORY=0.75f;

    LinkedHashMap<K, V> map;


    ConcurrentMapCache c;

    public LRU1(int cacheSize){

        MAX_CACHE_SIZE = cacheSize;
        int capacity = (int)Math.ceil(MAX_CACHE_SIZE/DEFAULT_LOAD_FACTORY)+1;



        /**
         * 第三个参数 true:  代表linkedList按照访问顺序，可以作为lru缓存
         * 第三个参数 false: 代表按照插入顺序，可以作为FIFO缓存
         */
        map = new LinkedHashMap<K, V>(capacity, DEFAULT_LOAD_FACTORY, false){
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > MAX_CACHE_SIZE;
            }
        };

    }

    public synchronized void put(K key, V value){
        map.put(key, value);
    }

    public synchronized V get(K key){
        return map.get(key);
    }

    public synchronized void remove(K key){
        map.remove(key);
    }

}
