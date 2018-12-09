package com.haojg.conf;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.StringUtils;

/**
 * Function:校验是否有 redis 配置
 *
 * @author crossoverJie
 * Date: 2017/8/1 00:22
 * @since JDK 1.8
 */
public class CheckReqCondition implements Condition {

    private static Logger logger = LoggerFactory.getLogger(CheckReqCondition.class);


    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata annotatedTypeMetadata) {

        //如果没有加入redis配置的就返回false
        String property = context.getEnvironment().getProperty("spring.redis.host");
        String clusterProperty = context.getEnvironment().getProperty("spring.redis.cluster.nodes");
        if (StringUtils.isEmpty(property) && StringUtils.isEmpty(clusterProperty)) {
            logger.warn("Need to configure redis!");
            return false;
        } else {
            return true;
        }

    }

    public static void main(String[] args) {
        System.out.println(Boolean.valueOf(null));
        System.out.println(Boolean.valueOf(""));
        System.out.println(Boolean.parseBoolean(null));
        System.out.println(Boolean.parseBoolean(""));
    }
}