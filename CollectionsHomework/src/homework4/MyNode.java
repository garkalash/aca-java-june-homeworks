package homework4;

public class MyNode<T> {
    T data;
    MyNode<T> nextNode;
    MyNode<T> prevNode;

    MyNode(T data) {
        this.data = data;
        this.nextNode = null;
        this.prevNode = null;
    }
}
