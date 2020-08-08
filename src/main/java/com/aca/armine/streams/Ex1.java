package com.aca.armine.streams;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Ex1 {
    public static void main(String[] args) {


        List<Integer> list = Arrays.asList(33, 56, 4, 78);
        List<String> stream = list.stream()
                .map(s -> s % 2 == 0 ? "e" + s : "o" + s)
                .collect(Collectors.toList());
        System.out.println(stream);
    }


}
