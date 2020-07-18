package com.aca.naresilanyan.collectionHomework;

import java.util.*;

public class Student {
    private String name;
    private Map<String,Integer> lessonsGrades;


    public Student(String name, Map<String, Integer> lessonsGrades) {
        this.name = name;
        this.lessonsGrades = lessonsGrades;
    }

    public String getName() {
        return name;
    }

    public Map<String, Integer> getLessonsGrades() {
        return lessonsGrades;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return name.equals(student.name) &&
                lessonsGrades.equals(student.lessonsGrades);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lessonsGrades);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", lessonsGrades=" + lessonsGrades +
                '}';
    }
}
