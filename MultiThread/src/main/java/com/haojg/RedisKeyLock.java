package com.haojg;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.exceptions.JedisException;

import java.util.concurrent.TimeUnit;

public class RedisKeyLock {
    private static Logger logger = LoggerFactory.getLogger(RedisKeyLock.class);
    private final static long ACCQUIRE_LOCK_TIMEOUT_IN_MS = 10 * 1000;
    private final static int EXPIRE_IN_SECOND = 5;//锁失效时间
    private final static long WAIT_INTERVAL_IN_MS = 100;
    private static RedisKeyLock lock;
    private JedisPool jedisPool;
    private RedisKeyLock(JedisPool pool){
        this.jedisPool = pool;
    }
    public static RedisKeyLock getInstance(JedisPool pool){
        if(lock == null){
            lock = new RedisKeyLock(pool);
        }
        return lock;
    }
 
    public void lock(final String redisKey) {
        Jedis resource = null;
        try {
            long now = System.currentTimeMillis();
            resource = jedisPool.getResource();
            long timeoutAt = now + ACCQUIRE_LOCK_TIMEOUT_IN_MS;
            boolean flag = false;
            while (true) {
                String expireAt = String.valueOf(now + EXPIRE_IN_SECOND * 1000);
                long ret = resource.setnx(redisKey, expireAt);
                if (ret == 1) {//已获取锁
                    flag = true;
                    break;
                } else {//未获取锁，重试获取锁
                    String oldExpireAt = resource.get(redisKey);
                    if (oldExpireAt != null && Long.parseLong(oldExpireAt) < now) {
                        oldExpireAt = resource.getSet(redisKey, expireAt);
                        if (Long.parseLong(oldExpireAt) < now) {
                            flag = true;
                            break;
                        }
                    }
                }
                if (timeoutAt < now) {
                    break;
                }
              TimeUnit.NANOSECONDS.sleep(WAIT_INTERVAL_IN_MS);
            }
            if (!flag) {
                throw new RuntimeException("canot acquire lock now ...");
            }
        } catch (JedisException je) {
            logger.error("lock", je);
            je.printStackTrace();
            if (resource != null) {
                jedisPool.returnBrokenResource(resource);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("lock", e);
        } finally {
            if (resource != null) {
                jedisPool.returnResource(resource);
            }
        }
    }
    public boolean unlock(final String redisKey) {
        Jedis resource = null;
        try {
            resource = jedisPool.getResource();
            resource.del(redisKey);
            return true;
        } catch (JedisException je) {
            je.printStackTrace();
            if (resource != null) {
                jedisPool.returnBrokenResource(resource);
            }
            return false;
        } catch (Exception e) {
            logger.error("lock", e);
            return false;
        } finally {
            if (resource != null) {
                jedisPool.returnResource(resource);
            }
        }
    }
}