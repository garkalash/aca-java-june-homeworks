package collections.exercise3.lessons;

import collections.exercise3.Students;

import java.util.ArrayList;
import java.util.Comparator;


public class Physics extends Lesson implements Comparator<Students> {


    public Physics(String lessonName) {
        super(lessonName);
        students = new ArrayList<>();
    }

    public int compare(Students student1, Students student2) {
        return student2.getPhysicsLessonCount() - student1.getPhysicsLessonCount();
    }


}
