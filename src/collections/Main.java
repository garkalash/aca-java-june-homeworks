package collections;

import java.util.*;

public class Main {


    public static void main(String[] args) {

        String sentence = "Aaa bb ghk bb Aaa bb klt";
        Map<String, Integer> repeatStrings = findRepeats(sentence);
        for (int i = 0; i < repeatStrings.size(); i++) {
            System.out.println(repeatStrings);
        }



        Student st3 = new Student(Arrays.asList("l1","l2","l3","l4","l5"),"Mary");
        Student st1 = new Student(Arrays.asList("l1","l2","l3"),"Jack");
        Student st2 = new Student(Arrays.asList("l1","l2","l3","l4"),"John");
        Comparator<List<String>> studentComparator = new  Comparator<List<String>>() {
            @Override
            public int compare(List<String> student1, List<String> student2) {
                return student1.size()-student2.size();
            }

        };
        Map<List<String>,String> studentsAndLessons = new TreeMap<>(studentComparator);
        studentsAndLessons.put(st1.getLessons(),st1.getName());
        studentsAndLessons.put(st2.getLessons(),st2.getName());
        studentsAndLessons.put(st3.getLessons(),st3.getName());
        System.out.println(studentsAndLessons);;
    }

    public static Map<String, Integer> findRepeats(String sentence) {

        int count = 0;
        Map<String, Integer> repeatStrings = new HashMap<>();
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            int thisCount = 0;
            for (int i1 = 0; i1 < words.length; i1++) {

                if (words[i].equals(words[i1])) {
                    thisCount++;
                }
            }
            if (thisCount > count) {
                repeatStrings.clear();
                repeatStrings.put(words[i], thisCount);
                count = thisCount;
            } else if (thisCount == count) {
                repeatStrings.put(words[i], thisCount);
            }
        }
        return repeatStrings;
    }

    public static Map<List<String>, String> studentLIst(){

        return null;
    }

}
