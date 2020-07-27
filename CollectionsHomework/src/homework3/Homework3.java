package homework3;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Homework3 {

    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("John", "Smith"));
        studentList.add(new Student("James", "Bond"));
        studentList.add(new Student("Angelina", "Jolie"));

        Lesson history = new Lesson("History");
        Lesson math = new Lesson("Math");
        Lesson physic = new Lesson("Physic");

        studentList.get(0).getMapGrades().put(history, 7);
        studentList.get(0).getMapGrades().put(math, 10);
        studentList.get(0).getMapGrades().put(physic, 9);

        studentList.get(1).getMapGrades().put(math, 8);
        studentList.get(1).getMapGrades().put(physic, 6);

        studentList.get(2).getMapGrades().put(history, 9);;
        studentList.get(2).getMapGrades().put(physic, 4);

        sortStudents(studentList);

        for (Student st : studentList) {
            System.out.println(st.getName());
            for (Lesson ls : st.getMapGrades().keySet()) {
                System.out.println( "\t" + " " + ls.getLesson() + " " + st.getMapGrades().get(ls));
            }
        }

        System.out.println(studentWithHighestScore(studentList));

        for (Student st : theBestStudentForEachLesson(studentList)) {
            System.out.println(st.getName());
            for (Lesson ls : st.getMapGrades().keySet()) {
                System.out.println( "\t" + " " + ls.getLesson() + " " + st.getMapGrades().get(ls));
            }
        }

    }

    public static List<Student> theBestStudentForEachLesson(List<Student> studentList) {
        Integer maxGrade = Integer.MIN_VALUE;
        String studentFirstName = "";
        String studentLastName = "";
        String lesson = "";

        Set<Lesson> allLessons = new HashSet<>();

        for (Student st : studentList) {
            for (Lesson ls : st.getMapGrades().keySet()) {
                allLessons.add(ls);
            }
        }

        List<Student> bestStudents = new ArrayList<>();

        for (Lesson ls : allLessons) {
            for (Student st : studentList) {
                if (st.getMapGrades().containsKey(ls) && st.getMapGrades().get(ls) > maxGrade) {
                    maxGrade = st.getMapGrades().get(ls);
                    studentFirstName = st.getFirstName();
                    studentLastName = st.getLastName();
                    lesson = ls.getLesson();
                }
            }
            bestStudents.add(new Student(studentFirstName, studentLastName));
            bestStudents.get(bestStudents.size() - 1).getMapGrades().put(new Lesson(lesson), maxGrade);
            maxGrade = Integer.MIN_VALUE;
        }

        return bestStudents;
    }

    public static String studentWithHighestScore(List<Student> studentList) {
        Integer maxGrade = Integer.MIN_VALUE;
        String student = "";
        String lesson = "";

        for (Student st : studentList) {
            for (Lesson ls : st.getMapGrades().keySet()) {
                if (st.getMapGrades().get(ls) > maxGrade) {
                    maxGrade = st.getMapGrades().get(ls);
                    student = st.getName();
                    lesson = ls.getLesson();
                }
            }
        }

        return student + "'s max score is " + maxGrade + " from " + lesson;
    }

    public static void sortStudents(List<Student> studentList) {
        Collections.sort(studentList,(o1, o2)->{
            int count = 0;
            double avg1 = 0;
            double avg2 = 0;
            for (Integer grade : o1.getMapGrades().values()) {
                ++count;
                avg1 += grade;
            }

            if (count != 0) {
                avg1 /= count;
            }

            count = 0;

            for (Integer grade : o2.getMapGrades().values()) {
                ++count;
                avg2 += grade;
            }

            if (count != 0) {
                avg2 /= count;
            }

            if (avg1 > avg2)
                return 1;
            else if (avg1 == avg2)
                return 0;
            else
                return -1;
        });
    }
}
