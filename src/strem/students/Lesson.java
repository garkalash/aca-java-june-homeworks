package strem.students;

public final class Lesson {
    private final String name;

    public Lesson(String name) {
        this.name = name;
    }

    public String getName() {
        if(name == null){
            throw new RuntimeException("Wrong name");
        }
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Lesson)) return false;

        Lesson lesson = (Lesson) obj;

        return name.equals(lesson.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
