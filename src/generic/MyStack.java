package generic;

import java.util.Arrays;
import java.util.List;


public class MyStack<T> {

    private Object[] elements;
    private int pointer;

    public MyStack() {
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

    public void push(T element) {
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
            elements[pointer + 1] = null;
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
        Object[] arr = new Object[elements.length - 1 - pointer];
        int j = 0;
        for (int i = elements.length - 1; i > pointer; i--) {
            arr[j] = elements[i];
            j++;
        }
        return "MyStack{" +
                Arrays.toString(arr) +
                '}';
    }

    public void pushAll(List<? extends T> arrayList) {
        int l = arrayList.size();
        if (l > elements.length) {
            increaseArray(elements, l);
            pointer = pointer + l;
        }
        for (T t : arrayList) {
            push(t);
        }
    }

    public void popAll(MyStack<T> stack) {
        while (!stack.isEmpty()) {
            stack.pop();
        }
    }


}






