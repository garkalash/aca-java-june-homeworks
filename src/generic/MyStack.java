package generic;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MyStack {
    public static <E> Stack<E> pushAll(List<? extends E> arrayList) {
        Stack<E> stack = new Stack<>();
        for (E e : arrayList) {
            if (stack.size() < 25) {
                stack.push(e);
            }
        }
        return stack;
    }

    public static <E> List<? super E> popAll(Stack<E> stack) {
        List<? super E> arrayList = new ArrayList<>();
        while (!stack.isEmpty()) {
            arrayList.add(stack.pop());
        }
        return arrayList;
    }


}






