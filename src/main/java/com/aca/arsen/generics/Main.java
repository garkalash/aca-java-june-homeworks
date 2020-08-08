package com.aca.arsen.generics;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getGlobal();
        List<Integer> list1 = new ArrayList<Integer>();
        list1.add(1);
        list1.add(4);
        list1.add(20);
        list1.add(32);
        MyStack<Number> stack1 = new MyStack<Number>(5);
        System.out.println(stack1.isEmpty());
        stack1.push(41);
        stack1.push(52);
        stack1.push(63);
        System.out.println(stack1.isEmpty());
        stack1.printstack();
        stack1.pop();
        stack1.pushAll(list1);
        stack1.printstack();
        MyStack<Number> stack2 = new MyStack<Number>(5);
        stack1.popAll(stack2);
        stack2.printstack();
        stack1.printstack();
        MyQueue<Number> q1 = new MyQueue<>(8);
        MyQueue<Number> q2 = new MyQueue<>(4);
        logger.info(String.valueOf(q1.isEmpty()));
        q1.add(5);
        q1.add(6);
        q1.add(7);
        q1.add(8);
        q1.add(9);
        q1.add(10);
        logger.info(String.valueOf(q1.isEmpty()));
        q1.printqueue();
        q1.pop();
        q1.printqueue();
        q1.popAll(q2);
        q2.printqueue();
        q1.printqueue();
    }
}
