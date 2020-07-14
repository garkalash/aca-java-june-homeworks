package generics;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

public class MyStack<T> {
    private Logger logger =Logger.getGlobal();
    private T[] items = (T[]) new Object[15];
    private int lastPosition = 0;



    public void push(T item) {
        if (lastPosition==items.length-1){
            logger.info("Stack is full");
        }else{
            items[lastPosition]=item;
            lastPosition++;
        }

    }
@SuppressWarnings("unchecked")
    public T pop() {
        if (lastPosition == 0) {
            logger.warning("Stack is empty");
            return null;
        } else {
            lastPosition--;
            return (T)items[lastPosition];
        }
    }

    public boolean isEmpty() {
        return lastPosition == 0;
    }


    public void pushAll(List<? extends T> elements) {
        for (int i = 0; i < elements.size(); i++) {
            if (lastPosition==items.length-1){
                logger.info("Stack is full");
                break;
            }else{
                items[lastPosition]=elements.get(i);
                lastPosition++;
            }
        }
    }

        public T[] popAll(T[] dst) {

            int size = lastPosition;
            for (int i = 0; i < size; i++) {
                if (lastPosition==0){
                    break;
                }
                dst[i] =  items[lastPosition-1];
                lastPosition--;
            }
        return dst;
    }




}
