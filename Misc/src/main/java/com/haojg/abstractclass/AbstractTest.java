package com.haojg.abstractclass;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractTest {
    public static List<String> list = new ArrayList<>();

    public List<String> list2 ;

    public Object obj = new Object();

    public String hello = new String("hello");

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    private boolean flag;
}
