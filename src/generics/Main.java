package generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
//        MyStack<Integer> myStack = new MyStack<>();
//        myStack.push(1);
//        myStack.push(22);
//        myStack.push(333);
//        myStack.push(444);
//        myStack.push(555);
//        myStack.push(666);
//
//
//        System.out.println(myStack.isEmpty());
//        System.out.println(myStack.pop());
//        System.out.println(myStack.pop());
//        List<Integer> pushList = Arrays.asList(1, 2, 3);
//        myStack.pushAll(pushList);
//        Integer[] popList = new Integer[15];
//        popList = myStack.popAll(popList);
//        for (Integer integer : popList) {
//            System.out.println(integer);
//        }




        /*MyQueue*/
        MyQueue<String> myQueue = new MyQueue<>();
        myQueue.add("aaa");
        myQueue.add("bbb");
        myQueue.add("ccc");
        myQueue.add("ddd");
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());

        System.out.println(myQueue.isEmpty());
        String[] popListQueue = new String[15];
        popListQueue = myQueue.popAll(popListQueue);
        for (String s : popListQueue) {
            System.out.println(s);
        }
        List<String> addingList = Arrays.asList("eee","FFF","ggg");
        myQueue.addAll(addingList);
    }
}

