package strem.students;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Lesson lesson1 = new Lesson("Art");
        Lesson lesson2 = new Lesson("Math");
        Lesson lesson3 = new Lesson("Physic");
        Lesson lesson4 = new Lesson("English");

        Student student1 = new Student("Aram", new HashMap<>());
        student1.getLessonsMap().put(lesson1, 4);
        student1.getLessonsMap().put(lesson2, 5);
        student1.getLessonsMap().put(lesson3, 10);

        Student student2 = new Student("Anna", new HashMap<>());
        student2.getLessonsMap().put(lesson4, 10);
        student2.getLessonsMap().put(lesson2, 6);

        Student student3 = new Student("Lilit", new HashMap<>());
        student3.getLessonsMap().put(lesson3, 5);
        student3.getLessonsMap().put(lesson2, 10);
        student3.getLessonsMap().put(lesson1, 6);
        student3.getLessonsMap().put(lesson4, 10);

        Student student4 = new Student("Karen", new HashMap<>());
        student4.getLessonsMap().put(lesson1, 9);
        student4.getLessonsMap().put(lesson4, 6);

        Map<Lesson, List<Student>> topStudentsByAverageGrade = new HashMap<>();

        List<Lesson> lessons = Arrays.asList(lesson1, lesson2, lesson3, lesson4);
        List<Student> students = Arrays.asList(student1, student2, student3, student4);

        for (Lesson lesson : lessons) {
            List<Student> sortedStudentsList = students.stream()
                    .filter(student -> student.getLessonsMap().containsKey(lesson))
                    .sorted((st1, st2) -> Student.averageGrade(st2) - Student.averageGrade(st1))
                    .collect(Collectors.toList());
            topStudentsByAverageGrade.put(lesson, sortedStudentsList);
        }
        student1.getTopLessonsByGrade();
        student2.getTopLessonsByGrade();
        student3.getTopLessonsByGrade();
        student4.getTopLessonsByGrade();

        Map<Lesson, List<Student>> studentsList = new HashMap<>(topStudentsByAverageGrade);
        Map<Lesson, List<Student>> topStudentsForEachLesson = new HashMap<>();
        for (Lesson lesson : lessons) {
            Integer max = studentsList.get(lesson).stream()
                    .max(Comparator.comparingInt(s -> s.getLessonsMap().get(lesson)))
                    .get().getLessonsMap().get(lesson);
            topStudentsForEachLesson.put(lesson, studentsList.get(lesson).stream()
                    .filter(s -> s.getLessonsMap().get(lesson).equals(max))
                    .collect(Collectors.toList()));
        }

        System.out.println(topStudentsByAverageGrade);
        System.out.println(topStudentsForEachLesson);
    }
}




