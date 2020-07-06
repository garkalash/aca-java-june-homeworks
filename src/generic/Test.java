package generic;

import java.util.ArrayList;
import java.util.Stack;

public class Test {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 28; i++) {
            list.add(i);
        }

        Stack<Integer> stack = GenericExercise.pushAll(list);
        System.out.println(stack.toString());
        GenericExercise.popAll(stack);

    }
}

