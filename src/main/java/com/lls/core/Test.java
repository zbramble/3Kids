package com.lls.core;

import java.util.stream.Stream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        System.out.println("test");
        int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
        Arrays.stream(nums).boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toList())
                .forEach(System.out::println);
        System.out.println("test1");
    }
}
