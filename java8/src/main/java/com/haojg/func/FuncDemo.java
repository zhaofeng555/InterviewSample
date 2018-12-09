package com.haojg.func;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class FuncDemo {
    Person p1 = new Person("zhangsan", 20);
    Person p2 = new Person("lisi", 30);
    Person p3 = new Person("wangwu", 40);

    List<Person> persons = Arrays.asList(p1, p2, p3);

    List<Person> getPersonsByName(String name, List<Person> persons) {
        return persons.stream().filter(person -> person.name.equals(name)).collect(Collectors.toList());
    }

    List<Person> getPersonsByAge(int age, List<Person> persons) {
        BiFunction<Integer, List<Person>, List<Person>> biFunction = (ageOfPerson, personList) -> {
            return personList.stream().filter(person -> person.age > ageOfPerson).collect(Collectors.toList());
        };
        return biFunction.apply(age, persons);
    }
}

class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}