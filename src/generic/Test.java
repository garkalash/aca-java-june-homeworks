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

        List<Number> numberList = new ArrayList<>();
        MyStack.popAll(integerStack, numberList);
        System.out.println(numberList.toString());

        Stack<String> stringStack = MyStack.pushAll(stringList);
        System.out.println(stringStack.toString());

        List<String> list2 = new ArrayList<>();
        MyStack.popAll(stringStack, list2);
        System.out.println(list2.toString());


        Queue<String> stringQueue = MyQueue.addAll(stringList);
        System.out.println(stringQueue.toString());


        Queue<Integer> integerQueue = MyQueue.addAll(integerList);
        System.out.println((integerQueue.toString()));

        List<Object> list1 = new ArrayList<>();
        MyQueue.popAll(stringQueue, list1);
        System.out.println(list1.toString());

        MyQueue.popAll(integerQueue, list1);
        System.out.println(list1.toString());

    }
}

