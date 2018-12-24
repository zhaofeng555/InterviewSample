package com.haojg.math;


import parsii.eval.Expression;
import parsii.eval.Parser;
import parsii.eval.Scope;
import parsii.eval.Variable;
import parsii.tokenizer.ParseException;

public class ElMathTest {

    public static void main(String[] args) throws Exception {
        test1();
        test2();
    }

    public static void test2() throws ParseException {
        Scope scope = Scope.create();
        Variable a = scope.getVariable("a");
        Expression expr = Parser.parse("3 + a * 4", scope);
        a.setValue(4);
        System.out.println(expr.evaluate());
        a.setValue(5);
        System.out.println(expr.evaluate());
    }
    public static void test1() throws ParseException {
        String exp = "2 + (7-5) * 3.14159 * x + sin(0)";
        double X_VALUE = 5;

// compile
        Scope scope = Scope.create();
        Expression parsiiExpr = Parser.parse(exp);
        Variable var = scope.getVariable("x");
        var.setValue(X_VALUE);

// evaluate
        double result = parsiiExpr.evaluate();

        System.out.println(result);//-> 2.0
    }



}
