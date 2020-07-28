package collections.studentslist;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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
       topLessonsByGrade = new HashMap<>();
        List<Map.Entry<Lesson, Integer>> entryList = new LinkedList<>(lessonsMap.entrySet());
        entryList.sort(Map.Entry.comparingByValue());
        topLessonsByGrade.put(entryList.get(entryList.size() - 1).getKey(), entryList.get(entryList.size() - 1).getValue());
        for (int i = entryList.size() - 2; i >= 0; i--) {
            if (entryList.get(i).getValue().equals(entryList.get(entryList.size() - 1).getValue())) {
                topLessonsByGrade.put(entryList.get(i).getKey(), entryList.get(i).getValue());
            } else break;
        }
        return topLessonsByGrade;

    }

    public Integer averageGrade() {
        int averageGrade = 0;
        int count = 0;
        for (Integer value : getLessonsMap().values()) {
            averageGrade = averageGrade + value;
            count +=1;
        }
        return averageGrade/count;
    }

}


