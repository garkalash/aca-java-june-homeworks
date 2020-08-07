package com.aca.armine.generic;

import java.util.Arrays;
import java.util.List;

public abstract class MyCollection<E> {

    private Object[] elements;
    private int pointer;
    public static final int defaultLength = 10;

    public MyCollection() {
        elements = new Object[defaultLength];
        pointer = elements.length - 1;
    }

    public Object[] getElements() {
        return elements;
    }

    public int getPointer() {
        return pointer;
    }

    public void setPointer(int pointer) {
        this.pointer = pointer;
    }

    public abstract E pop();

    public abstract void popAll(MyCollection<E> stack);

    private void increaseArray(Object[] arr, int extraLength) {
        Object[] newArray = new Object[arr.length + extraLength];
        for (int i = 0; i < arr.length; i++) {
            newArray[i + extraLength] = arr[i];
        }
        elements = newArray;
    }

    public void push(E element) {
        if (pointer < 0) {
            pointer = pointer + elements.length;
            increaseArray(elements, elements.length);
        }
        elements[pointer] = element;
        pointer -= 1;
    }


    public boolean isEmpty() {
        boolean isEmpty = false;
        if (pointer == elements.length - 1) {
            isEmpty = true;
        }
        return isEmpty;
    }

    public void pushAll(List<? extends E> arrayList) {
        int extraLength = arrayList.size();
        if (extraLength > elements.length) {
            increaseArray(elements, extraLength);
            pointer = pointer + extraLength;
        }
        for (E e : arrayList) {
            push(e);
        }
    }

    public String toString() {
        Object[] arr = new Object[elements.length - 1 - pointer];
        int j = 0;
        for (int i = elements.length - 1; i > pointer; i--) {
            arr[j] = elements[i];
            j++;
        }
        return "{" +
                Arrays.toString(arr) +
                '}';
    }
}
