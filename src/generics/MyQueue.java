package generics;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class MyQueue<V> {

    private Logger logger = Logger.getGlobal();
    private V[] items = (V[]) new Object[15];
    private int lastPosition = 0;


    public void add(V item) {
        if (lastPosition == items.length - 1) {
            logger.info("Queue is full");
        } else {
            items[lastPosition] = item;
            lastPosition++;
        }

    }

    public V pop() {
        if (lastPosition == 0) {
            logger.info("Queue is empty");
            return null;
        } else {

            lastPosition--;
            V returnItem = items[0];
            for (int i = 0; i <= lastPosition; i++) {
                items[i] = items[i + 1];
            }
            return returnItem;
        }

    }

    public boolean isEmpty() {
        return lastPosition == 0;
    }

    public V[] popAll(V[] dst) {
        int lenght = lastPosition;
        for (int i = 0; i < lenght; i++) {
            if (lastPosition == 0) {
                return null;
            }
            dst[i] = items[i];
            lastPosition--;
        }
        return dst;
    }

    public void addAll(List<? extends V> list) {
        for (int i = 0; i < list.size(); i++) {
            if (lastPosition == items.length - 1) {
                logger.info("Queue is full");
                break;
            } else {
                items[lastPosition] = list.get(i);
                lastPosition++;
            }

        }

    }

}
