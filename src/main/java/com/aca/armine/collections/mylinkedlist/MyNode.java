package com.aca.armine.collections.mylinkedlist;


public class MyNode<T>  {

    private T data;
   private MyNode<T> nextNode;

    public MyNode(T data, MyNode<T> nextNode) {
        this.data = data;
        this.nextNode = nextNode;
    }

    public T getData() {
        return data;
    }

    public MyNode<T> getNextNode() {
        return nextNode;
    }

    public void setNextNode(MyNode<T> nextNode) {
        this.nextNode = nextNode;
    }
}
