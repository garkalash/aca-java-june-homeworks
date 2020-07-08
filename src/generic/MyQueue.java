package generic;

import java.util.*;

public class MyQueue {
    public static  <T> Queue<T> addAll(List<? extends T> list){
        return new LinkedList<>(list);
    }

    public static <T> List<? super T>   popAll (Queue<T> queue  ){
        List<? super T> list = new ArrayList<>();
        while (!queue.isEmpty()){
            list.add(queue.poll());
        }
        return list;
    }

}
