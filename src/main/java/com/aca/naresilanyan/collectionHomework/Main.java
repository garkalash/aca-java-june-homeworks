package com.aca.naresilanyan.collectionHomework;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Lesson lesson1 = new Lesson("Maths");
        Lesson lesson2 = new Lesson("Geometry");
        Lesson lesson3 = new Lesson("Geography");
        Lesson lesson4 = new Lesson("Art");
        Lesson lesson5 = new Lesson("Music");
        Lesson lesson6 = new Lesson("Science");


        Student student1  = new Student("Ann",
                Map.ofEntries(
                        Map.entry(lesson1.getName(),9),
                        Map.entry(lesson4.getName(),6),
                        Map.entry(lesson6.getName(),3)
                )
        );

        Student student2 = new Student("James",
                Map.ofEntries(
                        Map.entry(lesson2.getName(),10),
                        Map.entry(lesson4.getName(), 7),
                        Map.entry(lesson5.getName(), 5),
                        Map.entry(lesson6.getName(), 8)
                )
        );

        Student student3 = new Student("Jack",
                Map.ofEntries(
                        Map.entry(lesson3.getName(),4),
                        Map.entry(lesson4.getName(), 3),
                        Map.entry(lesson1.getName(), 8),
                        Map.entry(lesson5.getName(), 1)
                )
        );

        List<Student> students = new ArrayList(Arrays.asList(student1,student2,student3));

        //Sorting Students by average of grades

        Set<Map.Entry<Student,Double>> sortedStudents = new TreeSet<>(new Comparator<Map.Entry<Student, Double>>() {
            @Override
            public int compare(Map.Entry<Student, Double> o1, Map.Entry<Student, Double> o2) {
                return (int)(o2.getValue()-o1.getValue());
            }
        });


        for(Student st: students){

            List<Integer> grades = new ArrayList<>(st.getLessonsGrades().values());
            Double sum  = 0.;

            for(int i=0; i < grades.size(); i++){

                sum += grades.get(i);
            }
             Double average =  sum/grades.size();
            sortedStudents.add(Map.entry(st,average));

        }

        System.out.println(sortedStudents);












    }
}
