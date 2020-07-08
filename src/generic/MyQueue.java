package generic;

import java.util.*;

public class MyQueue {
    public static  <T> Queue<T> addAll(List<? extends T> list){
        return new LinkedList<>(list);
    }

    public static <T> void popAll (Queue<T> queue, List<? super T> list  ){
        while (!queue.isEmpty()){
            list.add(queue.poll());
        }
    }

}
