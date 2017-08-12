package com.devnp;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;

/**
 * Created by duliu on 10/8/2017.
 * 方法的引用演示
 */
public class MethodReference {

    public static void main(String [] args){
        //Static Method Reference 引用静态方法
        StaticMethodReference<String, Integer> methodReference = String::valueOf ;
        System.out.println(methodReference.getInfo(2000));

        //Common Method Reference 引用普通方法
        String str = "hello world!";
        StaticMethodReference<String, Locale> methodReference1 = str::toUpperCase;
        System.out.println(methodReference1.getInfo(Locale.ENGLISH));

        //类之中构造方法的引用
        Creator<Person> personCreator = Person::new;
        System.out.println(personCreator.create("Lao Wang", 23));

        //特定类型的方法引用
        String[] stringArray = { "Barbara", "Linda", "James", "Mary", "Lucy" };
        Arrays.sort(stringArray, String::compareToIgnoreCase);

        System.out.println(Arrays.toString(stringArray));
    }
}

/**
 *
 * @param <R> 返回值类型
 * @param <P> 参数类型
 */
interface StaticMethodReference<R, P>{
    public R getInfo(P p);
}

interface Creator<R extends Person>{
    public R create(String name, Integer age);
}

class Person{

    private String name ;

    private Integer age ;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}