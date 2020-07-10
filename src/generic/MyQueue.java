package generic;

import java.util.*;

public class MyQueue<E> {

    private Object[] elements;
    private int pointer;


    public MyQueue() {
        elements = new Object[5];
        pointer = elements.length - 1;
    }

    private void increaseArray(Object[] arr, int l) {
        Object[] newArray = new Object[arr.length + l];
        for (int i = 0; i < arr.length; i++) {
            newArray[i + arr.length] = arr[i];
        }
        elements = newArray;
    }

    private void shift(Object[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
    }


    public void push(E element) {
        if (pointer < 0) {
            pointer = pointer + elements.length;
            increaseArray(elements, elements.length);
        }
        elements[pointer] = element;
        pointer -= 1;
    }

    public void pop() {
        if (isEmpty()) {
            throw new EmptyCollectionException();

        } else {
            elements[elements.length - 1] = null;
            shift(elements);
            pointer += 1;
        }
    }


    public boolean isEmpty() {
        boolean isEmpty = false;
        if (pointer == elements.length - 1) {
            isEmpty = true;
        }
        return isEmpty;
    }

    @Override
    public String toString() {
        Object arr[] = new Object[elements.length - 1 - pointer];
        int j = 0;
        for (int i = elements.length - 1; i > pointer; i--) {
            arr[j] = elements[i];
            j++;
        }
        return "MyQueue{" +
                Arrays.toString(arr) +
                '}';
    }

    public void pushAll(List<? extends E> arrayList) {
        int l = arrayList.size();
        if (l > elements.length) {
            increaseArray(elements, l);
            pointer = pointer + l;
        }
        for (E e : arrayList) {
            push(e);
        }
    }

    public void popAll(MyQueue<E> queue) {
        if (isEmpty()) {
            throw new EmptyCollectionException();
        }
        while (!queue.isEmpty()) {
            elements[elements.length - 1] = null;
            pointer += 1;
        }
    }

}
