package com.aca.armine.collections;


import java.util.*;

public class Ex1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter sentence");
        String sentence = scanner.nextLine();
        String[] strings = sentence.split("\\s+");
        List<String> stringList = new ArrayList<>(Arrays.asList(strings));
        Map<String, Integer> map = new HashMap<>();
        for (String s : stringList) {
            if (!map.containsKey(s)) {
                map.put(s, 1);
            } else {
                map.put(s, map.get(s) + 1);
            }
        }
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(map.entrySet());
        entryList.sort(Map.Entry.comparingByValue());
        System.out.println(entryList.get(entryList.size()-1).getKey() + "  " + entryList.get(entryList.size()-1).getValue() );
        for (int i = entryList.size() - 2; i >= 0; i--) {
            if(entryList.get(i).getValue().equals(entryList.get(entryList.size() - 1).getValue())){
            System.out.println(entryList.get(i).getKey() + "  " + entryList.get(i).getValue() );
            } else break;
        }

    }


}
