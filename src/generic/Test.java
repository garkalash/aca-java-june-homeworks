package generic;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {


        MyCollection<Integer> stack = new MyStack<>();
        MyCollection<Integer> queue = new MyQueue<>();

        System.out.println(stack.isEmpty() + "    " + queue.isEmpty());

        for (int i = 0; i < 5; i++) {
            stack.push(i);
            queue.push(i);
        }
        System.out.println(stack.isEmpty() + " : " + stack.toString());
        System.out.println(queue.isEmpty() + " : " + queue.toString());

        System.out.println(stack.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());

        System.out.println(stack.toString());
        System.out.println(queue.toString());

        List<Integer> list = new ArrayList<>();

        for (int i = 10; i < 20; i++) {
            list.add(i);
        }

        stack.pushAll(list);
        System.out.println(stack.toString());
        queue.pushAll(list);
        System.out.println(queue.toString());
        MyCollection<Integer> stack1 = new MyStack<>();
        MyCollection<Integer> queue1 = new MyQueue<>();

        stack.popAll(stack1);
        System.out.println(stack.isEmpty());
        System.out.println(stack1.toString());

        queue.popAll(queue1);
        System.out.println(queue.isEmpty());
        System.out.println(queue1.toString());

    }
}
