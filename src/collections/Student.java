package collections;

import java.util.List;

public class Student {
    private List<String> lessons;
    private String name;

    public Student(List<String> lessons, String name) {
        this.lessons = lessons;
        this.name = name;
    }

    public List<String> getLessons() {
        return lessons;
    }

    public String getName() {
        return name;
    }
}
