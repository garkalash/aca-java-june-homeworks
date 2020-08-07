package com.aca.naresilanyan.collectionHomework;

import java.util.Objects;

final class Lesson {
    private String name;

    public Lesson(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lesson lesson = (Lesson) o;
        return name.equals(lesson.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
