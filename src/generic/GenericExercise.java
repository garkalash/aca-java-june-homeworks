package generic;


import java.util.ArrayList;
import java.util.Stack;

public class GenericExercise {
    public static <E> Stack<E> pushAll(ArrayList<E> arrayList) {
        Stack<E> stack = new Stack<>();
        for (E e : arrayList) {
            if (stack.size() < 25) {
                stack.push(e);
            }
        }
        return stack;
    }

    public static <E> void popAll(Stack<E> stack) {
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }


}






