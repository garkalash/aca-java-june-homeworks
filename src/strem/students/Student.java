package strem.students;


import com.aca.armine.collections.studentslist.Lesson;

import java.util.*;
import java.util.stream.Collectors;

public class Student {
    private final String name;
    private Map<Lesson, Integer> lessonsMap;
    private Map<Lesson, Integer> topLessonsByGrade;


    public Student(String name, Map<Lesson, Integer> lessonsMap) {
        this.name = name;
        this.lessonsMap = lessonsMap;
    }

    public void putLesson(Lesson lesson, Integer grade) {
        lessonsMap.put(lesson, grade);
    }

    public String getName() {
        return name;
    }

    public Map<Lesson, Integer> putLesson() {
        return lessonsMap;
    }

    public Map<Lesson, Integer> getTopLessonsByGrade() {
        Integer max = lessonsMap.values().stream().max(Integer::compareTo).get();
        topLessonsByGrade = lessonsMap.entrySet().stream()
                .filter(x -> x.getValue().equals(max))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        return topLessonsByGrade;

    }

    public Integer averageGrade() {
        int averageGrade = 0;
        int count = 0;
        for (Integer value : putLesson().values()) {
            averageGrade = averageGrade + value;
            count += 1;
        }
        return averageGrade / count;
    }


}


