package com.haojg.lombok;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SetterExample {

    @Getter(value = AccessLevel.PRIVATE)
    @Setter
    private String name;

    //onMethod=@__({@AnnotationsHere})
    @Setter(onMethod = @__({@Deprecated}))
    private String age;

    //onParam=@__({@AnnotationsHere})
    @Setter(onParam = @__({}))
    private String sex;

    public static void main(String[] args) {
        SetterExample se = new SetterExample();
        se.setName("zhangsan");
        se.setAge("16");
        System.out.println(se.getAge());
        System.out.println(se.getName());
    }
}