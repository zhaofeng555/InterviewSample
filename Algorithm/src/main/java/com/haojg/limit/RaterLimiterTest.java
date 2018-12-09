package com.haojg.limit;

import com.google.common.util.concurrent.RateLimiter;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * @Author: 146477
 * @Date: 2018/8/8 11:53
 */
public class RaterLimiterTest {

    RateLimiter rl = RateLimiter.create(2.0);

    @Test
    public void testRateLimiter() throws InterruptedException {

        int i = 0;
        while (i < 1000) {
            double acquire = rl.acquire();
            //System.out.println("获取 ： "+ acquire);
            TimeUnit.MILLISECONDS.sleep(100L);
            System.out.println("时间：" + System.currentTimeMillis());
            i++;
            if (i >= 100) {

                break;
            }
        }
    }

}
