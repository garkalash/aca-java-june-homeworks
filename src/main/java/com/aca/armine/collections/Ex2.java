package com.aca.armine.collections;

import java.util.*;

public class Ex2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter sentence");
        String sentence = scanner.nextLine();
        String[] strings = sentence.split("\\s+");
        List<String> stringList = new ArrayList<>(Arrays.asList(strings));
        Map<String, Integer> map = new HashMap<>();
        for (String s : stringList) {
            map.put(s, 1);
        }
        Object[] newSentence = map.keySet().toArray();
        for (Object o : newSentence) {
            System.out.print(o +" ");
        }

    }
}
