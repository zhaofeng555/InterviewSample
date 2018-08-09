package com.haojg.reflect;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ReflectTest {

    public static Car initByDefaultConst() throws Throwable{
        // 1. 通过类装载器获取Car类的对象
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        //使用全限定名来找class类
//        Class clazz = loader.loadClass("com.haojg.reflect.Car");

        /*
        */  //另一种方式获取class
        Class clazz = Class.forName("com.haojg.reflect.Car");

        // 2. 获取类的默认构造器对象并通过它实例化Car
        Constructor cons = clazz.getDeclaredConstructor((Class[])null);
        Car car = (Car)cons.newInstance();

        // 3. 通过反射方法设置属性
        Method setBrand = clazz.getMethod("setBrand", String.class);
        setBrand.invoke(car,"红旗");
        Method setColor = clazz.getMethod("setColor", String.class);
        setColor.invoke(car,"黑色");
        Method setMaxSpeed = clazz.getMethod("setMaxSpeed", int.class);
        setMaxSpeed.invoke(car,200);
        return car;
    }
    @Test
    public void test() throws Throwable{
        Car car = initByDefaultConst();
        car.say();
    }
}