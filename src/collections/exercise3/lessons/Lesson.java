package collections.exercise3.lessons;


import collections.exercise3.Students;

import java.util.List;

public class Lesson {

    public List<Students> students;
    private String lessonName;

    public Lesson(String lessonName) {
        this.lessonName = lessonName;

    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }


}
