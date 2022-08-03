package com.company.lambdas;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorLambdaExample {
    public static void main(String[] args) {

        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };

        System.out.println("Result is :"+ comparator.compare(3,2));
        System.out.println("Result is :"+ comparator.compare(2,3));
        System.out.println("Result is :"+ comparator.compare(2,2));

        Comparator<Integer> comparator1 = (Integer a,Integer b ) ->a.compareTo(b);

        System.out.println("Result of comparator1 is : "+ comparator1.compare(3,2) );

        Comparator<Integer> comparator2 = ( a, b ) ->a.compareTo(b);

        System.out.println("Result of comparator2 is : "+ comparator2.compare(2,2));
    }
}
