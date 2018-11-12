package com.haojg.java8;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
 
public class Java8Tester00 {
   public static void main(String args[]){
   
      List<String> names1 = new ArrayList<String>();
      names1.add("libo ");
      names1.add("zhonghao ");
      names1.add("zhengang ");
      names1.add("yachao ");

      List<String> names2 = new ArrayList<String>();
      names2.add("libo ");
      names2.add("zhonghao ");
      names2.add("zhengang ");
      names2.add("yachao ");

      Java8Tester00 tester = new Java8Tester00();
      System.out.println("使用 Java 7 语法: ");
        
      tester.sortUsingJava7(names1);
      System.out.println(names1);
      System.out.println("使用 Java 8 语法: ");
        
      tester.sortUsingJava8(names2);
      System.out.println(names2);
   }
   
   // 使用 java 7 排序
   private void sortUsingJava7(List<String> names){   
      Collections.sort(names, new Comparator<String>() {
         @Override
         public int compare(String s1, String s2) {
            return s1.compareTo(s2);
         }
      });
   }
   
   // 使用 java 8 排序
   private void sortUsingJava8(List<String> names){
      Collections.sort(names, (s1, s2) -> s1.compareTo(s2));
   }
}