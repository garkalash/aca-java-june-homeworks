package generics;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MyStack<Integer> myStack = new MyStack<>();
        myStack.push(1);
        myStack.push(22);
        myStack.push(333);
        myStack.push(444);
        myStack.push(555);
        myStack.push(666);

        System.out.println(myStack.pop());


        System.out.println(myStack.pop());
        System.out.println(myStack.isEmpty());

        List<Integer> pushItems = new ArrayList<>();
        pushItems.add(4);
        pushItems.add(5);
        pushItems.add(6);
        pushItems.add(7);
        myStack.pushAll(pushItems);

        List<Integer> popItems = myStack.popAll(4);
        for (Integer integer : popItems) {
            System.out.println(integer);
        }

        /*MyQueue*/

        MyQueue<String> myQueue = new MyQueue<>();
        myQueue.add("aaa");
        myQueue.add("bbb");
        myQueue.add("ccc");
        myQueue.add("ddd");
        System.out.println(myQueue.pop());
        System.out.println(myQueue.isEmpty());
        for (String s : myQueue.popAll(2)) {
            System.out.println(s);
        }
        List<String> addElements = new ArrayList<>();
        addElements.add("eee");
        addElements.add("fff");
        addElements.add("ggg");
        myQueue.addAll(addElements);

        for (String s : myQueue.popAll(7)) {
            System.out.println(s);
        }


    }
}
