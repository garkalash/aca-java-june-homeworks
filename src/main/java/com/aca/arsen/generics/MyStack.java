package com.aca.arsen.generics;

import java.util.List;
import java.util.logging.Logger;

public class MyStack<T> {
    private T myarray[];
    private final Integer size;
    private Integer top = 0;
    Logger logger = Logger.getGlobal();

    public MyStack(Integer size) {
        this.size = size;
        myarray = (T[]) new Object[size];
    }

    public void printstack () {

        for (T t : myarray) {
            if (t != null) {
                System.out.print(t + " ");
            }
        }
        System.out.println();
        logger.info("Stack printed");

    }

    public void push(T item)
    {
        if(top == myarray.length)
        {
            myarray = increaseArrayLenght();
            push(item);
            return;
        }
        myarray[top] = item;
        top++;
        logger.info("Item added to stack");
    }


    public void pop() throws ArrayIndexOutOfBoundsException
    {
        if(isEmpty()) throw new ArrayIndexOutOfBoundsException("Stack is empty, nothing to pop");
        for (int i = 1; i < myarray.length; i++) {
            if(myarray[i]==null)
            {
                myarray[i-1] = null;
                top--;
                logger.info("Item popped");
                return;
            }
        }
    }

    public boolean isEmpty()
    {
        return (top == 0);
    }

    public void pushAll (List<? extends T> list)
    {
        if(myarray.length >= list.size()) {
            for (int i = 0; i < list.size(); i++) {
                push(list.get(i));
                logger.info("PushAll completed");
            }
        }
        else {
            myarray = increaseArrayLenght();
            pushAll(list);
        }
    }

    public void popAll (MyStack<? super T> newstack) throws ArrayIndexOutOfBoundsException
    {
        if(isEmpty()) throw new ArrayIndexOutOfBoundsException("Stack is empty, nothing to pop");
            for(int i=0;i<myarray.length;i++)
            {
                if(i>=newstack.myarray.length)
                {
                    newstack.myarray = increaseArrayLenght();
                }
                newstack.myarray[i] = myarray[i];
            }
            while(top>0)
            {
                pop();
            }

    }

    private T[] increaseArrayLenght ()
    {
        T newarray[] = (T[])new Object[myarray.length*2];
        System.arraycopy(myarray, 0, newarray, 0, myarray.length);
        return newarray;
    }

}

