package generics;

import java.util.ArrayList;
import java.util.List;

public class MyStack<T> {
    private List<T> items  = new ArrayList<>();
    private static int popId = 0;

    public void push(T item){
        items.add(item);
        popId++;
    }

    public T pop(){
        if (popId==0){
            System.out.println("Stack is empty");
            return null;
        }else {
            popId--;
            return items.get(popId);
        }
    }

    public boolean isEmpty(){
        return items.size() == 0;
    }

    public List<T> popAll(int countOfItems){
        if (items.size()==0){
            System.out.println("Stack is empty");
            return null;
        } else if(countOfItems>items.size()){
            System.out.println("No so many elements");
            return null;
        } else {
            int sizeOflist = items.size()-1;
            List<T> popElements = new ArrayList<>();
            for (int i = sizeOflist,f=0; i >= 0; i--,f++) {
                if(f==countOfItems){
                    break;
                }
                popId--;
                popElements.add(items.get(i));

            }
            return popElements;
        }
    }

    public void pushAll(List<T> elements){
        for (T element : elements) {
            items.add(element);
        }
    }


}
