package com.aca.armine.collections.mylinkedlist;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<Integer> list =new MyLinkedList<>();
        System.out.println(list.isEmpty());
        list.add(15);
        list.add(25);
        list.add(20);
        list.add(35);
        list.add(55);
        list.add(20);
        System.out.println( list.get(2));
        list.remove(2);
        System.out.println(list.isEmpty());

        System.out.println(list.toString());

    }


}
