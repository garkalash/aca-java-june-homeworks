package collections.studentslist;

import java.util.*;

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
            for (Student student : students) {
                if (student.getLessonsMap().containsKey(lesson)) {
                    topStudentsByAverageGrade.putIfAbsent(lesson, new ArrayList<Student>());
                    topStudentsByAverageGrade.get(lesson).add(student);
                }
            }
            topStudentsByAverageGrade.get(lesson).sort(new Comparator<Student>() {
                @Override
                public int compare(Student st1, Student st2) {
                    return st2.averageGrade() - st1.averageGrade();
                }
            });
        }
        student1.getTopLessonsByGrade();
        student2.getTopLessonsByGrade();
        student3.getTopLessonsByGrade();
        student4.getTopLessonsByGrade();

        Map<Lesson, List<Student>> studentsList = new HashMap<>(topStudentsByAverageGrade);
        Map<Lesson, List<Student>> topStudentsForEachLesson = new HashMap<>();

        for (Lesson lesson : lessons) {
            studentsList.get(lesson).sort(new Comparator<Student>() {
                @Override
                public int compare(Student st1, Student st2) {
                    return st2.getLessonsMap().get(lesson) - st1.getLessonsMap().get(lesson);
                }
            });

            List<Student> students1 = new ArrayList<>();
            students1.add(studentsList.get(lesson).get(0));

            for (int i = 1; i < studentsList.get(lesson).size(); i++) {
                Student currentStudent = studentsList.get(lesson).get(i);
                if (currentStudent.getLessonsMap().get(lesson).equals(studentsList.get(lesson).get(0).getLessonsMap().get(lesson))) {
                    students1.add(currentStudent);
                } else break;
            }
            topStudentsForEachLesson.put(lesson, students1);

        }

        System.out.println(topStudentsByAverageGrade);
        System.out.println(topStudentsForEachLesson);
    }
}




