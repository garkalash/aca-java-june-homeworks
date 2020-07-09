package generic;

import java.util.*;

public class MyQueue {

    @SafeVarargs
    public static <T> void addItems(Queue<? super T> queue, T... items) {
        int x = items.length;
        for (int i = 0; i < x; i++) {
            queue.add(items[i]);
        }
    }

    public static <T> void addItem(Queue<T> queue, T item) {
        queue.add(item);

    }

    public static <T> T popItem(Queue<T> queue) {
        return queue.poll();
    }

    public static <T> boolean isEmptyQueue(Queue<T> queue) {
        return queue.isEmpty();
    }

    public static <T> Queue<T> addAll(List<? extends T> list) {
        return new LinkedList<>(list);
    }

    public static <T> List<? super T> popAll(Queue<T> queue) {
        List<? super T> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            list.add(queue.poll());
        }
        return list;
    }

}
