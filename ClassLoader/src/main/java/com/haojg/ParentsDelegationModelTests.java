package com.haojg;

public class ParentsDelegationModelTests {
    public static void main(String[] args) throws Exception {
        //ClassLoader 加载
        //1，加载class文件 > 内存
        //lock,校验
        //3，准备（内存）？jvm内存模型
        //4，解析（接口，方法，字段）
        //5，初始化（静态变量，静态代码块）

        ClassLoader classLoader = ParentsDelegationModelTests.class.getClassLoader().loadClass("java.lang.String").getClassLoader();
        System.out.println("核心类库加载器：" + classLoader);


        ClassLoader classLoader2 = ParentsDelegationModelTests.class.getClassLoader().loadClass("com.sun.nio.zipfs.ZipCoder").getClassLoader();
        System.out.println("扩展类库加载器：" + classLoader2);

        ClassLoader classLoader3 = ParentsDelegationModelTests.class.getClassLoader();
        System.out.println("应用程序类加载器：" + classLoader3);

        System.out.println("应用程序库类加载器的父类：" + classLoader3.getParent());

        System.out.println("应用程序库类加载器父类的父类：" + classLoader3.getParent().getParent());
        System.out.println();
    }
}
