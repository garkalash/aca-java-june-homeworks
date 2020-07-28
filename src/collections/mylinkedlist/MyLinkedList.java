package collections.mylinkedlist;

public class MyLinkedList<T> {
    private MyNode<T> head;

    public MyLinkedList() {
        head = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void add(T item) {
        if (isEmpty()) {
            head = new MyNode<>(item, head);
        } else {
            MyNode<T> currentNode = head;
            while (currentNode.getNextNode() != null) {
                currentNode = currentNode.getNextNode();
            }
            currentNode.setNextNode( new MyNode<T>(item, null));

        }
    }
    public void remove(Integer index) {
        if (isEmpty()) {
            throw new NullPointerException();
        }
        if (index == 0) {
            head = head.getNextNode();
            return;
        }
        MyNode<T> currentNode = head;
        MyNode<T> previousNode;
        Integer currentNodeIndex = 0;

        while (currentNode.getNextNode() != null) {
            previousNode = currentNode;
            currentNode = currentNode.getNextNode();
            currentNodeIndex += 1;
            if (index.equals(currentNodeIndex)) {
                if (currentNode.getNextNode() == null) {
                    previousNode.setNextNode(null);
                    return;
                }
                previousNode.setNextNode(currentNode.getNextNode());
                return;
            }
        }
        throw new IndexOutOfBoundsException();
    }

    public T get(Integer index) {
        if (isEmpty()) {
            throw new NullPointerException();
        }
        MyNode<T> currentNode = head;
        Integer currentNodeIndex = 0;
        while (currentNode != null) {
            if (index.equals(currentNodeIndex)) {
                return currentNode.getData();
            }
            currentNodeIndex += 1;
            currentNode = currentNode.getNextNode();
        }
        throw new IndexOutOfBoundsException();

    }

    @Override
    public String toString() {
        StringBuilder printList = new StringBuilder("{ " + head.getData());
        MyNode<T> currentNode = head.getNextNode();
        while (currentNode != null) {
            printList.append(", ").append(currentNode.getData());
            currentNode = currentNode.getNextNode();

        }
        return printList + " }";
    }
}