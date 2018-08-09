package java.lang;

public class String {
    public String(String msg) {
        System.out.println("String");
        System.out.println(msg);
    }
}

/*
于是我们可以联想到JVM装载类时使用的“全盘负责委托机制”。
因为ClassLoader装载一个类时,永远是由根装载器来装载的,
只有在找不到类时才从自己的类路径中查找并装载目标类,
于是避免了有人编写了一个恶意的基础类(如java.lang.String)并装载到JVM中所带来的可怕后果。
 */