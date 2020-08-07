package com.aca.naresilanyan.genericsHomework;

import java.util.Arrays;
import java.util.List;

public class MyQueue<T> {

    private Object[] data;
    private static final Integer capacity = 10;
    public   Integer currentCapacity =0;
//    private static Integer indexOfPoppedElement = 1;

    public MyQueue() {
         data= new Object[capacity];
    }

    public void add(T value){
        if (currentCapacity == capacity-1) throw new RuntimeException("Is Full");
        currentCapacity = currentCapacity +1;
        data[currentCapacity-1] = value;

    }

    public T pop(){
        Object[]temp = new Object[capacity];
        T popedItem;
        if (currentCapacity == -1) throw new RuntimeException("Is Empty");
        currentCapacity = currentCapacity -1;
        for(int i = 0; i<data.length-1; i++){
                temp[i] = data[i+1];

        }
        popedItem=(T)data[0];
        data = temp;


        return popedItem ;

    }

    public Boolean isEmpty(){
        if (currentCapacity == 0){
            return true;

        }else {
            return false;
        }
    }

    public void addAll(List<? extends T> dst){
        for(T i: dst){
            add(i);
        }

    }

    public void popAll(List<? super T> dst){
        while (!isEmpty()) {
            dst.add(pop());
        }

    }

    @Override
    public String toString() {
        return "MyQueue{" +
                "data=" + Arrays.toString(data) +
                '}';
    }
}
