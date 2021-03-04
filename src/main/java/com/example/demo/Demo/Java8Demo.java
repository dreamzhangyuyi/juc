package com.example.demo.Demo;

import com.example.demo.entity.Book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Java8Demo {
    public static void main(String[] args) {
        Function<String, Integer> function = s -> {
            return s.length();
        };
        Predicate<Integer> predicate = i -> {
            return i > 10;
        };
        Consumer<String> consumer = s -> {
            System.out.println(s);
        };
        Supplier<String> supplier = () -> {
            return "abc";
        };
        System.out.println(function.apply("aaabbb"));
        System.out.println(predicate.test(15));
        consumer.accept("yyyuuu");
        System.out.println(supplier.get());


        Book a = new Book(1,"a",15);
        Book b = new Book(2,"b",12);
        Book c = new Book(3,"c",18);
        Book d = new Book(4,"d",20);
        Book e= new Book(6,"e",25);
        List<Book> list = Arrays.asList(a,b,c,d,e);
//        list.add(a);
//        list.add(b);
//        list.add(c);
//        list.add(d);
//        list.add(e);

        list.stream().filter(i -> i.getId()%2 == 0)
                .filter(p -> p.getPrice() > 15)
                .sorted((e1,e2) -> e2.getName().compareTo(e1.getName()))
                .limit(1)
                .forEach(ele -> System.out.println(ele.getName().toUpperCase()));
    }
}
