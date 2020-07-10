import queue.MyQueue;
import stack.MyStack;

import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        System.out.println("Stack testing");
        MyStack<Number> stackNumber = new MyStack<>();
        stackNumber.push(1);
        stackNumber.push(2);
        stackNumber.push(3);
        System.out.println("Number stack before pop");
        stackNumber.print();
        stackNumber.pop();
        System.out.println("Number stack after pop");
        stackNumber.print();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(5);
        stackNumber.pushAll(list);
        System.out.println("Number stack after pushAll(4, 5)");
        stackNumber.print();

        System.out.println("Queue testing");
        MyQueue<Number> queueNumber = new MyQueue<>();
        queueNumber.push(1);
        queueNumber.push(2);
        queueNumber.push(3);
        System.out.println("Number stack before pop");
        queueNumber.print();
        queueNumber.pop();
        System.out.println("Number stack after pop");
        queueNumber.print();
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(4);
        list1.add(5);
        queueNumber.pushAll(list1);
        System.out.println("Number stack after pushAll(4, 5)");
        queueNumber.print();
    }
}
