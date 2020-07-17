package collections.exercise3;

import collections.exercise3.lessons.Lesson;

import java.util.*;

public class Students {

    private String name;
    private List<Lesson> lessons;
    private Integer mathLessonCount;
    private Integer artLessonCount;
    private Integer englishLessonCount;
    private Integer physicsLessonCount;



    public Students(String name) {
        this.name = name;
        lessons = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Integer getMathLessonCount() {
        return mathLessonCount;
    }

    public void setMathLessonCount(Integer mathLessonCount) {
        this.mathLessonCount = mathLessonCount;
    }

    public Integer getArtLessonCount() {
        return artLessonCount;
    }

    public void setArtLessonCount(Integer artLessonCount) {
        this.artLessonCount = artLessonCount;
    }

    public Integer getEnglishLessonCount() {
        return englishLessonCount;
    }

    public void setEnglishLessonCount(Integer englishLessonCount) {
        this.englishLessonCount = englishLessonCount;
    }

    public Integer getPhysicsLessonCount() {
        return physicsLessonCount;
    }

    public void setPhysicsLessonCount(Integer physicsLessonCount) {
        this.physicsLessonCount = physicsLessonCount;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    @Override
    public String toString() {
        return "Students{" +
                "name='" + name + '\'' +
                ", mathLessonCount=" + mathLessonCount +
                ", artLessonCount=" + artLessonCount +
                ", englishLessonCount=" + englishLessonCount +
                ", physicsLessonCount=" + physicsLessonCount +
                '}';
    }
}


