package com.devnp;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Created by duliu on 12/8/2017.
 *
 * 内建函数式接口演示
 */
public class FunctionalInterfaces {

    public static void main(String [] args){
        //1.功能型接口 有参数和返回值 Function
        Function<String, String> func = String :: toUpperCase ;
        System.out.println(func.apply("Hello Wolrd!"));

        //2.消费型接口 只有参数没有返回值 Consumer
        Consumer<String> consumer = System.out::println;
        consumer.accept("Hello Wolrd!");

        //3.供给型 没有参数但是有返回值 Supplier
        String str = "Hello World!" ;
        Supplier<Boolean> supplier = str :: isEmpty ;
        System.out.println(supplier.get());

        //4.断言型接口 Predicate 是一个判断操作
        String string = "Hello!" ;
        Predicate<String> predicate = string :: matches ;
        System.out.println(predicate.test("^\\S+$"));

    }

}
