package com.aca.naresilanyan.genericsHomework;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        MyQueue<Number> queue1 = new MyQueue();
        queue1.add(1);
        queue1.add(2);
        queue1.add(3);
        System.out.println(queue1.toString());

//        Object [] k = new Object[10];
//        System.out.println(k.length);



        System.out.println(queue1.pop());
        System.out.println(queue1.pop());
        System.out.println(queue1.toString());



        List<Integer> integers1 = new ArrayList<>(){{
            add(5);
            add(6);
            add(7);

        }};
        queue1.addAll(integers1);

        System.out.println(queue1.toString());

//        System.out.println(queue1.pop());
//        System.out.println(queue1.pop());




        List<Serializable> number2 = new ArrayList<>();


        queue1.popAll(number2);
        System.out.println(queue1.toString());

        System.out.println(Arrays.toString(number2.toArray()));









    }
}
