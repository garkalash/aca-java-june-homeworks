package generic;

import java.util.*;

public class Test {

    public static void main(String[] args) {

        MyQueue<Integer> queue = new MyQueue<>();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.println(queue.toString());
        queue.pop();
        System.out.println(queue.toString());
        queue.isEmpty();
        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(5);
        list.add(6);
        queue.pushAll(list);
        System.out.println(queue.toString());
        queue.popAll(queue);
        System.out.println(queue.toString());

        MyStack<Integer> stack = new MyStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.isEmpty());
        System.out.println(stack.toString());
        stack.pop();
        System.out.println(stack.toString());
        stack.pushAll(list);
        System.out.println(stack.toString());
        stack.popAll(stack);
        System.out.println(stack.toString());
        System.out.println(stack.isEmpty());

    }
}

