package homework4;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.add(new MyNode<>(0));
        myLinkedList.add(new MyNode<>(1));
        myLinkedList.add(new MyNode<>(2));
        myLinkedList.add(new MyNode<>(3));

        myLinkedList.print();

        myLinkedList.remove(2);

        myLinkedList.print();

        System.out.println(myLinkedList.get(0).data);
    }
}
