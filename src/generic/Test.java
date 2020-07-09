package generic;

import java.util.*;

public class Test {

    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            integerList.add(i);
        }
        List<String> stringList = new ArrayList<>();
        stringList.add("A");
        stringList.add("C");
        stringList.add("B");
        stringList.add("E");
        stringList.add("D");

        Stack<Integer> integerStack = MyStack.pushAll(integerList);
        System.out.println(integerStack.toString());
        System.out.println( MyStack.popAll(integerStack).toString());
        Stack<String> stringStack = MyStack.pushAll(stringList);
        System.out.println(stringStack.toString());
        System.out.println( MyStack.popAll(stringStack).toString());
        Queue<String> stringQueue = MyQueue.addAll(stringList);
        System.out.println(stringQueue.toString());
        Queue<Integer> integerQueue = MyQueue.addAll(integerList);
        System.out.println((integerQueue.toString()));
        System.out.println(MyQueue.popAll(stringQueue).toString());
        System.out.println( MyQueue.popAll(integerQueue).toString());
        MyQueue.addItems(stringQueue, "A", "B");
        System.out.println(stringQueue.toString());

    }
}

