package generics;
import java.util.ArrayList;
import java.util.List;

public class MyQueue<V> {
    private List<V> items  = new ArrayList<>();
    private static int popId = -1;

    public void add(V item){
        items.add(item);
    }

    public V pop(){
        if (popId+1 == items.size()){
            System.out.println("Queue is empty");
            return null;
        }else {
            popId++;
            return items.get(popId);
        }
    }

    public boolean isEmpty(){
        return items.size() == 0;
    }

    public List<V> popAll(int countOfItems){
        if (items.size()==0){
            System.out.println("Stack is empty");
            return null;
        } else if(countOfItems>items.size()){
            System.out.println("No so many elements");
            return null;
        } else {
            List<V> popElements = new ArrayList<>();
            for (int i = 0; i < countOfItems; i++) {
                popId++;
                popElements.add(items.get(i));

            }
            return popElements;
        }
    }

    public void addAll(List<V> elements){
        for (V element : elements) {
            items.add(element);
        }
    }



}
