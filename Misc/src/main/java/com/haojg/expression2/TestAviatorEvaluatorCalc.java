package com.haojg.expression2;

import com.googlecode.aviator.AviatorEvaluator;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.HashMap;
import java.util.Map;

public class TestAviatorEvaluatorCalc {
    public static void main(String[] args) throws ScriptException {
//        testAviator1();

        testRunJs();
    }

    private static void testRunJs() throws ScriptException {
        String json="{\"name\":\"haojg\",\"address\":\"jilin,changchun\"}";
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");
        engine.put("out", System.out);
        String js = "var obj="+json;
        engine.eval(js);
//        Object jsonObj = engine.eval(json);
//        System.out.println(jsonObj);

        Object obj = engine.get("obj");
        System.out.println(obj);
        System.out.println(obj.getClass());
//        System.out.println(engine.get("obj.name"));

        String str = "(a or b) and c";
        str = str.replaceAll("or", "||");
        str = str.replaceAll("and", "&&");
        System.out.println(str);
        engine.put("a",true);
        engine.put("b",false);
        engine.put("c",true);
        Object result = engine.eval(str);
        System.out.println("结果类型:" + result.getClass().getName() + ",计算结果:" + result);
    }

    public void invokeMethod() throws ScriptException, NoSuchMethodException {
        ScriptEngine engine = new ScriptEngineManager().getEngineByExtension("js");
        String scriptText = "var obj = { getGreeting : function(name) { return 'Hello, ' + name; } }; ";
        engine.eval(scriptText);
        Invocable invocable = (Invocable) engine;
        Object scope = engine.get("obj");
        Object result = invocable.invokeMethod(scope, "getGreeting", "Alex");   //第一个参数为方法所属对象
        System.out.println(result);
    }

    private static void testAviator1() {
        int[] a = new int[]{6, 7, 8, 9};
        Map<String, Object> env = new HashMap<String, Object>();
        env.put("a", a);

        System.out.println(AviatorEvaluator.execute("1 + 2 + 3"));
        System.out.println(AviatorEvaluator.execute("a[1] + 100", env));
        System.out.println(AviatorEvaluator.execute("'a[1]=' + a[1]", env));
        //求数组长度
        System.out.println(AviatorEvaluator.execute("count(a)", env));
        //求数组总和
        System.out.println(AviatorEvaluator.execute("reduce(a, +, 1)", env));
        //检测数组每个元素都在 0 <= e < 10 之间。
        System.out.println(AviatorEvaluator.execute("seq.every(a, seq.and(seq.ge(0), seq.lt(10)))", env));
    }
}