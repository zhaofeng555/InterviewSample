package com.haojg.lambda;
 
import java.util.Arrays; 
import java.util.List; 
import java.util.Map; 
import java.util.stream.Collectors; 
 
public class LambdaMapReduce {



    static class User{

        enum Sex{
            MALE,FEMALE;
        }

        int id;
        String name;
        int age;
        Sex gender;

        public User(int id, String name, int age, Sex gender){
            this.id=id;
            this.name=name;
            this.age=age;
            this.gender =gender;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public Sex getGender() {
            return gender;
        }

        public void setGender(Sex gender) {
            this.gender = gender;
        }
    }

    private static List<User> users = Arrays.asList( 
            new User(1, "张三", 12,User.Sex.MALE),  
            new User(2, "李四", 21, User.Sex.FEMALE),  
            new User(3,"王五", 32, User.Sex.MALE),  
            new User(4, "赵六", 32, User.Sex.FEMALE)); 
 
    public static void main(String[] args) { 
        reduceAvg(); 
        reduceSum(); 

         
        //与stream.reduce方法不同，Stream.collect修改现存的值，而不是每处理一个元素，创建一个新值 
        //获取所有男性用户的平均年龄 
//        Averager averageCollect = users.parallelStream()
//
//                .filter(p -> p.getGender() == User.Sex.MALE)
//                .map(User::getAge)
//                .collect(Averager::new, Averager::accept, Averager::combine);
//
//        System.out.println("Average age of male members: "
//                + averageCollect.average());

        //获取年龄大于12的用户列表 
        List<User> list = users.parallelStream().filter(p -> p.age > 12) 
                .collect(Collectors.toList()); 
        System.out.println(list); 
 
        //按性别统计用户数 
        Map<User.Sex, Integer> map = users.parallelStream().collect( 
                Collectors.groupingBy(User::getGender, 
                        Collectors.summingInt(p -> 1))); 
        System.out.println(map); 
 
        //按性别获取用户名称 
        Map<User.Sex, List<String>> map2 = users.stream() 
                .collect( Collectors.groupingBy(
                                User::getGender, 
                                Collectors.mapping(User::getName,Collectors.toList())
                ));
        System.out.println(map2); 

        //按性别求年龄的总和 
        Map<User.Sex, Integer> map3 = users.stream().collect( 
                Collectors.groupingBy(User::getGender, 
                        Collectors.reducing(0, User::getAge, Integer::sum)));
 
        System.out.println("按性别求年龄的总和");
        System.out.println(map3);

        //按性别求年龄的平均值 
        Map<User.Sex, Double> map4 = users.stream().collect( 
                Collectors.groupingBy(User::getGender, 
                        Collectors.averagingInt(User::getAge))); 
        System.out.println(map4); 
 
    } 
 
    // 注意，reduce操作每处理一个元素总是创建一个新值， 
    // Stream.reduce适用于返回单个结果值的情况 
    //获取所有用户的平均年龄 
    private static void reduceAvg() {
        // mapToInt的pipeline后面可以是average,max,min,count,sum 
        double avg = users.parallelStream().mapToInt(User::getAge)  
                .average().getAsDouble(); 
 
        System.out.println("reduceAvg User Age: " + avg); 
    } 
 
    //获取所有用户的年龄总和 
    private static void reduceSum() { 
        double sum = users.parallelStream().mapToInt(User::getAge) 
                .reduce(0, (x, y) -> x + y); // 可以简写为.sum() 
 
        System.out.println("reduceSum User Age: " + sum); 
    } 
} 