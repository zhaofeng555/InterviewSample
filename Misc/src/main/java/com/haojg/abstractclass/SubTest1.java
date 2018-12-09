package com.haojg.abstractclass;

import java.util.ArrayList;
import java.util.List;

public class SubTest1 extends AbstractTest {
    public static void testList() {
        list.add("1");
        System.out.println(list.hashCode());
    }

    public static List<String> testList1() {
//        list.add("1");
        return list;
    }

    public List<String> testList2() {
        list2 = new ArrayList<>();
        System.out.println(list2.hashCode());
        return list2;
    }

    public Object getObj() {
        return obj;
    }
}
