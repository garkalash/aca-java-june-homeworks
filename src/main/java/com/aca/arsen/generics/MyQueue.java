package com.aca.arsen.generics;

import java.util.List;
import java.util.logging.Logger;

public class MyQueue<T> {
    private T[] myQueue;
    private final Integer size;
    private Integer top = 0;
    Logger logger = Logger.getGlobal();

    public MyQueue(Integer size)
    {
        this.size = size;
        myQueue =  (T[]) new Object[size];
    }

    public boolean isEmpty()
    {
        return (top == 0);
    }

    public void add (T item)
    {
        if(top == myQueue.length)
        {
            myQueue = increaseQueueLenght();
            add(item);
            return;
        }
        myQueue[top] = item;
        top++;
        logger.info("Item added to stack");
    }

    public void pop() throws ArrayIndexOutOfBoundsException
    {
        if(isEmpty()) throw new ArrayIndexOutOfBoundsException("Queue is empty, nothing to pop");
        for (int i = 0; i < myQueue.length-1; i++) {
            myQueue[i] = myQueue[i + 1];
        }
        top--;
        logger.info("Item popped");

    }

    public void addAll (List<? extends T> list)
    {
        if(myQueue.length >= list.size()) {
            for (int i = 0; i < list.size(); i++) {
                add(list.get(i));
                logger.info("PushAll completed");
            }
        }
        else {
            myQueue = increaseQueueLenght();
            addAll(list);
        }
    }

    public void popAll (MyQueue<? super T> newQueue) throws ArrayIndexOutOfBoundsException
    {
        if(isEmpty()) throw new ArrayIndexOutOfBoundsException("Stack is empty, nothing to pop");
        for(int i=0;i<myQueue.length;i++)
        {
            if(i>=newQueue.myQueue.length)
            {
                newQueue.myQueue = increaseQueueLenght();
            }
            newQueue.myQueue[i] = myQueue[i];
        }
        while(top>0)
        {
            pop();
        }

    }

    public void printqueue ()
    {
        for (T t : myQueue) {
            if (t != null) {
                System.out.print(t + " ");
            }
        }
        System.out.println();
        logger.info("Queue printed");
    }


    private T[] increaseQueueLenght ()
    {
        T newQueue[] = (T[])new Object[myQueue.length*2];
        System.arraycopy(myQueue, 0, newQueue, 0, myQueue.length);
        return newQueue;
    }

}
