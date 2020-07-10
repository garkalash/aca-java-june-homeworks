package stack;

import exceptions.MemoryOutOfBounds;

import java.util.EmptyStackException;
import java.util.List;
/*
 * Implementation via array
 */
public class MyStack<T> {
    private T arr[];
    private Integer size = 1;
    private Integer currentEmptyIndex = 0;

    public MyStack() {
        this.arr = (T[]) new Object[size];
    }

    public Integer getSize() {
        return currentEmptyIndex;
    }

    private T[] copyArrayAndRaiseSize() {
        T[] arr1 = (T[]) new Object[size + 1];
        for (int i = 0; i < size; ++i) {
            arr1[i] = arr[i];
        }
        size++;
        return arr1;
    }

    public void push(T item) {
        this.arr = copyArrayAndRaiseSize();

        for (int i = currentEmptyIndex; i > 0; --i) {
            arr[i] = arr[i - 1];
        }

        arr[0] = item;
        currentEmptyIndex++;
    }

    private T[] copyArrayAndDecreaseSize() {
        T[] arr1 = (T[]) new Object[size - 1];
        for (int i = 0; i < size - 1; ++i) {
            arr1[i] = arr[i];
        }
        size--;
        return arr1;
    }

    public T pop() throws MemoryOutOfBounds {

        if (this.size == 0) {
            throw new MemoryOutOfBounds("Stack is empty\n");
        }

        T retVal = arr[0];
        for (int i = 0; i < size - 1; ++i) {
            arr[i] = arr[i + 1];
        }
        currentEmptyIndex--;
        this.arr = copyArrayAndDecreaseSize();
        return retVal;
    }

    public boolean isEmpty() {
        return this.size == 0 ? true : false;
    }

    public void print() {
        for (int i = 0; i < currentEmptyIndex; ++i)
            System.out.print(this.arr[i] + " ");

        System.out.println();
    }

    public void pushAll(List<? extends T> list) {
        for (int i = 0; i < list.size(); ++i) {
            this.push(list.get(i));
        }
    }

    public void popAll(List<? super T> it) {
        while (!isEmpty())
            it.add(this.pop());
    }
}
