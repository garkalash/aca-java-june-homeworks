package collections.exercise3.lessons;

import collections.exercise3.Students;

import java.util.ArrayList;
import java.util.Comparator;


public class English extends Lesson implements Comparator<Students> {


    public English(String lessonName) {
        super(lessonName);
        students = new ArrayList<>();
    }

    @Override
    public int compare(Students student1, Students student2) {
        return student2.getEnglishLessonCount() - student1.getEnglishLessonCount();
    }
}

