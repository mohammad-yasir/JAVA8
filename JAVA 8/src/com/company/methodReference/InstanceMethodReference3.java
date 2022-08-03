package com.company.methodReference;

import java.util.function.BiFunction;
class InstMethodReference3{
    public int add(int a, int b){
        return a+b;
    }
}
public class InstanceMethodReference3 {
    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer>adder = new InstMethodReference3()::add;
        int result = adder.apply(10, 20);
        System.out.println(result);
    }
}  