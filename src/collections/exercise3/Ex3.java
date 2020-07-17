package collections.exercise3;

import collections.exercise3.lessons.*;
import collections.exercise3.lessons.Math;

import java.util.*;

public class Ex3 {
    public static void main(String[] args) {

        Math math = new Math("Math");
        English english = new English("English");
        Art art = new Art("Art");
        Physics physics = new Physics("Physics");


        Students students1 = new Students("Anna");
        students1.getLessons().add(math);
        students1.getLessons().add(english);
        students1.getLessons().add(art);
        students1.getLessons().add(physics);
        students1.setMathLessonCount(4);
        students1.setArtLessonCount(3);
        students1.setEnglishLessonCount(2);
        students1.setPhysicsLessonCount(3);

        Students students2 = new Students("Armen");
        students2.getLessons().add(math);
        students2.getLessons().add(english);
        students2.getLessons().add(art);
        students2.setMathLessonCount(5);
        students2.setArtLessonCount(6);
        students2.setEnglishLessonCount(4);

        Students students3 = new Students("Karen");
        students3.getLessons().add(math);
        students3.getLessons().add(english);
        students3.getLessons().add(art);
        students3.getLessons().add(physics);
        students3.setMathLessonCount(3);
        students3.setArtLessonCount(2);
        students3.setEnglishLessonCount(5);
        students3.setPhysicsLessonCount(6);

        Students students4 = new Students("Suren");
        students4.getLessons().add(math);
        students4.getLessons().add(english);
        students4.getLessons().add(physics);
        students4.setMathLessonCount(8);
        students4.setEnglishLessonCount(6);
        students4.setPhysicsLessonCount(7);

        List<Students> studentsList = new ArrayList<>();
        studentsList.add(students1);
        studentsList.add(students2);
        studentsList.add(students3);
        studentsList.add(students4);

        math.students.addAll(studentsList);
        math.students.removeIf(student -> student.getMathLessonCount() == null);
        Collections.sort(math.students, math);

        art.students.addAll(studentsList);
        art.students.removeIf(student -> student.getArtLessonCount() == null);
        Collections.sort(art.students, art);

        english.students.addAll(studentsList);
        english.students.removeIf(student -> student.getEnglishLessonCount() == null);
        Collections.sort(english.students, english);

        physics.students.addAll(studentsList);
        physics.students.removeIf(student -> student.getPhysicsLessonCount() == null);
        Collections.sort(physics.students, physics);

        Map<Lesson, List<Students>> universityMap = new HashMap<>();
        universityMap.put(math, math.students);
        universityMap.put(art, art.students);
        universityMap.put(english, english.students);
        universityMap.put(physics, physics.students);

    }


}
