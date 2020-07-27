package homework4;

public class MyLinkedList<T> {
    MyNode<T> myFirstNode;

    public void add(MyNode<T> newNode) {
        if (myFirstNode == null) {
            myFirstNode = newNode;
        } else {
            MyNode<T> curNode = this.myFirstNode;
            while (curNode.nextNode != null) {
                curNode = curNode.nextNode;
            }
            newNode.prevNode = curNode;
            curNode.nextNode = newNode;
        }
    }

    public void remove(int index) throws IndexOutOfBoundsException {
        MyNode<T> curNode = this.myFirstNode;
        while (curNode != null) {
            if (index == 0) {
                MyNode<T> tmpNode = curNode;
                curNode.prevNode.nextNode = curNode.nextNode;
                tmpNode.nextNode.prevNode = tmpNode.prevNode;
            }
            index--;
            curNode = curNode.nextNode;
        }

        if (index > 0) {
            throw new IndexOutOfBoundsException("There are no element with that index\n");
        }
    }

    public MyNode<T> get(int index) throws IndexOutOfBoundsException {
        MyNode<T> curNode = this.myFirstNode;
        while (curNode != null) {
            if (index == 0) {
               break;
            }

            index--;
            curNode = curNode.nextNode;
        }

        if (index > 0) {
            throw new IndexOutOfBoundsException("There are no element with that index\n");
        }

        return curNode;
    }

    public void print() {
        MyNode<T> curNode = this.myFirstNode;
        while (curNode != null) {
            System.out.println(curNode.data);
            curNode = curNode.nextNode;
        }
    }
}
