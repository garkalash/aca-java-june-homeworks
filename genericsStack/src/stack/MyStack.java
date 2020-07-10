package stack;

import exceptions.MemoryOutOfBounds;
import functionality.MyCollection;

import java.util.EmptyStackException;
import java.util.List;
/*
 * Implementation via array
 */
public class MyStack<T> implements MyCollection<T> {
    private T arr[];
    private Integer size = 0;
    private Integer capacity = 2 * size + 1;

    public MyStack() {
        this.arr = (T[]) new Object[capacity];
    }

    public Integer getSize() {
        return size;
    }

    private T[] copyArrayAndRaiseSize() {
        capacity = 2 * size;
        T[] arr1 = (T[]) new Object[capacity];
        for (int i = 0; i < size; ++i) {
            arr1[i] = arr[i];
        }
        return arr1;
    }

    public void push(T item) {
        if (size == capacity)
            this.arr = copyArrayAndRaiseSize();

        for (int i = size; i > 0; --i) {
            arr[i] = arr[i - 1];
        }

        arr[0] = item;

        size++;
    }

    private T[] copyArrayAndDecreaseSize() {
        capacity = size / 2 + 1;
        T[] arr1 = (T[]) new Object[capacity];
        for (int i = 0; i < size; ++i) {
            arr1[i] = arr[i];
        }

        return arr1;
    }

    public T pop() throws MemoryOutOfBounds {

        if (this.isEmpty()) {
            throw new MemoryOutOfBounds("Stack is empty\n");
        }

        T retVal = arr[0];
        for (int i = 0; i < size - 1; ++i) {
            arr[i] = arr[i + 1];
        }

        size--;
        if ((size * 4) < capacity)
            this.arr = copyArrayAndDecreaseSize();

        return retVal;
    }

    public boolean isEmpty() {
        return this.size == 0 ? true : false;
    }

    public void print() {
        for (int i = 0; i < size; ++i)
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
