package homework3;

import java.util.HashMap;
import java.util.Map;

public class Student {
    private final String firstName;
    private final String lastName;
    private Map<Lesson, Integer> mapGrades = new HashMap<>();

    Student(String fName, String lName) {
        this.firstName = fName;
        this.lastName = lName;
    }

    public String getName() {
        return this.firstName + " " + this.lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Map<Lesson, Integer> getMapGrades() {
        return mapGrades;
    }

}
