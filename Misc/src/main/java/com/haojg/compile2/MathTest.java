package com.haojg.compile2;

public class MathTest {
 
     public static void main(String[] args) {
      String expression = "(0*1--3)-5/-4-(3*(-2.13))";
     double result = Calculator.conversion(expression);
      System.out.println(expression + " = " + result);
      System.out.println();
      }
      
 }