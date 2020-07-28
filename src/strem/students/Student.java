package strem.students;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Student {
    private final String name;
    private final Map<Lesson, Integer> lessonsMap;
    private Map<Lesson, Integer> topLessonsByGrade;

    public Student(String name, Map<Lesson, Integer> lessonsMap) {
        this.name = name;
        this.lessonsMap = lessonsMap;
    }

    public String getName() {
        return name;
    }

    public Map<Lesson, Integer> getLessonsMap() {
        return lessonsMap;
    }

    public Map<Lesson, Integer> getTopLessonsByGrade() {
        Integer max = lessonsMap.values().stream().max(Integer::compareTo).get();
        topLessonsByGrade = lessonsMap.entrySet().stream()
                .filter(x -> x.getValue().equals(max))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        return topLessonsByGrade;

    }

    public static Integer averageGrade(Student student) {
        int averageGrade = 0;
        int count = 0;
        for (Integer value : student.getLessonsMap().values()) {
            averageGrade = averageGrade + value;
            count +=1;
        }
        return averageGrade/count;
    }


}


