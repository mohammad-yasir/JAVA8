package com.company.functionalInterfaces;

import java.util.Locale;
import java.util.function.Consumer;

public class ConsumerExample {
    public static void main(String[] args) {
        Consumer<String> c = (s) -> System.out.println(s.toUpperCase(Locale.ROOT));
        c.accept("hello world");

    }
}
